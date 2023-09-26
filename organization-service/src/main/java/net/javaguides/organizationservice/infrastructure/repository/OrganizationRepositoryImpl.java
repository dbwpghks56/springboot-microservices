package net.javaguides.organizationservice.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import net.javaguides.organizationservice.domain.Organization;
import net.javaguides.organizationservice.domain.repository.OrganizationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final OrganizationJpaRepository organizationJpaRepository;

    @Override
    public Organization save(Organization organization) {
        return organizationJpaRepository.save(organization);
    }

    @Override
    public Optional<Organization> findById(Long id) {
        return organizationJpaRepository.findById(id);
    }

    @Override
    public Optional<Organization> findByOrganizationCode(String organizationCode) {
        return organizationJpaRepository.findByOrganizationCode(organizationCode);
    }

    @Override
    public List<Organization> findAll() {
        return organizationJpaRepository.findAll();
    }
}
