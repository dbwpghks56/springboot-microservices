package net.javaguides.employeeservice.common.exception.employee;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends EmployeeException{
    private static final String MESSAGE = "해당 직원을 찾을 수 없습니다.";
    private static final String CODE = "EMPLOYEE-404";

    public EmployeeNotFoundException() {
        super(CODE, HttpStatus.BAD_REQUEST, MESSAGE);
    }
}
