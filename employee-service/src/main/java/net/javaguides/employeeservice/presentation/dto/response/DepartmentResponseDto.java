package net.javaguides.employeeservice.presentation.dto.response;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentResponseDto {
    private Long id;
    private String departmentCode;
    private String departmentName;
    private String departmentDescription;
}
