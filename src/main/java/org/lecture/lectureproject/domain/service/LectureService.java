package org.lecture.lectureproject.domain.service;

import org.lecture.lectureproject.application.dto.LectureDTO;
import org.lecture.lectureproject.application.dto.LectureListRequest;
import org.lecture.lectureproject.domain.model.Lecture;
import org.lecture.lectureproject.domain.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lectureRepository;

    public void applyLecture(Long lectureId, Long userId) {


    }

    //강의 조회
    public List<Object[]>  selectLecture(LectureListRequest request) {
        if(request==null){
            request = new LectureListRequest();
        }
        return lectureRepository.findByDateRange(request.getStartDate(), request.getEndDate());
    }




}
