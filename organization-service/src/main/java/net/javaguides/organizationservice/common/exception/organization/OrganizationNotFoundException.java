package net.javaguides.organizationservice.common.exception.organization;

import org.springframework.http.HttpStatus;

public class OrganizationNotFoundException extends OrganizationException {
    private static final String ERROR_CODE = "ORGANIZATION_404";
    private static final String MESSAGE = "해당 조직을 찾을 수 없습니다.";

    public OrganizationNotFoundException() {
        super(ERROR_CODE, HttpStatus.BAD_REQUEST, MESSAGE);
    }
}
