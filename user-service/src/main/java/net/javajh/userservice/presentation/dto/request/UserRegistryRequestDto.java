package net.javajh.userservice.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.javajh.userservice.domain.User;

@Getter
@NoArgsConstructor
@ToString
public class UserRegistryRequestDto {
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
