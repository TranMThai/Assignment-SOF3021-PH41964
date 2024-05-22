package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getAll();

    Staff getById(int id);

    void create(Staff staff);

    void update(Staff staff);

    void remove(int id);
}
