package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.service.BillService;

import java.util.ArrayList;
import java.util.List;

public class HoaDonImpl implements BillService {

    private final List<com.sof_3021.ph41964.entity.Bill> list = new ArrayList<>();

    public HoaDonImpl() {
    }

    @Override
    public List<com.sof_3021.ph41964.entity.Bill> getAll() {
        return list;
    }

    @Override
    public com.sof_3021.ph41964.entity.Bill getById(int id) {
        for (com.sof_3021.ph41964.entity.Bill bill : list) {
            if (bill.getId().equals(id)) {
                return bill;
            }
        }
        return null;
    }

    @Override
    public void create(com.sof_3021.ph41964.entity.Bill bill) {
        list.add(bill);
    }

    @Override
    public void update(com.sof_3021.ph41964.entity.Bill bill) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(bill.getId())) {
                list.set(i, bill);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(bill -> bill.getId().equals(id));
    }
}
