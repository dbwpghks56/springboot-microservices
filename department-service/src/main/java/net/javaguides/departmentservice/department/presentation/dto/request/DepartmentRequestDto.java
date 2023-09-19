package net.javaguides.departmentservice.department.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.javaguides.departmentservice.department.domain.Department;

@Getter
@ToString
@NoArgsConstructor
public class DepartmentRequestDto {
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

    public Department toEntity() {
        return Department.builder()
            .departmentName(departmentName)
            .departmentDescription(departmentDescription)
            .departmentCode(departmentCode)
            .build();
    }
}
