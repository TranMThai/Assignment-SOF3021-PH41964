package com.sof_3021.ph41964.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    private Integer id;

    private Integer idNhanVien;

    private Integer idKhachHang;

    private Date ngayMuaHang;

    private Boolean trangThai;

}
