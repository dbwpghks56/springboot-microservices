package net.javaguides.departmentservice.department.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import net.javaguides.departmentservice.department.domain.Department;
import net.javaguides.departmentservice.department.domain.repository.DepartmentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private final DepartmentJpaRepository departmentJpaRepository;


    @Override
    public Optional<Department> findById(Long id) {
        return departmentJpaRepository.findById(id);
    }

    @Override
    public Department save(Department department) {
        return departmentJpaRepository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentJpaRepository.deleteById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentJpaRepository.findAll();
    }
}
