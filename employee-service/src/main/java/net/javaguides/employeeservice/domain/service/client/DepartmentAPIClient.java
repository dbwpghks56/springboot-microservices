package net.javaguides.employeeservice.domain.service.client;

import net.javaguides.employeeservice.common.CommonResponse;
import net.javaguides.employeeservice.presentation.dto.response.DepartmentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// FeignClient는 내부적으로 로드밸런서를 사용하여 마이크로 서비스의 나머지 사용가능한 인스턴스 중 하나를 선택한다.
@FeignClient(name = "DEPARTMENT-SERVICE/api/v1")
public interface DepartmentAPIClient {
    // 이렇게 만들면 FeignClient가 자동으로 url을 붙여서 호출해준다.
    @GetMapping("/department/departmentCode/{departmentCode}")
    CommonResponse<DepartmentResponseDto> findByDepartmentCode(@PathVariable String departmentCode);
}
