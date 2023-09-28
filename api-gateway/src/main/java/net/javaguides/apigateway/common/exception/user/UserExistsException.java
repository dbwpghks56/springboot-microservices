package net.javaguides.apigateway.common.exception.user;

import org.springframework.http.HttpStatus;

public class UserExistsException extends UserException{
    public final static String errorCode = "USER_401";
    public final static String errorContent = "해당 user 는 이미 존재합니다.";


    public UserExistsException() {
        super(errorCode, HttpStatus.BAD_REQUEST, errorContent);
    }
}
