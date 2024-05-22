package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Size;

import java.util.List;

public interface SizeService {
    List<Size> getAll();

    Size getById(int id);

    void create(Size size);

    void update(Size size);

    void remove(int id);
}
