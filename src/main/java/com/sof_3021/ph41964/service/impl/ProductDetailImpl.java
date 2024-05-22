package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.ProductDetail;
import com.sof_3021.ph41964.service.ProductDetailService;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailImpl implements ProductDetailService {

    private final List<ProductDetail> list = new ArrayList<>();

    public ProductDetailImpl() {

    }

    @Override
    public List<ProductDetail> getAll() {
        return list;
    }

    @Override
    public ProductDetail getById(int id) {
        for (ProductDetail spct : list) {
            if (spct.getId().equals(id)) {
                return spct;
            }
        }
        return null;
    }

    @Override
    public void create(ProductDetail spct) {
        list.add(spct);
    }

    @Override
    public void update(ProductDetail spct) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(spct.getId())) {
                list.set(i, spct);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(spct -> spct.getId().equals(id));
    }
}
