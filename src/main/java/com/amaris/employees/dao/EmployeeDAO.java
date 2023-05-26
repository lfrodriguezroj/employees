package com.amaris.employees.dao;

import com.amaris.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployees();
    Employee findEmployee(int id);
}
