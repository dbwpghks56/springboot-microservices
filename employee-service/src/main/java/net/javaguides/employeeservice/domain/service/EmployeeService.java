package net.javaguides.employeeservice.domain.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.common.exception.employee.EmployeeNotFoundException;
import net.javaguides.employeeservice.domain.Employee;
import net.javaguides.employeeservice.domain.repository.EmployeeRepository;
import net.javaguides.employeeservice.presentation.dto.request.EmployeeRequestDto;
import net.javaguides.employeeservice.presentation.dto.response.EmployeeResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService implements EmployeeCommandUseCase {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        return employeeRepository.save(employeeRequestDto.toEntity()).toResponseDto();
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeRepository.findAll().stream().map(Employee::toResponseDto).toList();
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new).toResponseDto();
    }
}
