package net.javaguides.employeeservice.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.domain.Employee;
import net.javaguides.employeeservice.domain.repository.EmployeeRepository;
import net.javaguides.employeeservice.presentation.dto.request.EmployeeRequestDto;
import net.javaguides.employeeservice.presentation.dto.response.EmployeeResponseDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeJpaRepository employeeJpaRepository;


    @Override
    public Employee save(Employee employee) {
        return employeeJpaRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeJpaRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeJpaRepository.findAll();
    }
}
