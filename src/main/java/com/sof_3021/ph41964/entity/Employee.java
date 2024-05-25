package com.sof_3021.ph41964.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private Boolean status;

    @OneToMany(mappedBy = "employee")
    private List<Bill> bills;
}