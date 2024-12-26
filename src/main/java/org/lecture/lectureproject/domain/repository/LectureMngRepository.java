package org.lecture.lectureproject.domain.repository;

import jakarta.persistence.LockModeType;
import org.lecture.lectureproject.domain.model.Lecture;
import org.lecture.lectureproject.domain.model.LectureMng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureMngRepository extends JpaRepository<LectureMng, Long> {

    @Query("SELECT COUNT(*) FROM LectureMng " +
            "WHERE lectureId = :lectureId")
    long getCurrentCapacityByLectureId(long lectureId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT mng FROM LectureMng mng WHERE mng.lectureId = :lectureId")
    Optional<LectureMng> findByIdWithLock(long lectureId);
}
