package net.javaguides.departmentservice.common.exception.department;

import net.javaguides.departmentservice.common.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class DepartmentException extends ApplicationException {
    protected DepartmentException(String errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }
}
