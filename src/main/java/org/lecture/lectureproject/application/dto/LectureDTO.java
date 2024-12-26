package org.lecture.lectureproject.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
@Getter
@Setter
public class LectureDTO {
    private int id;
    private String userName;
    private String subjectName;
    private Date date;
    private LocalTime time;
    private String location;
    private int capacity;

    public LectureDTO() {}
    public LectureDTO(int id, String userName, String subjectName, Date date, LocalTime time, String location, int capacity) {
        this.id = id;
        this.userName = userName;
        this.subjectName = subjectName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.capacity = capacity;
    }
}
