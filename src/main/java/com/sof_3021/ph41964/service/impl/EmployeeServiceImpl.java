package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.dto.AccountDTO;
import com.sof_3021.ph41964.dto.EmployeeInfoDTO;
import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.repository.EmployeeRepository;
import com.sof_3021.ph41964.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee login(Employee account) {
        Optional<Employee> opEmployee = employeeRepository.findAll().stream()
                .filter(em -> em.getUsername().equals(account.getUsername())
                        && em.getPassword().equals(account.getPassword()))
                .findFirst();
        if (opEmployee.isPresent()) {
            return opEmployee.get();
        }
        return null;
    }

    @Override
    public List<Employee> getAllActive() {
        return employeeRepository.findAll().stream()
                .filter(Employee::getStatus)
                .toList();
    }

    @Override
    public List<Employee> search(String search) {
        String newSearch = search.trim().toLowerCase();
        return getAllActive().stream()
                .filter(employee -> String.valueOf(employee.getId()).equals(newSearch)
                        || employee.getCode().toLowerCase().contains(newSearch)
                        || employee.getName().toLowerCase().contains(newSearch)
                        || employee.getUsername().toLowerCase().contains(newSearch))
                .toList();
    }

    @Override
    public Employee infoToEntity(EmployeeInfoDTO employeeInfoDTO) {
        Employee employee = getById(employeeInfoDTO.getId());
        employee.setCode(employeeInfoDTO.getCode());
        employee.setName(employeeInfoDTO.getName());
        employee.setRole(employeeInfoDTO.getRole());
        return employee;
    }

    @Override
    public Employee accountToEntity(AccountDTO accountDTO) {
        Employee employee = getById(accountDTO.getId());
        employee.setUsername(accountDTO.getUsername());
        employee.setPassword(accountDTO.getPassword());
        return employee;
    }

    @Override
    public Employee getByUsername(String username) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getUsername().equals(username))
                .findFirst().orElse(null);
    }
}
