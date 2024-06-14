package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.model.Account;
import com.sof_3021.ph41964.model.EmployeeInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(int id);

    void create(Employee employee);

    void update(Employee employee);

    void remove(int id);

    Employee getByUsername(String username);

    Employee login(Employee account);

    Employee login(Account account);

    List<Employee> getAllActive();

    List<Employee> search(String search);

    Employee infoToEntity(EmployeeInfo employeeInfo);

    Employee accountToEntity(Account account);

    Page<Employee> getByPageActive(Integer page);

    Page<Employee> search(Integer page, String search);
}
