package com.sof_3021.ph41964.service;

import java.util.List;

public interface BillService {
    List<com.sof_3021.ph41964.entity.Bill> getAll();

    com.sof_3021.ph41964.entity.Bill getById(int id);

    void create(com.sof_3021.ph41964.entity.Bill bill);

    void update(com.sof_3021.ph41964.entity.Bill bill);

    void remove(int id);
}
