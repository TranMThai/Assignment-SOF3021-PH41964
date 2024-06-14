package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Size;
import com.sof_3021.ph41964.repository.SizeRepository;
import com.sof_3021.ph41964.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getById(int id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public void update(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public void remove(int id) {
        sizeRepository.deleteById(id);
    }

    @Override
    public List<Size> search(String search) {
        String newSearch = search.trim().toLowerCase();
        return getAllActive().stream()
                .filter(size -> String.valueOf(size.getId()).equals(newSearch)
                        || size.getName().toLowerCase().contains(newSearch)
                        || size.getCode().toLowerCase().contains(newSearch))
                .toList();
    }

    @Override
    public Page<Size> getByPageActive(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return sizeRepository.getByPageActive(pageable);
    }

    @Override
    public Page<Size> search(Integer page, String search) {
        Pageable pageable = PageRequest.of(page, 10);
        return sizeRepository.searchPageActive(search,pageable);
    }

    @Override
    public List<Size> getAllActive() {
        return sizeRepository.findAll().
                stream()
                .filter(Size::getStatus)
                .toList();
    }
}
