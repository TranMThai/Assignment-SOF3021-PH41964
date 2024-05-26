package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.dto.BillDTO;
import com.sof_3021.ph41964.entity.Bill;
import com.sof_3021.ph41964.repository.BillDetailRepository;
import com.sof_3021.ph41964.repository.BillRepository;
import com.sof_3021.ph41964.repository.CustomerRepository;
import com.sof_3021.ph41964.repository.EmployeeRepository;
import com.sof_3021.ph41964.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Override
    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public Bill getById(int id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public void update(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public void remove(int id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<Bill> getAllActive() {
        return billRepository.findAll().stream().filter(bill -> bill.getStatus()).toList();
    }

    @Override
    public List<Bill> search(int search) {
        return billRepository.findAll().stream()
                .filter(bill -> bill.getStatus()
                && bill.getId().equals(search))
                .toList();
    }

}
