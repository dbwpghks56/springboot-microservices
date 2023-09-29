package net.javajh.userservice.domain.service;

import net.javajh.userservice.presentation.dto.request.UserLoginRequestDto;
import net.javajh.userservice.presentation.dto.request.UserRegistryRequestDto;
import net.javajh.userservice.presentation.dto.response.AuthResponseDto;
import net.javajh.userservice.presentation.dto.response.UserResponseDto;

public interface UserCommandUseCase {
    UserResponseDto signUp(UserRegistryRequestDto userRegistryRequestDto);
    AuthResponseDto login(UserLoginRequestDto userLoginRequestDto);

    UserResponseDto getUserData(String token);

    String getUsername(String token);
}
