package com.sof_3021.ph41964.model;

import com.sof_3021.ph41964.entity.Employee;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @NotBlank(message = "Không được trống")
    private String username;

    @NotBlank(message = "Không được trống")
    private String password;

    public Account(Employee employee) {
        this.username = employee.getUsername();
        this.password = employee.getPassword();
    }
}
