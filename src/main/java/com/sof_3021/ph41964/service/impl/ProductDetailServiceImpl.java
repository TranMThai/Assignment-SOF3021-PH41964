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
        return productDetailRepository.findById(id).orElse(null);
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

    @Override
    public List<ProductDetail> search(String search) {
        return productDetailRepository.findAll().stream()
                .filter(productDetail -> String.valueOf(productDetail.getId()).equals(search)
                        || productDetail.getProduct().getName().toLowerCase().contains(search.toLowerCase())
                        || productDetail.getProduct().getCode().toLowerCase().contains(search.toLowerCase())
                        || productDetail.getCode().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }

    @Override
    public void addToCart(List<ProductDetail> cart, String id) {
        int idP = Integer.valueOf(id);
        ProductDetail productDetailOfCart = cart.stream()
                .filter(productDetail -> productDetail.getId().equals(idP))
                .findFirst().orElse(null);
        if (productDetailOfCart != null) {
            int x = productDetailOfCart.getQuantity();
            productDetailOfCart.setQuantity(x + 1);
        } else {
            ProductDetail productDetail = new ProductDetail(getById(Integer.valueOf(id)));
            productDetail.setQuantity(1);
            cart.add(productDetail);
        }
    }

    @Override
    public void removeFromCart(List<ProductDetail> cart, String id) {
        int idP = Integer.valueOf(id);
        cart.removeIf(productDetail -> productDetail.getId().equals(idP));
    }

    @Override
    public void editQuantityInCart(List<ProductDetail> cart, String id, Integer quantity) {
        int idP = Integer.valueOf(id);
        ProductDetail productDetailOfCart = cart.stream()
                .filter(productDetail -> productDetail.getId().equals(idP))
                .findFirst().orElse(null);
        if (productDetailOfCart != null) {
            productDetailOfCart.setQuantity(quantity);
        } else {
            ProductDetail productDetail = new ProductDetail(getById(Integer.valueOf(id)));
            productDetail.setQuantity(1);
            cart.add(productDetail);
        }
    }

    @Override
    public List<ProductDetail> getAllActive() {
        return productDetailRepository.findAll().stream()
                .filter(ProductDetail::getStatus)
                .toList();
    }
}
