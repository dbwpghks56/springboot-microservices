package net.javaguides.departmentservice.common.exception.department;

import org.springframework.http.HttpStatus;

public class DepartmentNotFoundException extends DepartmentException {
    private static final String MESSAGE = "존재하지 않는 부서입니다.";
    private static final String CODE = "COMMENT-400";

    public DepartmentNotFoundException() {
        super(CODE, HttpStatus.BAD_REQUEST ,MESSAGE);
    }

}
