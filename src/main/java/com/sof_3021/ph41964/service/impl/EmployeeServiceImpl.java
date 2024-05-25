package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.repository.EmployeeRepository;
import com.sof_3021.ph41964.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }
}
