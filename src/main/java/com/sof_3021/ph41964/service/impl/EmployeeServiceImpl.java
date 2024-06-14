package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.model.Account;
import com.sof_3021.ph41964.model.EmployeeInfo;
import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.repository.EmployeeRepository;
import com.sof_3021.ph41964.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Employee login(Account account) {
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
    public Employee infoToEntity(EmployeeInfo employeeInfo) {
        Employee employee = getById(employeeInfo.getId());
        employee.setCode(employeeInfo.getCode());
        employee.setName(employeeInfo.getName());
        employee.setRole(employeeInfo.getRole());
        return employee;
    }

    @Override
    public Employee accountToEntity(Account account) {
        Employee employee = getByUsername(account.getUsername());
        employee.setUsername(account.getUsername());
        employee.setPassword(account.getPassword());
        return employee;
    }

    @Override
    public Page<Employee> getByPageActive(Integer page) {
        Pageable pageable = PageRequest.of(page,10);
        return employeeRepository.getByPageActive(pageable);
    }

    @Override
    public Page<Employee> search(Integer page, String search) {
        Pageable pageable = PageRequest.of(page,10);
        return employeeRepository.searchPageActive(search,pageable);
    }

    @Override
    public Employee getByUsername(String username) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getUsername().equals(username))
                .findFirst().orElse(null);
    }
}
