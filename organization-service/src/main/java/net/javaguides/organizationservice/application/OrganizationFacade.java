package net.javaguides.organizationservice.application;

import lombok.RequiredArgsConstructor;
import net.javaguides.organizationservice.domain.service.OrganizationCommandUseCase;
import net.javaguides.organizationservice.presentation.dto.request.OrganizationRequestDto;
import net.javaguides.organizationservice.presentation.dto.response.OrganizationResponseDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationFacade {
    private final OrganizationCommandUseCase organizationCommandUseCase;

    public OrganizationResponseDto createOrganization(OrganizationRequestDto organizationRequestDto) {
        return organizationCommandUseCase.createOrganization(organizationRequestDto);
    }

    @Cacheable(value = "organization", key = "#organizationCode", unless = "#result == null")
    public OrganizationResponseDto findByOrganizationCode(String organizationCode) {
        return organizationCommandUseCase.findByOrganizationCode(organizationCode);
    }

    @Cacheable(value = "organization", key = "#id", unless = "#result == null")
    public OrganizationResponseDto findById(Long id) {
        return organizationCommandUseCase.findById(id);
    }

    public List<OrganizationResponseDto> findAll() {
        return organizationCommandUseCase.findAll();
    }
}
