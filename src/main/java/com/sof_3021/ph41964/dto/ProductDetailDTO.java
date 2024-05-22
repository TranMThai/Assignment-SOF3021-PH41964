package com.sof_3021.ph41964.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO {

    private Integer id;

    private String maSPCT;

    private Integer idKichThuoc;

    private Integer idMauSac;

    private Integer idSanPham;

    private Integer soLuong;

    private Integer donGia;

    private Boolean trangThai;

}
