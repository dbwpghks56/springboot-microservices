package net.javaguides.employeeservice.application;

import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.domain.service.EmployeeCommandUseCase;
import net.javaguides.employeeservice.presentation.dto.request.EmployeeRequestDto;
import net.javaguides.employeeservice.presentation.dto.response.EmployeeResponseDto;
import net.javaguides.employeeservice.presentation.dto.response.RestTemplateResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeFacade {
    private final EmployeeCommandUseCase employeeCommandUseCase;

    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        return employeeCommandUseCase.save(employeeRequestDto);
    }

    public List<EmployeeResponseDto> findAll() {
        return employeeCommandUseCase.findAll();
    }

    public RestTemplateResponseDto findById(Long id) {
        return employeeCommandUseCase.findById(id);
    }
}
