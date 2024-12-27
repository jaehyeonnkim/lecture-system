package org.lecture.lectureproject.application.facade;


import org.lecture.lectureproject.application.dto.*;
import org.lecture.lectureproject.application.service.LectureApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class LectureFacade {

    private final LectureApplicationService applicationService;

    public LectureFacade(LectureApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    //강의 신청
    public LectureApplyResponse applyLecture(LectureApplyRequest request) {
        return applicationService.applyLecture(request);
    }

    //강의 조회
    public List<Object[]>  selectLecture(LectureListRequest request) {
        return applicationService.selectLecture(request);
    }

    //신청한 강의 조회
    public List<Object[]>  selectApplyLecture(LectureApplyListRequest request) {
        return applicationService.selectApplyLecture(request);
    }

}

