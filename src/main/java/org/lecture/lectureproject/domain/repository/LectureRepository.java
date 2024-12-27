package org.lecture.lectureproject.domain.repository;

import org.lecture.lectureproject.application.dto.LectureApplyResponse;
import org.lecture.lectureproject.domain.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.lecture.lectureproject.application.dto.LectureDTO;
import java.util.Date;
import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    // 날짜 범위로 강의를 조회하는 쿼리
    @Query("SELECT lec.id, u.name, sub.name, lec.date, lec.time, lec.location, lec.capacity " +
            "FROM Lecture lec " +
            "LEFT JOIN User u ON lec.userId = u.id " +
            "LEFT JOIN Subject sub ON lec.subjectId = sub.id " +
            "LEFT JOIN LectureMng mng ON mng.id = lec.id " +
            "GROUP BY lec.id, lec.capacity " +
            "HAVING COUNT(mng.lectureId) < lec.capacity")
    List<Object[]> findByDateRange(Date startDate, Date endDate);

    @Query("SELECT mng.id, lec.id, u.name " +
            "FROM LectureMng mng " +
            "LEFT JOIN User u ON mng.userId = u.id " +
            "LEFT JOIN Lecture lec ON lec.id = mng.lectureId " +
            "WHERE mng.userId = :userId")
    List<Object[]> findByUserId(long userId);
}
