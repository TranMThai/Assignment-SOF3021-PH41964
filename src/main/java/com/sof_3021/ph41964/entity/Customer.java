package com.sof_3021.ph41964.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer id;

    private String ten;

    private String sdt;

    private String maKhachHang;

    private Boolean trangThai;

}
