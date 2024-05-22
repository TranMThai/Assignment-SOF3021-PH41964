package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Bill;
import com.sof_3021.ph41964.service.BillService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private final List<Bill> list = new ArrayList<>();

    public BillServiceImpl() {
        list.add(new Bill(1,1,1,new Date(),true));
        list.add(new Bill(2,1,2,new Date(),true));
        list.add(new Bill(3,1,3,new Date(),true));
        list.add(new Bill(4,2,4,new Date(),true));
        list.add(new Bill(5,3,5,new Date(),true));
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
