package org.lecture.lectureproject.application.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LectureListResponse {
    private String lectureId;
    private int capacity;
    private String location;
}
