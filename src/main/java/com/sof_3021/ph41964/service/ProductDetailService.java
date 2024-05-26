package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAll();

    ProductDetail getById(int id);

    void create(ProductDetail productDetail);

    void update(ProductDetail productDetail);

    void remove(int id);

    List<ProductDetail> search(String search);

    void addToCart(List<ProductDetail> cart, String id);

    void removeFromCart(List<ProductDetail> cart, String id);
}
