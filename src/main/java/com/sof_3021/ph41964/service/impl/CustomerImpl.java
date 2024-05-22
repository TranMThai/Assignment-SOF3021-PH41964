package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Customer;
import com.sof_3021.ph41964.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerService {

    private final List<Customer> list = new ArrayList<>();

    public CustomerImpl() {
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
