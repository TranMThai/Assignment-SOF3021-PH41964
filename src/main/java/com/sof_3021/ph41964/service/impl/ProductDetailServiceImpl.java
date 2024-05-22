package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.ProductDetail;
import com.sof_3021.ph41964.service.ProductDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    private final List<ProductDetail> list = new ArrayList<>();

    public ProductDetailServiceImpl() {
        list.add(new ProductDetail(1,"SP1_2",1,1,1,12,540000,true));
        list.add(new ProductDetail(2,"SP1_3",1,2,1,41,540000,true));

        list.add(new ProductDetail(3, "SP2_1", 1, 1, 2, 37, 589000, true));
        list.add(new ProductDetail(4, "SP2_2", 2, 1, 2, 38, 589000, true));
        list.add(new ProductDetail(5, "SP2_3", 3, 1, 2, 36, 589000, true));

        list.add(new ProductDetail(6, "SP3_1", 1, 2, 3, 22, 300000, true));
        list.add(new ProductDetail(7, "SP3_2", 2, 2, 3, 86, 300000, true));
        list.add(new ProductDetail(8, "SP3_3", 3, 2, 3, 12, 300000, true));

        list.add(new ProductDetail(9, "SP4_1", 4, 4, 4, 64, 1200000, true));

        list.add(new ProductDetail(10, "SP5_1", 4, 4, 5, 13, 400000, true));
        list.add(new ProductDetail(11, "SP5_2", 5, 4, 5, 34, 400000, true));
        list.add(new ProductDetail(12, "SP5_3", 4, 4, 5, 83, 500000, true));
        list.add(new ProductDetail(13, "SP5_4", 4, 5, 5, 35, 400000, true));

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
