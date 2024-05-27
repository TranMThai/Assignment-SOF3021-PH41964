package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAll();

    Bill getById(int id);

    void create(Bill bill);

    void update(Bill bill);

    void remove(int id);

    List<Bill> getAllActive();

    List<Bill> search(int search);
}
