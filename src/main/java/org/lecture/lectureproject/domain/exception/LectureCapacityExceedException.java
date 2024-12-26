package org.lecture.lectureproject.domain.exception;

import org.lecture.lectureproject.exception.CustomException;

public class LectureCapacityExceedException extends CustomException {
        public LectureCapacityExceedException() {
                super(400, "정원이 마감된 수강입니다.");
        }
}
