package net.javaguides.apigateway.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.javaguides.apigateway.domain.User;

@Getter
@ToString
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String password;
    private String nickname;
    private String email;

    public User toEntity(String encodePassword) {
        return User.builder()
                .username(username)
                .password(encodePassword)
                .nickname(nickname)
                .email(email)
                .build();
    }
}
