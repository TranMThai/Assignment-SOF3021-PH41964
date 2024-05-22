package com.sof_3021.ph41964.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;

    private String ten;

    private String sdt;

    private Integer idKhachHang;

    private Boolean trangThai;

}
