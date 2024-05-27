package com.sof_3021.ph41964.dto;

import com.sof_3021.ph41964.entity.Employee;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoDTO {

    @NotNull(message = "Không được trống")
    private Integer id;

    @NotBlank(message = "Không được trống")
    private String code;

    @NotBlank(message = "Không được trống")
    private String name;

    @NotNull(message = "Bạn chưa chọn")
    private Boolean role;

    public EmployeeInfoDTO(Employee employee) {
        this.id = employee.getId();
        this.code = employee.getCode();
        this.name = employee.getName();
        this.role = employee.getRole();
    }
}
