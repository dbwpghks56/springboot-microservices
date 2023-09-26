package net.javaguides.organizationservice.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.javaguides.organizationservice.domain.Organization;

@Getter
@ToString
@NoArgsConstructor
public class OrganizationRequestDto {
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;

    public Organization toEntity () {
        return Organization.builder()
            .organizationName(organizationName)
            .organizationDescription(organizationDescription)
            .organizationCode(organizationCode)
            .build();
    }
}
