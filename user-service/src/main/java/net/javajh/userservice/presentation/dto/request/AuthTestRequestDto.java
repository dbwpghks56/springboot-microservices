package net.javajh.userservice.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class AuthTestRequestDto {
    private String accessToken;
}
