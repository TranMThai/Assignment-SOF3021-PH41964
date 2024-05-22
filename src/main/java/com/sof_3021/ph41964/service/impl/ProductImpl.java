package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Product;
import com.sof_3021.ph41964.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductService {

    private final List<Product> list = new ArrayList<>();

    public ProductImpl() {
        list.add(new Product(1, "SP1", "Iphone 13", true));
        list.add(new Product(2, "SP2", "ROG 6", true));
        list.add(new Product(3, "SP3", "Samsung Galaxy Z Fold5", true));
        list.add(new Product(4, "SP4", "Xiaomi Redmi Note 13 Pro", true));
        list.add(new Product(5, "SP5", "iPhone 14 Pro Max", true));
    }

    @Override
    public List<Product> getAll() {
        return list;
    }

    @Override
    public Product getById(int id) {
        for (Product sp : list) {
            if (sp.getId().equals(id)) {
                return sp;
            }
        }
        return null;
    }

    @Override
    public void create(Product product) {
        list.add(product);
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(product.getId())) {
                list.set(i, product);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(product -> product.getId().equals(id));
    }
}
