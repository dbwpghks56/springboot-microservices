package net.javaguides.employeeservice.domain.service.client;

import net.javaguides.employeeservice.common.CommonResponse;
import net.javaguides.employeeservice.presentation.dto.response.DepartmentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "department-service", url = "http://localhost:8080/api/v1")
public interface DepartmentAPIClient {
    // 이렇게 만들면 FeignClient가 자동으로 url을 붙여서 호출해준다.
    @GetMapping("/department/departmentCode/{departmentCode}")
    CommonResponse<DepartmentResponseDto> findByDepartmentCode(@PathVariable String departmentCode);
}
