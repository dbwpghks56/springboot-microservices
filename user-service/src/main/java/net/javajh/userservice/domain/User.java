package net.javajh.userservice.domain;

import jakarta.persistence.*;
import lombok.*;
import net.javajh.userservice.common.domain.BaseEntity;
import net.javajh.userservice.presentation.dto.response.UserResponseDto;

@Entity
@Table(name = "tb_user")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String nickname;
    private String email;

    public UserResponseDto toResponseDto() {
        return UserResponseDto.builder()
                .id(id)
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .build();
    }
}
