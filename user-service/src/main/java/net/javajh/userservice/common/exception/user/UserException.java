package net.javajh.userservice.common.exception.user;

import net.javajh.userservice.common.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class UserException extends ApplicationException {
    protected UserException(String errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }
}
