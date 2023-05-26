package com.amaris.employees.service;

import com.amaris.employees.dao.EmployeeDAO;
import com.amaris.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeDAO.findAllEmployees();
        for (Employee employee : employees) {
            int annualSalary = employee.getEmployee_salary() * 12;
            employee.setEmployee_anual_salary(annualSalary);
        }
        return employees;
    }
    public Employee findEmployeeById(int id) {
        Employee employee = employeeDAO.findEmployee(id);
        employee.setEmployee_anual_salary(employee.getEmployee_salary() * 12);
        System.out.println(employee);
        return employee;
    }
}
