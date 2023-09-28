package net.javaguides.apigateway.domain.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.apigateway.common.exception.user.UserExistsException;
import net.javaguides.apigateway.config.security.provider.JwtTokenProvider;
import net.javaguides.apigateway.domain.User;
import net.javaguides.apigateway.domain.repository.UserRepository;
import net.javaguides.apigateway.presentation.dto.request.UserLoginRequestDto;
import net.javaguides.apigateway.presentation.dto.request.UserRequestDto;
import net.javaguides.apigateway.presentation.dto.response.AuthResponseDto;
import net.javaguides.apigateway.presentation.dto.response.UserResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserCommandUseCase {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginRequestDto.getUsername(),
                userLoginRequestDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return AuthResponseDto.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(authentication))
                .refreshToken(jwtTokenProvider.generateRefreshToken(authentication))
                .build();
    }

    @Override
    public UserResponseDto signUp(UserRequestDto userRequestDto) {
        if (userRepository.existsByUsername(userRequestDto.getUsername())) {
            throw new UserExistsException();
        }
        String password = passwordEncoder.encode(userRequestDto.getPassword());

        User user = userRepository.save(userRequestDto.toEntity(password));

        return user.toUserResponseDto();
    }

    @Override
    public UserResponseDto check(User user) {
        return user.toUserResponseDto();
    }
}
