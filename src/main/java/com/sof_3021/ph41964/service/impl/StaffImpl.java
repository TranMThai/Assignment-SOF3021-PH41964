package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Staff;
import com.sof_3021.ph41964.service.StaffService;

import java.util.ArrayList;
import java.util.List;

public class StaffImpl implements StaffService {

    private final List<Staff> list = new ArrayList<>();

    public StaffImpl() {
    }

    @Override
    public List<Staff> getAll() {
        return list;
    }

    @Override
    public Staff getById(int id) {
        for (Staff staff : list) {
            if (staff.getId().equals(id)) {
                return staff;
            }
        }
        return null;
    }

    @Override
    public void create(Staff staff) {
        list.add(staff);
    }

    @Override
    public void update(Staff staff) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(staff.getId())) {
                list.set(i, staff);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(staff -> staff.getId().equals(id));
    }
}
