package net.javajh.userservice.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class UserLoginRequestDto {
    private String username;
    private String password;
}
