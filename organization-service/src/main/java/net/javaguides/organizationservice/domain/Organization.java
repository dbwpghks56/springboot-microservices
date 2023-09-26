package net.javaguides.organizationservice.domain;

import jakarta.persistence.*;
import lombok.*;
import net.javaguides.organizationservice.common.domain.BaseEntity;
import net.javaguides.organizationservice.presentation.dto.response.OrganizationResponseDto;

@Entity
@Table(name = "tb_organization")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String organizationName;

    private String organizationDescription;

    private String organizationCode;

    public OrganizationResponseDto toResponseDto() {
        return OrganizationResponseDto.builder()
            .id(this.id)
            .organizationName(this.organizationName)
            .organizationDescription(this.organizationDescription)
            .organizationCode(this.organizationCode)
            .createdAt(this.getCreatedDate())
            .build();
    }
}
