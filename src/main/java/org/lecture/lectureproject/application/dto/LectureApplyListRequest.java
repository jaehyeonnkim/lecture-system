package org.lecture.lectureproject.application.dto;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LectureApplyListRequest {
    private long userId;
}