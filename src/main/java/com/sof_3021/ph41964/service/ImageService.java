package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Image;

import java.util.List;

public interface ImageService {
    List<Image> getAll();

    Image getById(int id);

    void create(Image bill);

    void update(Image bill);

    void remove(int id);
}
