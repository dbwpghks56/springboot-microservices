package net.javaguides.organizationservice.common.exception.organization;

import net.javaguides.organizationservice.common.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class OrganizationException extends ApplicationException {
    protected OrganizationException(String errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }
}
