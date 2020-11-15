package com.example.todo.dao;

import com.example.todo.entities.Employee;
import com.example.todo.entities.Login;

import java.util.List;

public interface EmployeeDAO {
    public Employee findEmployeeById(int id);
    public Employee logedinEmployee(Login login);
    public List<Employee> allEmployees();
}
