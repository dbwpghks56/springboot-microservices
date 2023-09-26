package net.javaguides.organizationservice.domain.repository;

import net.javaguides.organizationservice.domain.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository {
    Organization save(Organization organization);
    Optional<Organization> findById(Long id);
    Optional<Organization> findByOrganizationCode(String organizationCode);
    List<Organization> findAll();
}
