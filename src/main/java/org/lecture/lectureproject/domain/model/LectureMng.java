package org.lecture.lectureproject.domain.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "lecture_mng")
@EntityListeners(AuditingEntityListener.class)
public class LectureMng {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가
    private Long id;  // id

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "lecture_id")
    private Long lectureId;  // 강의 과목

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;  // 등록일

    @Temporal(TemporalType.TIMESTAMP)
    private Date updtDate;  // 수정일

    public LectureMng() {}
    public LectureMng(Long id, Long userId, Long lectureId, Date regDate, Date updtDate) {
        this.id = id;
        this.userId = userId;
        this.lectureId = lectureId;
        this.regDate = regDate;
        this.updtDate = updtDate;
    }

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

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
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