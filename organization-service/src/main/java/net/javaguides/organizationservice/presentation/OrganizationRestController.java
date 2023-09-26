package net.javaguides.organizationservice.presentation;

import lombok.RequiredArgsConstructor;
import net.javaguides.organizationservice.application.OrganizationFacade;
import net.javaguides.organizationservice.common.CommonResponse;
import net.javaguides.organizationservice.presentation.dto.request.OrganizationRequestDto;
import net.javaguides.organizationservice.presentation.dto.response.OrganizationResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/organization")
public class OrganizationRestController {
    private final OrganizationFacade organizationFacade;

    @GetMapping
    public ResponseEntity<CommonResponse<List<OrganizationResponseDto>>> findAll() {
        return ResponseEntity.ok(CommonResponse.success(organizationFacade.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<OrganizationResponseDto>> findById(
            @PathVariable  Long id) {
        return ResponseEntity.ok(CommonResponse.success(organizationFacade.findById(id)));
    }

    @GetMapping("/organizationCode/{organizationCode}")
    public ResponseEntity<CommonResponse<OrganizationResponseDto>> findByOrganizationCode(
            @PathVariable String organizationCode) {
        return ResponseEntity.ok(CommonResponse.success(organizationFacade.findByOrganizationCode(organizationCode)));
    }

    @PostMapping
    public ResponseEntity<CommonResponse<OrganizationResponseDto>> createOrganization(
            @RequestBody OrganizationRequestDto organizationRequestDto) {
        return new ResponseEntity<>(CommonResponse.success(organizationFacade.createOrganization(organizationRequestDto)), HttpStatus.CREATED);
    }
}
