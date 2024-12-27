package org.lecture.lectureproject.application.service;

import org.lecture.lectureproject.application.dto.LectureApplyListRequest;
import org.lecture.lectureproject.application.dto.LectureApplyRequest;
import org.lecture.lectureproject.application.dto.LectureApplyResponse;
import org.lecture.lectureproject.application.dto.LectureListRequest;
import org.lecture.lectureproject.domain.service.LectureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureApplicationService {
    private final LectureService domainService;

    public LectureApplicationService(LectureService domainService) {
        this.domainService = domainService;
    }

    public LectureApplyResponse applyLecture(LectureApplyRequest request) {
        return domainService.applyLecture(request);
    }

    public List<Object[]>  selectLecture(LectureListRequest request) {
        return domainService.selectLecture(request);
    }

    public List<Object[]> selectApplyLecture(LectureApplyListRequest request) {
        return domainService.selectApplyLecture(request);
    }
}
