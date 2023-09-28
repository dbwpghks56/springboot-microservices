package net.javaguides.apigateway.presentation.dto.response;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserResponseDto {
    private Long id;
    private String username;
    private String nickname;
    private String email;
}
