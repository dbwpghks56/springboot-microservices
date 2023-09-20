package net.javaguides.employeeservice.presentation;

import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.application.EmployeeFacade;
import net.javaguides.employeeservice.common.CommonResponse;
import net.javaguides.employeeservice.presentation.dto.request.EmployeeRequestDto;
import net.javaguides.employeeservice.presentation.dto.response.EmployeeResponseDto;
import net.javaguides.employeeservice.presentation.dto.response.RestTemplateResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeRestController {
    private final EmployeeFacade employeeFacade;

    @GetMapping
    public ResponseEntity<CommonResponse<List<EmployeeResponseDto>>> findAll() {
        return ResponseEntity.ok(CommonResponse.success(employeeFacade.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<CommonResponse<RestTemplateResponseDto>> findById(
            @PathVariable Long id) {
        return ResponseEntity.ok(CommonResponse.success(employeeFacade.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CommonResponse<EmployeeResponseDto>> save(
            @RequestBody EmployeeRequestDto employeeRequestDto) {
        return ResponseEntity.ok(CommonResponse.success(employeeFacade.save(employeeRequestDto)));
    }
}
