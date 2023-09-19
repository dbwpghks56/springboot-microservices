package net.javaguides.departmentservice.department.presentation;

import lombok.RequiredArgsConstructor;
import net.javaguides.departmentservice.common.CommonResponse;
import net.javaguides.departmentservice.department.application.DepartmentFacade;
import net.javaguides.departmentservice.department.presentation.dto.request.DepartmentRequestDto;
import net.javaguides.departmentservice.department.presentation.dto.response.DepartmentResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentRestController {
    private final DepartmentFacade departmentFacade;

    @GetMapping
    public ResponseEntity<CommonResponse<List<DepartmentResponseDto>>> findAll() {
        return ResponseEntity.ok(CommonResponse.success(departmentFacade.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<DepartmentResponseDto>> findById(
            @PathVariable Long id) {
        return ResponseEntity.ok(CommonResponse.success(departmentFacade.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CommonResponse<DepartmentResponseDto>> createDepartment(
            @RequestBody DepartmentRequestDto departmentRequestDto) {
        return ResponseEntity.ok(CommonResponse.success(departmentFacade.createDepartment(departmentRequestDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<String>> deleteDepartment(
            @PathVariable Long id) {
        return ResponseEntity.ok(CommonResponse.success(departmentFacade.deleteDepartment(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse<DepartmentResponseDto>> updateDepartment(
            @PathVariable Long id,
            @RequestBody DepartmentRequestDto departmentRequestDto) {
        return ResponseEntity.ok(CommonResponse.success(departmentFacade.updateDepartment(id, departmentRequestDto)));
    }

    @GetMapping("/departmentCode/{departmentCode}")
    public ResponseEntity<CommonResponse<DepartmentResponseDto>> findByDepartmentCode(
            @PathVariable String departmentCode) {
        return ResponseEntity.ok(CommonResponse.success(departmentFacade.findByDepartmentCode(departmentCode)));
    }
}
