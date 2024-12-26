package org.lecture.lectureproject.domain.model;


import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "lecture")
@EntityListeners(AuditingEntityListener.class)
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가
    private Long id;  // id

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "subject_id")
    private Long subjectId;  // 강의 과목

    @Temporal(TemporalType.DATE)
    private Date date;  // 강의 날짜

    private String location;  // 강의 장소
    private int capacity;  // 강의 정원
    private LocalTime time;  // 강의 시작 시간

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;  // 등록일

    @Temporal(TemporalType.TIMESTAMP)
    private Date updtDate;  // 수정일

    // 기본 생성자
    public Lecture() {}

    // 생성자
    public Lecture(Long subjectId, Date date, String location, int capacity, LocalTime time) {
        this.subjectId = subjectId;
        this.date = date;
        this.location = location;
        this.capacity = capacity;
        this.time = time;
    }

    // Getter, Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getUpdtDate() {
        return updtDate;
    }

    public void setUpdtDate(Date updtDate) {
        this.updtDate = updtDate;
    }
}
