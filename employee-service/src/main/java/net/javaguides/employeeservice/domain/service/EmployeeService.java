package net.javaguides.employeeservice.domain.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.employeeservice.common.CommonResponse;
import net.javaguides.employeeservice.common.exception.employee.EmployeeNotFoundException;
import net.javaguides.employeeservice.domain.Employee;
import net.javaguides.employeeservice.domain.repository.EmployeeRepository;
import net.javaguides.employeeservice.domain.service.client.DepartmentAPIClient;
import net.javaguides.employeeservice.domain.service.client.OrganizationAPIClient;
import net.javaguides.employeeservice.presentation.dto.request.EmployeeRequestDto;
import net.javaguides.employeeservice.presentation.dto.response.DepartmentResponseDto;
import net.javaguides.employeeservice.presentation.dto.response.EmployeeResponseDto;
import net.javaguides.employeeservice.presentation.dto.response.OrganizationResponseDto;
import net.javaguides.employeeservice.presentation.dto.response.RestTemplateResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class EmployeeService implements EmployeeCommandUseCase {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final DepartmentAPIClient departmentAPIClient;
    private final OrganizationAPIClient organizationAPIClient;

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        return employeeRepository.save(employeeRequestDto.toEntity()).toResponseDto();
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeRepository.findAll().stream().map(Employee::toResponseDto).toList();
    }

    @Override
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment") // fallbackMethod는 Retry가 발동되면 호출될 메서드를 지정한다.
//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment") // fallbackMethod는 CircuitBreaker가 발동되면 호출될 메서드를 지정한다.
    public RestTemplateResponseDto findById(Long id) {
        EmployeeResponseDto employeeResponseDto = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new).toResponseDto();
        log.info("inside getEmployeeById() method");
//        ResponseEntity<CommonResponse<DepartmentResponseDto>> responseEntity = restTemplate.exchange(
//                "http://localhost:8080/api/v1/department/departmentCode/" + employeeResponseDto.getDepartmentCode(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<CommonResponse<DepartmentResponseDto>>() {}
//        );
//
//        CommonResponse<DepartmentResponseDto> commonResponse = responseEntity.getBody();
//
//        DepartmentResponseDto departmentResponseDto = commonResponse.getData();

//        CommonResponse<DepartmentResponseDto> departmentResponseDtoCommonResponse = webClient.get()
//                .uri("http://localhost:8080/api/v1/department/departmentCode/" + employeeResponseDto.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<CommonResponse<DepartmentResponseDto>>() {})
//                .block();
//
//        DepartmentResponseDto departmentResponseDto = departmentResponseDtoCommonResponse.getData();

        CommonResponse<DepartmentResponseDto> departmentResponse = departmentAPIClient.findByDepartmentCode(employeeResponseDto.getDepartmentCode());
        CommonResponse<OrganizationResponseDto> organizationResponse = organizationAPIClient.findByOrganizationCode(employeeResponseDto.getOrganizationCode());

        return RestTemplateResponseDto.builder()
                .employee(employeeResponseDto)
                .department(departmentResponse.getData())
                .organization(organizationResponse.getData())
                .build();
    }

    public RestTemplateResponseDto getDefaultDepartment(Long id, Exception e) {
        EmployeeResponseDto employeeResponseDto = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new).toResponseDto();
        log.info("inside getDefaultDepartment() method");
        DepartmentResponseDto departmentResponseDto = DepartmentResponseDto.builder()
                .id(0L)
                .departmentCode("default")
                .departmentName("default")
                .departmentDescription("default")
                .build();

        return RestTemplateResponseDto.builder()
                .employee(employeeResponseDto)
                .department(departmentResponseDto)
                .build();
    }
}















