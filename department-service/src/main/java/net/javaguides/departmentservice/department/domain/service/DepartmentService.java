package net.javaguides.departmentservice.department.domain.service;


import lombok.RequiredArgsConstructor;
import net.javaguides.departmentservice.department.domain.Department;
import net.javaguides.departmentservice.department.domain.repository.DepartmentRepository;
import net.javaguides.departmentservice.department.presentation.dto.request.DepartmentRequestDto;
import net.javaguides.departmentservice.department.presentation.dto.response.DepartmentResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService implements DepartmentCommandUseCase {
    private final DepartmentRepository departmentRepository;


    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        return departmentRepository.save(departmentRequestDto.toEntity()).toResponseDto();
    }

    @Override
    public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto departmentRequestDto) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));

        department.update(departmentRequestDto);

        return department.toResponseDto();
    }

    @Override
    public String deleteDepartment(Long id) {
        departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));

        departmentRepository.deleteById(id);

        return "삭제 성공";
    }

    @Override
    public List<DepartmentResponseDto> findAll() {
        return departmentRepository.findAll().stream().map(Department::toResponseDto).toList();
    }

    @Override
    public DepartmentResponseDto findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다.")).toResponseDto();
    }
}
