package com.sof_3021.ph41964.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {

    private Integer id;

    private String ten;

    private Integer idNhanVien;

    private String tenDangNhap;

    private String matKhau;

    private Boolean trangThai;

}
