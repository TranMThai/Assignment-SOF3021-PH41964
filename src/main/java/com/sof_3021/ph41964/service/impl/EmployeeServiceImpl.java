package com.sof_3021.ph41964.service.impl;

import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> list = new ArrayList<>();

    public EmployeeServiceImpl() {
        list.add(new Employee(1,"Trần Minh Thái","NV1","Thaichan","Tranthai1",true));
        list.add(new Employee(2,"Nguyễn Quý Thịnh","NV2","ThinhNgu","ThinhNgu",true));
        list.add(new Employee(3,"Chu Bá Toàn","NV3","ToanAnCut","ToanAnCut",true));
    }

    @Override
    public List<Employee> getAll() {
        return list;
    }

    @Override
    public Employee getById(int id) {
        for (Employee employee : list) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void create(Employee employee) {
        list.add(employee);
    }

    @Override
    public void update(Employee employee) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(employee.getId())) {
                list.set(i, employee);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        list.removeIf(employee -> employee.getId().equals(id));
    }
}
