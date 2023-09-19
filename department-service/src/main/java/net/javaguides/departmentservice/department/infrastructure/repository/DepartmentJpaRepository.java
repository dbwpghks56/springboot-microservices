package net.javaguides.departmentservice.department.infrastructure.repository;

import net.javaguides.departmentservice.department.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentCode(String departmentCode);
}
