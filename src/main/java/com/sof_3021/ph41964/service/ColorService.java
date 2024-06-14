package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Color;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ColorService {
    List<Color> getAll();

    Color getById(int id);

    void create(Color color);

    void update(Color color);

    void remove(int id);

    List<Color> search(String search);

    List<Color> getAllActive();

    Page<Color> getByPageActive(Integer page);

    Page<Color> search(Integer page, String search);
}
