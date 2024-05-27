package com.sof_3021.ph41964.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Không được trống!!!")
    private String code;

    @NotBlank(message = "Không được trống!!!")
    private String name;

    @Pattern(regexp = "\\d{9,12}", message = "Sai pattern điện thoại")
    private String phoneNumber;

    private Boolean status;

    @OneToMany(mappedBy = "customer")
    private List<Bill> bills;
}
