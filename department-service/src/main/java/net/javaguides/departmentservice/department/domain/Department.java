package net.javaguides.departmentservice.department.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_department")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

    private String departmentDescription;

    private String departmentCode;
}
