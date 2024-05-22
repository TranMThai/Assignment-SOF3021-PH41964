package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(int id);

    void create(Employee employee);

    void update(Employee employee);

    void remove(int id);
}
