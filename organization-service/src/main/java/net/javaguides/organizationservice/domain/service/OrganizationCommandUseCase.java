package net.javaguides.organizationservice.domain.service;

import net.javaguides.organizationservice.presentation.dto.request.OrganizationRequestDto;
import net.javaguides.organizationservice.presentation.dto.response.OrganizationResponseDto;

import java.util.List;

public interface OrganizationCommandUseCase {
    OrganizationResponseDto createOrganization(OrganizationRequestDto organizationRequestDto);
    OrganizationResponseDto findByOrganizationCode(String organizationCode);
    OrganizationResponseDto findById(Long id);
    List<OrganizationResponseDto> findAll();
}
