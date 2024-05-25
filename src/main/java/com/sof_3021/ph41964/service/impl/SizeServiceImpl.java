package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Size;
import com.sof_3021.ph41964.repository.SizeRepository;
import com.sof_3021.ph41964.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return sizeRepository.findById(id).get();
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
}
