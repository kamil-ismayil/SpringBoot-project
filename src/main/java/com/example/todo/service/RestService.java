package com.example.todo.service;

import com.example.todo.entities.Employee;
import com.example.todo.input_forms.LoginForm;

import java.util.List;

public interface RestService {
    public Employee findEmployeeById(int id);
    public Employee loginEmployee(LoginForm loginForm);
    public List<Employee> allEmployees();
}
