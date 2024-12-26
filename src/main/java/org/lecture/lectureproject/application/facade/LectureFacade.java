package org.lecture.lectureproject.application.facade;


import org.lecture.lectureproject.application.dto.LectureApplyRequest;
import org.lecture.lectureproject.application.dto.LectureDTO;
import org.lecture.lectureproject.application.dto.LectureListRequest;
import org.lecture.lectureproject.application.service.LectureApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.lecture.lectureproject.domain.model.Lecture;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class LectureFacade {

    private final LectureApplicationService applicationService;

    public LectureFacade(LectureApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public void applyLecture(LectureApplyRequest request) {
        applicationService.applyLecture(request);
    }

    public List<Object[]>  selectLecture(LectureListRequest request) {
        return applicationService.selectLecture(request);
    }

}

