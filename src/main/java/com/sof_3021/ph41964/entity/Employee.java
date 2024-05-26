package com.sof_3021.ph41964.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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

    private String code;

    private String name;

    private String username;

    private String password;

    private Boolean role;

    private Boolean status;

    @OneToMany(mappedBy = "employee")
    private List<Bill> bills;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = (role != null && role) ? "ADMIN" : "USER";
        return Collections.singleton(new SimpleGrantedAuthority(roleName));
    }
}
