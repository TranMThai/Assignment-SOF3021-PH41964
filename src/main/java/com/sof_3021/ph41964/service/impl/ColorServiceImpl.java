package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Color;
import com.sof_3021.ph41964.repository.ColorRepository;
import com.sof_3021.ph41964.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Color color) {
        colorRepository.save(color);
    }

    @Override
    public void update(Color color) {
        colorRepository.save(color);
    }

    @Override
    public void remove(int id) {
        colorRepository.deleteById(id);
    }
}
