package net.javaguides.employeeservice.domain.service;

import net.javaguides.employeeservice.presentation.dto.request.EmployeeRequestDto;
import net.javaguides.employeeservice.presentation.dto.response.EmployeeResponseDto;
import net.javaguides.employeeservice.presentation.dto.response.RestTemplateResponseDto;

import java.util.List;

public interface EmployeeCommandUseCase {
    EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto);

    List<EmployeeResponseDto> findAll();

    RestTemplateResponseDto findById(Long id);
}
