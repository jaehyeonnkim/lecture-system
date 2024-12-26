package org.lecture.lectureproject.controller;


import org.lecture.lectureproject.application.dto.LectureApplyRequest;
import org.lecture.lectureproject.application.dto.LectureDTO;
import org.lecture.lectureproject.application.dto.LectureListRequest;
import org.lecture.lectureproject.application.facade.LectureFacade;
import org.lecture.lectureproject.domain.model.Lecture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LectureController {
    private final LectureFacade lectureFacade;

    public LectureController(LectureFacade lectureFacade) {
        this.lectureFacade = lectureFacade;
    }

    //강의 조회
    @PostMapping("/lectures")
    public List<Object[]>  selectLecture (@RequestBody(required = false) LectureListRequest requestDto){
        List<Object[]> lecture = lectureFacade.selectLecture(requestDto);
        ResponseEntity.ok("강의가 성공적으로 조회되었습니다.");
        return lecture;
    }

    @PostMapping("/{lectureId}/apply")
    public ResponseEntity<String> applyLecture(@PathVariable Long lectureId, @RequestBody LectureApplyRequest request) {

        request.setLectureId(lectureId); // URL의 lectureId를 설정
        lectureFacade.applyLecture(request);
        return ResponseEntity.ok("강의가 성공적으로 신청되었습니다.");
    }


}

