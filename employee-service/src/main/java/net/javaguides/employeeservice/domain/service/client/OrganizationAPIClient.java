package net.javaguides.employeeservice.domain.service.client;

import net.javaguides.employeeservice.common.CommonResponse;
import net.javaguides.employeeservice.presentation.dto.response.OrganizationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE/api/v1")
public interface OrganizationAPIClient {
    @GetMapping("/organization/code/{organizationCode}")
    CommonResponse<OrganizationResponseDto> findByOrganizationCode(@PathVariable String organizationCode);
}
