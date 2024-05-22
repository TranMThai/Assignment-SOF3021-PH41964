package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Color;
import com.sof_3021.ph41964.service.ColorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    private final List<Color> list = new ArrayList<>();

    public ColorServiceImpl() {
        list.add(new Color(1,"Red","Màu đỏ",true));
        list.add(new Color(2,"White","Màu trắng",true));
        list.add(new Color(3,"Blue","Màu xanh dương",true));
        list.add(new Color(4,"Green","Màu xanh lá cây",true));
        list.add(new Color(5,"Black","Màu đen",true));
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
