package net.javaguides.departmentservice.department.presentation.dto.response;


import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentResponseDto {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
