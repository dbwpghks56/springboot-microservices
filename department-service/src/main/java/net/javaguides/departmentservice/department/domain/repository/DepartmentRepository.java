package net.javaguides.departmentservice.department.domain.repository;

import net.javaguides.departmentservice.department.domain.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    Optional<Department> findById(Long id);
    Department save(Department department);
    void deleteById(Long id);
    List<Department> findAll();
}
