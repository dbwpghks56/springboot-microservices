package net.javaguides.departmentservice.department.presentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 이 어노테이션을 붙이면, /actuator/refresh 엔드포인트를 통해 설정을 동적으로 변경할 수 있다.
public class DepartmentMessageController {
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
