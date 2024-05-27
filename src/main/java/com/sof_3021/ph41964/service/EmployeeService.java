package com.sof_3021.ph41964.service;

import com.sof_3021.ph41964.dto.AccountDTO;
import com.sof_3021.ph41964.dto.EmployeeInfoDTO;
import com.sof_3021.ph41964.entity.Employee;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(int id);

    void create(Employee employee);

    void update(Employee employee);

    void remove(int id);

    Employee getByUsername(String username);

    Employee login(Employee account);

    Employee login(AccountDTO account);

    List<Employee> getAllActive();

    List<Employee> search(String search);

    Employee infoToEntity(EmployeeInfoDTO employeeInfoDTO);

    Employee accountToEntity(AccountDTO accountDTO);
}
