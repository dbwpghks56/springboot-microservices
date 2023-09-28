package net.javaguides.apigateway.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserLoginRequestDto {
    private String username;
    private String password;
}
