package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(int id);

    void create(Product product);

    void update(Product product);

    void remove(int id);

    List<Product> getAllActive();

    Page<Product> getByPageActive(Integer page);

    Page<Product> search(Integer page, String search);
}
