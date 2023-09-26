package net.javaguides.employeeservice.presentation.dto.response;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestTemplateResponseDto {
    private EmployeeResponseDto employee;
    private DepartmentResponseDto department;
    private OrganizationResponseDto organization;
}
