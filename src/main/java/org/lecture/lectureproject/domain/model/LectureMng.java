package org.lecture.lectureproject.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "lecture_mng")
@Getter @Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Builder
public class LectureMng {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가
    private Long id;  // id

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "lecture_id")
    private Long lectureId;  // 강의 과목

    @Column(updatable = false)
    @CreatedBy
    private LocalDateTime regDate;  // 등록일

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedBy
    private LocalDateTime updtDate;  // 수정일


    public LectureMng() {

    }

    public LectureMng(Long id, Long userId, Long lectureId, LocalDateTime regDate, LocalDateTime updtDate) {
        this.id = id;
        this.userId = userId;
        this.lectureId = lectureId;
        this.regDate = regDate;
        this.updtDate = updtDate;
    }


}