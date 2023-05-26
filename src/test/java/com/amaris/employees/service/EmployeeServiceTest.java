package com.amaris.employees.service;

import com.amaris.employees.dao.EmployeeDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock private EmployeeDAO employeeDAO;
    @InjectMocks
    private EmployeeService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmployeeService(employeeDAO);
    }

    @Test
    void findAllEmployees() {
        underTest.findAllEmployees();
        // then
        verify(employeeDAO).findAllEmployees();
    }

    @Test
    void findEmployeeById() {
        underTest.findEmployeeById(1);
        // then
        verify(employeeDAO).findEmployee(1);
    }
}