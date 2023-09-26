package net.javaguides.organizationservice.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.organizationservice.common.exception.organization.OrganizationNotFoundException;
import net.javaguides.organizationservice.domain.Organization;
import net.javaguides.organizationservice.domain.repository.OrganizationRepository;
import net.javaguides.organizationservice.presentation.dto.request.OrganizationRequestDto;
import net.javaguides.organizationservice.presentation.dto.response.OrganizationResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrganizationService implements OrganizationCommandUseCase {
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationResponseDto createOrganization(OrganizationRequestDto organizationRequestDto) {
        return organizationRepository.save(organizationRequestDto.toEntity()).toResponseDto();
    }

    @Override
    public OrganizationResponseDto findByOrganizationCode(String organizationCode) {
        return organizationRepository.findByOrganizationCode(organizationCode).orElseThrow(OrganizationNotFoundException::new).toResponseDto();
    }

    @Override
    public OrganizationResponseDto findById(Long id) {
        return organizationRepository.findById(id).orElseThrow(OrganizationNotFoundException::new).toResponseDto();
    }

    @Override
    public List<OrganizationResponseDto> findAll() {
        return organizationRepository.findAll().stream().map(Organization::toResponseDto).toList();
    }
}
