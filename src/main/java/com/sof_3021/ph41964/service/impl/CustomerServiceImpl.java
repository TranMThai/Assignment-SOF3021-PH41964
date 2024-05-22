package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Customer;
import com.sof_3021.ph41964.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final List<Customer> list = new ArrayList<>();

    public CustomerServiceImpl() {
        list.add(new Customer(1,"Nguyễn Minh Hương","0973337281","KH1",true));
        list.add(new Customer(2,"Mai Duy Nghiệp","086273512","KH2",true));
        list.add(new Customer(3,"Nguyễn Hồng Nhung","0928496099","KH3",true));
        list.add(new Customer(4,"Tàu Pảy Pảy","0783132128","KH4",true));
        list.add(new Customer(5,"Cát Tư Hãn","0984480779","KH5",true));
    }

    @Override
    public List<Customer> getAll() {
        return list;
    }

    @Override
    public Customer getById(int id) {
        for (Customer customer : list) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void create(Customer customer) {
        list.add(customer);
    }

    @Override
    public void update(Customer customer) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(customer.getId())) {
                list.set(i, customer);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(customer -> customer.getId().equals(id));
    }
}
