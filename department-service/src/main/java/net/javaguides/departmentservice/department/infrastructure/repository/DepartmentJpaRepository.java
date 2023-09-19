package net.javaguides.departmentservice.department.infrastructure.repository;

import net.javaguides.departmentservice.department.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {
}
