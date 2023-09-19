package net.javaguides.departmentservice.department.application;

import lombok.RequiredArgsConstructor;
import net.javaguides.departmentservice.department.domain.service.DepartmentCommandUseCase;
import net.javaguides.departmentservice.department.domain.service.DepartmentService;
import net.javaguides.departmentservice.department.presentation.dto.request.DepartmentRequestDto;
import net.javaguides.departmentservice.department.presentation.dto.response.DepartmentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentFacade {
    private final DepartmentCommandUseCase departmentCommandUseCase;

    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        return departmentCommandUseCase.createDepartment(departmentRequestDto);
    }

    public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto departmentRequestDto) {
        return departmentCommandUseCase.updateDepartment(id, departmentRequestDto);
    }

    public String deleteDepartment(Long id) {
        return departmentCommandUseCase.deleteDepartment(id);
    }

    public List<DepartmentResponseDto> findAll() {
        return departmentCommandUseCase.findAll();
    }

    public DepartmentResponseDto findById(Long id) {
        return departmentCommandUseCase.findById(id);
    }


}
