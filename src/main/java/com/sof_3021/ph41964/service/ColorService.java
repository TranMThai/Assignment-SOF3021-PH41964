package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Color;

import java.util.List;

public interface ColorService {
    List<Color> getAll();

    Color getById(int id);

    void create(Color color);

    void update(Color color);

    void remove(int id);
}
