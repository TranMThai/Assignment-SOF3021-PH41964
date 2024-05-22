package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Color;
import com.sof_3021.ph41964.service.ColorService;

import java.util.ArrayList;
import java.util.List;

public class ColorImpl implements ColorService {

    private final List<Color> list = new ArrayList<>();

    public ColorImpl() {
    }

    @Override
    public List<Color> getAll() {
        return list;
    }

    @Override
    public Color getById(int id) {
        for (Color color : list) {
            if (color.getId().equals(id)) {
                return color;
            }
        }
        return null;
    }

    @Override
    public void create(Color color) {
        list.add(color);
    }

    @Override
    public void update(Color color) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(color.getId())) {
                list.set(i, color);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(color -> color.getId().equals(id));
    }
}
