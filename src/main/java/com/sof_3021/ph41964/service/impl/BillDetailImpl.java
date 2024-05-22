package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.BillDetail;
import com.sof_3021.ph41964.service.BillDetailService;

import java.util.ArrayList;
import java.util.List;

public class BillDetailImpl implements BillDetailService {

    private final List<BillDetail> list = new ArrayList<>();

    public BillDetailImpl() {
    }

    @Override
    public List<BillDetail> getAll() {
        return list;
    }

    @Override
    public BillDetail getById(int id) {
        for (BillDetail billDetail : list) {
            if (billDetail.getId().equals(id)) {
                return billDetail;
            }
        }
        return null;
    }

    @Override
    public void create(BillDetail billDetail) {
        list.add(billDetail);
    }

    @Override
    public void update(BillDetail billDetail) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(billDetail.getId())) {
                list.set(i, billDetail);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(billDetail -> billDetail.getId().equals(id));
    }
}
