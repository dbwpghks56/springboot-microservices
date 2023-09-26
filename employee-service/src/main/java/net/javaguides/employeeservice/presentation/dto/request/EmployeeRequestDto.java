package net.javaguides.employeeservice.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.javaguides.employeeservice.domain.Employee;

@Getter
@ToString
@NoArgsConstructor
public class EmployeeRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
    private String organizationCode;

    public Employee toEntity() {
        return Employee.builder()
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .departmentCode(departmentCode)
            .organizationCode(organizationCode)
            .build();
    }
}
