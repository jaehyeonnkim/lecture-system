package org.lecture.lectureproject.application.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LectureApplyRequest {
    private long userId;
    private long lectureId;
}