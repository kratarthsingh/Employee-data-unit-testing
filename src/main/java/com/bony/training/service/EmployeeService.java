package com.bony.training.service;

import com.bony.training.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);

    void deleteEmployeeById (Long id);

}
