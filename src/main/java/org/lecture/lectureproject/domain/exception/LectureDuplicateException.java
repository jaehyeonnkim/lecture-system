package org.lecture.lectureproject.domain.exception;

import org.lecture.lectureproject.exception.CustomException;

public class LectureDuplicateException extends CustomException {
    public LectureDuplicateException() {
        super(401, "동일한 강의는 수강할 수 없습니다");
    }
}
