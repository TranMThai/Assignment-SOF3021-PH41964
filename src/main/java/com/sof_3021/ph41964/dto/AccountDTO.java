package com.sof_3021.ph41964.dto;

import com.sof_3021.ph41964.entity.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    @NotNull(message = "Không được trống")
    private Integer id;

    @NotBlank(message = "Không được trống")
    private String username;

    @NotBlank(message = "Không được trống")
    private String password;

    public AccountDTO(Employee employee) {
        this.id = employee.getId();
        this.username = employee.getUsername();
        this.password = employee.getPassword();
    }
}
