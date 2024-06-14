package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Size;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SizeService {
    List<Size> getAll();

    Size getById(int id);

    void create(Size size);

    void update(Size size);

    void remove(int id);

    List<Size> getAllActive();

    List<Size> search(String search);

    Page<Size> getByPageActive(Integer page);

    Page<Size> search(Integer page, String search);
}
