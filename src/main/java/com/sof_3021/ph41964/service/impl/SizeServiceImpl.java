package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Size;
import com.sof_3021.ph41964.service.SizeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    private final List<Size> list = new ArrayList<>();

    public SizeServiceImpl() {
        list.add(new Size(1,"S","Small",true));
        list.add(new Size(2,"M","Medium",true));
        list.add(new Size(3,"L","Large",true));
        list.add(new Size(4,"XL","Extra large",true));
        list.add(new Size(5,"XXL","Extra extra large",true));
    }

    @Override
    public List<Size> getAll() {
        return list;
    }

    @Override
    public Size getById(int id) {
        for (Size size : list) {
            if (size.getId().equals(id)) {
                return size;
            }
        }
        return null;
    }

    @Override
    public void create(Size size) {
        list.add(size);
    }

    @Override
    public void update(Size size) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(size.getId())) {
                list.set(i, size);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(size -> size.getId().equals(id));
    }
}
