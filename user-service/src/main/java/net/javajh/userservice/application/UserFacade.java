package net.javajh.userservice.application;

import lombok.RequiredArgsConstructor;
import net.javajh.userservice.domain.service.UserCommandUseCase;
import net.javajh.userservice.presentation.dto.request.UserLoginRequestDto;
import net.javajh.userservice.presentation.dto.request.UserRegistryRequestDto;
import net.javajh.userservice.presentation.dto.response.AuthResponseDto;
import net.javajh.userservice.presentation.dto.response.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserCommandUseCase userCommandUseCase;

    public UserResponseDto signUp(UserRegistryRequestDto userRegistryRequestDto) {
        return userCommandUseCase.signUp(userRegistryRequestDto);
    }

    public AuthResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        return userCommandUseCase.login(userLoginRequestDto);
    }

    public UserResponseDto getUserDate(String token) {
        return userCommandUseCase.getUserData(token);
    }

    public String getUsername(String token) {
        return userCommandUseCase.getUsername(token);
    }
}
