package net.javaguides.employeeservice.infrastructure.repository;

import net.javaguides.employeeservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
}
