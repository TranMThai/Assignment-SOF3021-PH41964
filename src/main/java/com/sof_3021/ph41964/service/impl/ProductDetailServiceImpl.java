package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.ProductDetail;
import com.sof_3021.ph41964.repository.ProductDetailRepository;
import com.sof_3021.ph41964.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public List<ProductDetail> getAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public ProductDetail getById(int id) {
        return productDetailRepository.findById(id).get();
    }

    @Override
    public void create(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public void update(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public void remove(int id) {
        productDetailRepository.deleteById(id);
    }
}
