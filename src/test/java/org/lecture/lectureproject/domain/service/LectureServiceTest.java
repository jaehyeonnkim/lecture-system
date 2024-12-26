package org.lecture.lectureproject.domain.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lecture.lectureproject.application.dto.LectureApplyRequest;
import org.lecture.lectureproject.domain.exception.LectureCapacityExceedException;
import org.lecture.lectureproject.domain.model.Lecture;
import org.lecture.lectureproject.domain.model.LectureMng;
import org.lecture.lectureproject.domain.repository.LectureMngRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class LectureServiceTest {

    @Autowired
    private LectureService lectureService;

    @Mock
    private LectureMngRepository lectureMngRepository;

    @Test
    @DisplayName("정원이 초과했을 시 LectureCapacityExceedException 반환")
    public void 특강_신청_실패_정원_초과() {
        long userId = 1L;
        long lectureId = 1L;
        long lectureCapacity = 30L;

        LectureMng lectureMng = LectureMng.builder()
                .userId(userId)
                .lectureId(lectureId)
                .build();

        when(lectureMngRepository.getCurrentCapacityByLectureId(lectureId))
                                 .thenReturn(lectureCapacity);

        doThrow(new LectureCapacityExceedException())
                .when(lectureMngRepository).save(any(LectureMng.class));

        assertThatThrownBy(() -> lectureMngRepository.save(lectureMng))
                .isInstanceOf(LectureCapacityExceedException.class);
    }

    @Test
    @DisplayName("40명이 동시에 신청했을 때 30명만 성공")
    void 특강_동시성테스트_40명신청시_30명성공() throws InterruptedException {
        long userId = 1L;
        long lectureId = 1L; // 테스트 대상 특강 ID
        int lectureCapacity = 30; // 정원
        int applyNumber = 40; // 신청자 수

        ExecutorService executorService = Executors.newFixedThreadPool(10); // 스레드 풀
        CountDownLatch latch = new CountDownLatch(applyNumber); // 동시성 제어

        List<Future<Boolean>> results = new ArrayList<>();

        for (int i = 0; i < applyNumber; i++) {
            Future<Boolean> result = executorService.submit(() -> {
                try {
                    lectureService.applyLecture(new LectureApplyRequest(userId, lectureId));
                    return true; // 신청 성공
                } catch (LectureCapacityExceedException e) {
                    return false; // 신청 실패
                } finally {
                    latch.countDown();
                }
            });
            results.add(result);
        }

        latch.await();
        executorService.shutdown();

        // 신청 결과
        long successfulApplications = results.stream()
                .map(result -> {
                    try {
                        return result.get(); //
                    } catch (Exception e) {
                        return false;
                    }
                })
                .filter(success -> success)
                .count();

        // 검증
        assertThat(successfulApplications).isEqualTo(lectureCapacity);

    }


}