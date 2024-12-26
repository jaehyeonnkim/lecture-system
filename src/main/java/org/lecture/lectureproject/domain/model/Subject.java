package org.lecture.lectureproject.domain.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "subject")
@EntityListeners(AuditingEntityListener.class)
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가
    private Long id;

    private String name;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;  // 등록일

    @Temporal(TemporalType.TIMESTAMP)
    private Date updtDate;  // 수정일

    public Subject() {}
    public Subject(Long id, String name, Date regDate, Date updtDate) {
        this.id = id;
        this.name = name;
        this.regDate = regDate;
        this.updtDate = updtDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
