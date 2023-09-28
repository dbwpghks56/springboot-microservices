package net.javaguides.apigateway.application;

import lombok.RequiredArgsConstructor;
import net.javaguides.apigateway.domain.User;
import net.javaguides.apigateway.domain.service.UserCommandUseCase;
import net.javaguides.apigateway.presentation.dto.request.UserLoginRequestDto;
import net.javaguides.apigateway.presentation.dto.request.UserRequestDto;
import net.javaguides.apigateway.presentation.dto.response.AuthResponseDto;
import net.javaguides.apigateway.presentation.dto.response.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserCommandUseCase userCommandUseCase;

    public AuthResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        return userCommandUseCase.login(userLoginRequestDto);
    }

    public UserResponseDto signUp(UserRequestDto userRequestDto) {
        return userCommandUseCase.signUp(userRequestDto);
    }

    public UserResponseDto check(User user) {
        return userCommandUseCase.check(user);
    }
}
