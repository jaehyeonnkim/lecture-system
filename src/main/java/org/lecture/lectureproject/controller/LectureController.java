package org.lecture.lectureproject.controller;


import lombok.extern.slf4j.Slf4j;
import org.lecture.lectureproject.application.dto.LectureApplyRequest;
import org.lecture.lectureproject.application.dto.LectureApplyResponse;
import org.lecture.lectureproject.application.dto.LectureDTO;
import org.lecture.lectureproject.application.dto.LectureListRequest;
import org.lecture.lectureproject.application.facade.LectureFacade;
import org.lecture.lectureproject.domain.model.Lecture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api")
public class LectureController {
    private final LectureFacade lectureFacade;

    public LectureController(LectureFacade lectureFacade) {
        this.lectureFacade = lectureFacade;
    }

    //강의 조회
    @PostMapping("/lectures")
    public List<Object[]>  selectLecture (@RequestBody(required = false) LectureListRequest request){
        List<Object[]> lecture = lectureFacade.selectLecture(request);
        ResponseEntity.ok("강의가 성공적으로 조회되었습니다.");
        return lecture;
    }

    @PostMapping("/apply")
    public LectureApplyResponse applyLecture(@RequestBody LectureApplyRequest request) {

        lectureFacade.applyLecture(request);

        return LectureApplyResponse.builder()
                .message("성공적으로 신청되었습니다.")
                .code("00")
                .build();
    }

}

