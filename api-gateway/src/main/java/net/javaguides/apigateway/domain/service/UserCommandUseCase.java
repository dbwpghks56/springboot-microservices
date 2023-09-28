package net.javaguides.apigateway.domain.service;

import net.javaguides.apigateway.domain.User;
import net.javaguides.apigateway.presentation.dto.request.UserLoginRequestDto;
import net.javaguides.apigateway.presentation.dto.request.UserRequestDto;
import net.javaguides.apigateway.presentation.dto.response.AuthResponseDto;
import net.javaguides.apigateway.presentation.dto.response.UserResponseDto;

public interface UserCommandUseCase {
    AuthResponseDto login(UserLoginRequestDto userLoginRequestDto);
    UserResponseDto signUp(UserRequestDto userRequestDto);

    UserResponseDto check(User user);
}
