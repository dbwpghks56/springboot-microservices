package net.javaguides.departmentservice.department.domain;

import jakarta.persistence.*;
import lombok.*;
import net.javaguides.departmentservice.common.domain.BaseEntity;
import net.javaguides.departmentservice.department.presentation.dto.request.DepartmentRequestDto;
import net.javaguides.departmentservice.department.presentation.dto.response.DepartmentResponseDto;

@Entity
@Table(name = "tb_department")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

    private String departmentDescription;

    private String departmentCode;

    public DepartmentResponseDto toResponseDto() {
        return DepartmentResponseDto.builder()
            .id(this.id)
            .departmentName(this.departmentName)
            .departmentDescription(this.departmentDescription)
            .departmentCode(this.departmentCode)
            .build();
    }

    public void update(DepartmentRequestDto departmentRequestDto) {
        if (departmentRequestDto.getDepartmentName() != null) {
            this.departmentName = departmentRequestDto.getDepartmentName();
        }
        if (departmentRequestDto.getDepartmentDescription() != null) {
            this.departmentDescription = departmentRequestDto.getDepartmentDescription();
        }
        if (departmentRequestDto.getDepartmentCode() != null) {
            this.departmentCode = departmentRequestDto.getDepartmentCode();
        }
    }
}
