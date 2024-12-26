package org.lecture.lectureproject.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lecture.lectureproject.application.dto.LectureApplyRequest;
import org.lecture.lectureproject.application.dto.LectureApplyResponse;
import org.lecture.lectureproject.application.dto.LectureDTO;
import org.lecture.lectureproject.application.dto.LectureListRequest;
import org.lecture.lectureproject.domain.exception.LectureCapacityExceedException;
import org.lecture.lectureproject.domain.model.Lecture;
import org.lecture.lectureproject.domain.model.LectureMng;
import org.lecture.lectureproject.domain.repository.LectureMngRepository;
import org.lecture.lectureproject.domain.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LectureService {


    private final LectureRepository lectureRepository;
    private final LectureMngRepository lectureMngRepository;



    //강의 신청
    public LectureApplyResponse applyLecture(LectureApplyRequest request) {
        Optional<LectureMng> existingLecture = lectureMngRepository.findByIdWithLock(request.getLectureId());

        long getCurrentCapacity = lectureMngRepository.getCurrentCapacityByLectureId(request.getLectureId());

        //정원확인
        if (getCurrentCapacity >= 30) {
            throw new LectureCapacityExceedException();
        }

        LectureMng lectureMng = LectureMng.builder()
                .lectureId(request.getLectureId())
                .userId(request.getUserId())
                .build();

        // 엔티티 저장
        lectureMngRepository.save(lectureMng);

        return LectureApplyResponse.builder()
                .message("성공적으로 신청되었습니다.")
                .code("00")
                .build();
    }

    //강의 조회
    public List<Object[]>  selectLecture(LectureListRequest request) {
        if(request==null){
            request = new LectureListRequest();
        }
        return lectureRepository.findByDateRange(request.getStartDate(), request.getEndDate());
    }




}
