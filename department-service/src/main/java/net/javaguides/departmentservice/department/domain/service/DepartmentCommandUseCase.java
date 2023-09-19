package net.javaguides.departmentservice.department.domain.service;

import net.javaguides.departmentservice.department.presentation.dto.request.DepartmentRequestDto;
import net.javaguides.departmentservice.department.presentation.dto.response.DepartmentResponseDto;

import java.util.List;

public interface DepartmentCommandUseCase {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto departmentRequestDto);

    String deleteDepartment(Long id);

    List<DepartmentResponseDto> findAll();

    DepartmentResponseDto findById(Long id);
}
