package org.lecture.lectureproject.domain.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "app_user")
@EntityListeners(AuditingEntityListener.class)
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가
    private Long id;  // id

    @Column(name = "rold_id")
    private Long roldId;

    private String name;
    private String phone;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;  // 등록일

    @Temporal(TemporalType.TIMESTAMP)
    private Date updtDate;  // 수정일

    public User() {}

    public User(Long id, Long roldId, String name, String phone, Date regDate, Date updtDate) {
        this.id = id;
        this.roldId = roldId;
        this.name = name;
        this.phone = phone;
        this.regDate = regDate;
        this.updtDate = updtDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoldId() {
        return roldId;
    }

    public void setRoldId(Long roldId) {
        this.roldId = roldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
