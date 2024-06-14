package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.ProductDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAll();

    ProductDetail getById(int id);

    void create(ProductDetail productDetail);

    void update(ProductDetail productDetail);

    void remove(int id);

    List<ProductDetail> search(String search);

    Page<ProductDetail> search(int page, String search);

    void addToCart(List<ProductDetail> cart, String id);

    void removeFromCart(List<ProductDetail> cart, String id);

    void editQuantityInCart(List<ProductDetail> cart, String id, Integer quantity);

    List<ProductDetail> getAllActive();

    void setQuantity(int id, int quantity);

    Page<ProductDetail> getByPageActive(Integer page);
}
