package com.sof_3021.ph41964.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Không được trống")
    private String code;

    @NotBlank(message = "Không được trống")
    private String name;

    @NotBlank(message = "Không được trống")
    private String username;

    @NotBlank(message = "Không được trống")
    private String password;

    @NotNull(message = "Không được trống")
    private Boolean role;

    private Boolean status;

    @OneToMany(mappedBy = "employee")
    private List<Bill> bills;

//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String roleName = (role != null && role) ? "ADMIN" : "USER";
//        return Collections.singleton(new SimpleGrantedAuthority(roleName));
//    }
}
