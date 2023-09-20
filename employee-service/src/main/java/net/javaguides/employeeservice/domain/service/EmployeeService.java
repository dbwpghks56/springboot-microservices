package net.javaguides.employeeservice.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.employeeservice.common.CommonResponse;
import net.javaguides.employeeservice.common.exception.employee.EmployeeNotFoundException;
import net.javaguides.employeeservice.domain.Employee;
import net.javaguides.employeeservice.domain.repository.EmployeeRepository;
import net.javaguides.employeeservice.presentation.dto.request.EmployeeRequestDto;
import net.javaguides.employeeservice.presentation.dto.response.DepartmentResponseDto;
import net.javaguides.employeeservice.presentation.dto.response.EmployeeResponseDto;
import net.javaguides.employeeservice.presentation.dto.response.RestTemplateResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class EmployeeService implements EmployeeCommandUseCase {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        return employeeRepository.save(employeeRequestDto.toEntity()).toResponseDto();
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeRepository.findAll().stream().map(Employee::toResponseDto).toList();
    }

    @Override
    public RestTemplateResponseDto findById(Long id) {
        EmployeeResponseDto employeeResponseDto = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new).toResponseDto();

        ResponseEntity<CommonResponse<DepartmentResponseDto>> responseEntity = restTemplate.exchange(
                "http://localhost:8080/api/v1/department/departmentCode/" + employeeResponseDto.getDepartmentCode(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<CommonResponse<DepartmentResponseDto>>() {}
        );

        CommonResponse<DepartmentResponseDto> commonResponse = responseEntity.getBody();

        DepartmentResponseDto departmentResponseDto = commonResponse.getData();

        return RestTemplateResponseDto.builder()
                .employee(employeeResponseDto)
                .department(departmentResponseDto)
                .build();
    }
}















