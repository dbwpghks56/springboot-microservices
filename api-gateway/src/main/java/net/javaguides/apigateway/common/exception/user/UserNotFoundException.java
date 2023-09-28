package net.javaguides.apigateway.common.exception.user;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{
    public final static String errorCode = "USER_404";
    public final static String errorContent = "해당 user 가 없습니다.";


    public UserNotFoundException() {
        super(errorCode, HttpStatus.NOT_FOUND, errorContent);
    }
}
