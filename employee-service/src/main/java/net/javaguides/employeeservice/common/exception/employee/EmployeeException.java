package net.javaguides.employeeservice.common.exception.employee;

import net.javaguides.employeeservice.common.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class EmployeeException extends ApplicationException {
    protected EmployeeException(String errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }
}
