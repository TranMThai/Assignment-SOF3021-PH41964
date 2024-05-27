package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Product;
import com.sof_3021.ph41964.repository.ProductRepository;
import com.sof_3021.ph41964.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> search(String search) {
        String newSearch = search.trim().toLowerCase();
        return getAllActive().stream()
                .filter(product -> String.valueOf(product.getId()).equals(newSearch)
                        || product.getCode().toLowerCase().contains(newSearch)
                        || product.getName().toLowerCase().contains(newSearch))
                .toList();
    }
}
