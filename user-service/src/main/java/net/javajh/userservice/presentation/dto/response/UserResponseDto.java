package net.javajh.userservice.presentation.dto.response;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;
}
