package net.javaguides.apigateway.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.javaguides.apigateway.common.domain.BaseEntity;
import net.javaguides.apigateway.presentation.dto.response.UserResponseDto;

@Entity
@Table(name = "tb_user")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String nickname;
    private String email;

    public UserDetailsImpl toUserDetails() {
        return UserDetailsImpl.builder()
                .id(id)
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .build();
    }

    public UserResponseDto toUserResponseDto() {
        return UserResponseDto.builder()
                .id(id)
                .username(username)
                .nickname(nickname)
                .email(email)
                .build();
    }

}
