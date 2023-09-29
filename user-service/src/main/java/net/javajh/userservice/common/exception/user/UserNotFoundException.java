package net.javajh.userservice.common.exception.user;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {
    private static final String errorCode = "user-404";
    private static final String message = "유저가 발견되지 않습니다.";

    public UserNotFoundException() {
        super(errorCode, HttpStatus.NOT_FOUND, message);
    }
}
