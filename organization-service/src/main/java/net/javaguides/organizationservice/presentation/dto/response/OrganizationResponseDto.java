package net.javaguides.organizationservice.presentation.dto.response;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationResponseDto {
    private Long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
}
