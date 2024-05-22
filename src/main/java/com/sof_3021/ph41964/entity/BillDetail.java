package com.sof_3021.ph41964.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDetail {

    private Integer id;

    private Integer idHoaDon;

    private Integer idSPCT;

    private Integer soLuong;

    private Boolean trangThai;

}
