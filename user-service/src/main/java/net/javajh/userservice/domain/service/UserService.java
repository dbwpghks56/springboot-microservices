package net.javajh.userservice.domain.service;

import lombok.RequiredArgsConstructor;
import net.javajh.userservice.common.exception.user.UserAlreadyUseException;
import net.javajh.userservice.common.exception.user.UserNotFoundException;
import net.javajh.userservice.config.JwtProvider;
import net.javajh.userservice.domain.User;
import net.javajh.userservice.domain.repository.UserRepository;
import net.javajh.userservice.presentation.dto.request.UserLoginRequestDto;
import net.javajh.userservice.presentation.dto.request.UserRegistryRequestDto;
import net.javajh.userservice.presentation.dto.response.AuthResponseDto;
import net.javajh.userservice.presentation.dto.response.UserResponseDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserCommandUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public UserResponseDto signUp(UserRegistryRequestDto userRegistryRequestDto) {
        if(userRepository.userAlready(userRegistryRequestDto.getUsername())) {
            throw new UserAlreadyUseException();
        } else {
            String password = passwordEncoder.encode(userRegistryRequestDto.getPassword());
            User user = userRepository.signUp(userRegistryRequestDto.toEntity(password));

            return user.toResponseDto();
        }
    }

    @Override
    public AuthResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        User user = userRepository.login(userLoginRequestDto.getUsername(), userLoginRequestDto.getPassword())
                .orElseThrow(UserNotFoundException::new);

        UserResponseDto userResponseDto = user.toResponseDto();

        String accessToken = jwtProvider.generateAccessToken(userResponseDto.getUsername(),
                userResponseDto);

        String refreshToken = jwtProvider.generateRefreshToken(userResponseDto.getUsername());

        return AuthResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public UserResponseDto getUserData(String token) {
        if(jwtProvider.validToken(token)) {
            return (UserResponseDto) jwtProvider.getUserDataAccessToken(token);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public String getUsername(String token) {
        if(jwtProvider.validToken(token)) {
            return jwtProvider.getUsernameAccessToken(token);
        } else {
            throw new RuntimeException();
        }
    }
}
