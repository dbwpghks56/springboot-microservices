package net.javajh.userservice.presentation;

import lombok.RequiredArgsConstructor;
import net.javajh.userservice.application.UserFacade;
import net.javajh.userservice.common.CommonResponse;
import net.javajh.userservice.presentation.dto.request.AuthTestRequestDto;
import net.javajh.userservice.presentation.dto.request.UserLoginRequestDto;
import net.javajh.userservice.presentation.dto.request.UserRegistryRequestDto;
import net.javajh.userservice.presentation.dto.response.AuthResponseDto;
import net.javajh.userservice.presentation.dto.response.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final UserFacade userFacade;

    @PostMapping("/registry")
    public ResponseEntity<CommonResponse<UserResponseDto>> userRegistry(
            @RequestBody UserRegistryRequestDto userRegistryRequestDto
            ) {
        return new ResponseEntity<>(CommonResponse.success(userFacade.signUp(userRegistryRequestDto)), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<AuthResponseDto>> userLogin(
            @RequestBody UserLoginRequestDto userLoginRequestDto
            ) {
        return ResponseEntity.ok(CommonResponse.success(userFacade.login(userLoginRequestDto)));
    }

    @PostMapping("/userdata")
    public ResponseEntity<CommonResponse<UserResponseDto>> getUserData(
            @RequestBody AuthTestRequestDto authTestRequestDto
    ) {
        return ResponseEntity.ok(CommonResponse.success(userFacade.getUserDate(authTestRequestDto.getAccessToken())));
    }

    @GetMapping("/username")
    public ResponseEntity<CommonResponse<String>> getUsername(
            @RequestParam String token
    ) {
        return ResponseEntity.ok(CommonResponse.success(userFacade.getUsername(token)));
    }
}
