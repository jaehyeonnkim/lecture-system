package org.lecture.lectureproject.application.service;

import org.lecture.lectureproject.application.dto.LectureApplyRequest;
import org.lecture.lectureproject.application.dto.LectureDTO;
import org.lecture.lectureproject.application.dto.LectureListRequest;
import org.lecture.lectureproject.domain.model.Lecture;
import org.lecture.lectureproject.domain.service.LectureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureApplicationService {
    private final LectureService domainService;

    public LectureApplicationService(LectureService domainService) {
        this.domainService = domainService;
    }

    public void applyLecture(LectureApplyRequest request) {
        domainService.applyLecture(request.getLectureId(), request.getUserId());
    }

    public List<Object[]>  selectLecture(LectureListRequest request) {
        return domainService.selectLecture(request);
    }
}
