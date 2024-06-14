package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Customer;
import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.repository.CustomerRepository;
import com.sof_3021.ph41964.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllActive() {
        return customerRepository.findAll().stream()
                .filter(Customer::getStatus)
                .toList();
    }

    @Override
    public List<Customer> search(String search) {
        String newSearch = search.trim().toLowerCase();
        return getAllActive().stream()
                .filter(customer -> customer.getPhoneNumber().equals(newSearch)
                        || customer.getName().toLowerCase().contains(newSearch)
                        || customer.getCode().toLowerCase().contains(newSearch)
                        || String.valueOf(customer.getId()).equals(newSearch))
                .toList();
    }

    @Override
    public Page<Customer> getByPageActive(Integer page) {
        Pageable pageable = PageRequest.of(page,10);
        return customerRepository.getByPageActive(pageable);
    }

    @Override
    public Page<Customer> search(Integer page, String search) {
        Pageable pageable = PageRequest.of(page,10);
        return customerRepository.searchPageActive(search,pageable);
    }

}
