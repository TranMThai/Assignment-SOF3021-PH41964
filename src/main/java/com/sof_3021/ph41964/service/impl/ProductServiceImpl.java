package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Product;
import com.sof_3021.ph41964.repository.ProductRepository;
import com.sof_3021.ph41964.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllActive() {
        return productRepository.findAll().stream()
                .filter(Product::getStatus)
                .toList();
    }

    @Override
    public Page<Product> getByPageActive(Integer page) {
        Pageable pageable = PageRequest.of(page, 8);
        return productRepository.getByPageActive(pageable);
    }

    @Override
    public Page<Product> search(Integer page, String search) {
        Pageable pageable = PageRequest.of(page, 8);
        return productRepository.searchPageActive(search, pageable);
    }
}
