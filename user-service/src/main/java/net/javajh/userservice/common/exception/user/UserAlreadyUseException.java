package net.javajh.userservice.common.exception.user;

import org.springframework.http.HttpStatus;

public class UserAlreadyUseException extends UserException{
    private static final String errorCode = "user-401";
    private static final String message = "이미 존재하는 유저입니다.";

    public UserAlreadyUseException() {
        super(errorCode, HttpStatus.BAD_REQUEST, message);
    }
}
