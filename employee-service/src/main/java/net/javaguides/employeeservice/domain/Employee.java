package net.javaguides.employeeservice.domain;

import jakarta.persistence.*;
import lombok.*;
import net.javaguides.employeeservice.common.domain.BaseEntity;
import net.javaguides.employeeservice.presentation.dto.response.EmployeeResponseDto;

@Entity
@Table(name = "tb_employee")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    public EmployeeResponseDto toResponseDto() {
        return EmployeeResponseDto.builder()
            .id(id)
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .build();
    }

}
