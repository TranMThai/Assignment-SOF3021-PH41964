package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Image;
import com.sof_3021.ph41964.repository.ImageRepository;
import com.sof_3021.ph41964.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image getById(int id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void update(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void remove(int id) {
        imageRepository.deleteById(id);
    }
}
