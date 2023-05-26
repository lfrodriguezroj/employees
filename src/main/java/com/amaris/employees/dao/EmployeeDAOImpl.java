package com.amaris.employees.dao;

import com.amaris.employees.entity.Employee;
import com.amaris.employees.entity.EmployeeResponse;
import com.amaris.employees.entity.EmployeesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final String baseUrl = "https://dummy.restapiexample.com";

    public List<Employee> findAllEmployees() {
        try{
            RestTemplate restTemplate = new RestTemplate();
            String employeesUrl = baseUrl + "/api/v1/employees";
            EmployeesResponse response = restTemplate.getForObject(employeesUrl, EmployeesResponse.class);
            assert response != null;
            return response.getData();
        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            System.out.println(httpClientOrServerExc.getStatusCode());
            if(httpClientOrServerExc.getStatusCode().toString().equals("429 TOO_MANY_REQUESTS")) {
                throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS);
            }
            return new ArrayList<>();
        }
    }

    @Override
    public Employee findEmployee(int id) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            String employeeUrl = baseUrl + "/api/v1/employee/{id}";
            EmployeeResponse response = restTemplate.getForObject(employeeUrl, EmployeeResponse.class, id);
            assert response != null;
            return response.getData();
        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            System.out.println(httpClientOrServerExc.getStatusCode());
            if(httpClientOrServerExc.getStatusCode().toString().equals("429 TOO_MANY_REQUESTS")) {
                throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS);
            }
            return new Employee();
        }
    }
}
