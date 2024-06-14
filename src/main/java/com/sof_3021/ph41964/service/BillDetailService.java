package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.BillDetail;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BillDetailService {
    List<BillDetail> getAll();

    BillDetail getById(int id);

    void create(BillDetail billDetail);

    void update(BillDetail billDetail);

    void remove(int id);

    List<BillDetail> getAllActive();

    List<BillDetail> search(Integer searchInt);

    Page<BillDetail> getByPageActive(Integer page);
}
