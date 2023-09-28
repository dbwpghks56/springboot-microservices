package net.javaguides.apigateway.presentation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.javaguides.apigateway.application.UserFacade;
import net.javaguides.apigateway.common.CommonResponse;
import net.javaguides.apigateway.common.LoginUser;
import net.javaguides.apigateway.domain.User;
import net.javaguides.apigateway.presentation.dto.request.UserLoginRequestDto;
import net.javaguides.apigateway.presentation.dto.request.UserRequestDto;
import net.javaguides.apigateway.presentation.dto.response.AuthResponseDto;
import net.javaguides.apigateway.presentation.dto.response.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final UserFacade userFacade;

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse<UserResponseDto>> signUp(
            @RequestBody UserRequestDto userRequestDto
            ) {
        return new ResponseEntity<>(CommonResponse.success(userFacade.signUp(userRequestDto)), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<AuthResponseDto>> login(
            @RequestBody UserLoginRequestDto userLoginRequestDto
            ) {
        return ResponseEntity.ok(CommonResponse.success(userFacade.login(userLoginRequestDto)));
    }

    @GetMapping
    public ResponseEntity<CommonResponse<UserResponseDto>> check(
            @LoginUser User user
            ) {
        return ResponseEntity.ok(CommonResponse.success(userFacade.check(user)));
    }
}
