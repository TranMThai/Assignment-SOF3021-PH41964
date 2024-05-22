package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer getById(int id);

    void create(Customer customer);

    void update(Customer customer);

    void remove(int id);
}
