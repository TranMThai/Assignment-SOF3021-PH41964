package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Color;
import com.sof_3021.ph41964.entity.Size;
import com.sof_3021.ph41964.repository.ColorRepository;
import com.sof_3021.ph41964.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<Color> search(String search) {
        String newSearch = search.trim().toLowerCase();
        return getAllActive().stream()
                .filter(color -> String.valueOf(color.getId()).equals(newSearch)
                        || color.getName().toLowerCase().contains(newSearch)
                        || color.getCode().toLowerCase().contains(newSearch))
                .toList();
    }

    @Override
    public List<Color> getAllActive() {
        return colorRepository.findAll().
                stream()
                .filter(Color::getStatus)
                .toList();
    }
    @Override
    public Page<Color> getByPageActive(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return colorRepository.getByPageActive(pageable);
    }

    @Override
    public Page<Color> search(Integer page, String search) {
        Pageable pageable = PageRequest.of(page, 10);
        return colorRepository.searchPageActive(search,pageable);
    }
}
