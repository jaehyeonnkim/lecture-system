package org.lecture.lectureproject.application.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LectureListRequest {
    private Date startDate;
    private Date endDate;
}

