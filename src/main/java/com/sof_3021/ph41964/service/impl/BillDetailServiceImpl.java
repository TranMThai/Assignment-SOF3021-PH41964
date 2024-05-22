package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.BillDetail;
import com.sof_3021.ph41964.service.BillDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillDetailServiceImpl implements BillDetailService {

    private final List<BillDetail> list = new ArrayList<>();

    public BillDetailServiceImpl() {
        list.add(new BillDetail(1,1,1,1,true));
        list.add(new BillDetail(2,1,2,2,true));

        list.add(new BillDetail(3,2,5,4,true));

        list.add(new BillDetail(4,3,3,3,true));

        list.add(new BillDetail(5,4,7,1,true));
        list.add(new BillDetail(6,4,8,1,true));

        list.add(new BillDetail(7,5,12,2,true));
        list.add(new BillDetail(8,5,11,1,true));
    }

    @Override
    public List<BillDetail> getAll() {
        return list;
    }

    @Override
    public BillDetail getById(int id) {
        for (BillDetail billDetail : list) {
            if (billDetail.getId().equals(id)) {
                return billDetail;
            }
        }
        return null;
    }

    @Override
    public void create(BillDetail billDetail) {
        list.add(billDetail);
    }

    @Override
    public void update(BillDetail billDetail) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(billDetail.getId())) {
                list.set(i, billDetail);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(billDetail -> billDetail.getId().equals(id));
    }
}
