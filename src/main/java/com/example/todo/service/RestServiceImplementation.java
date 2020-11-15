package com.example.todo.service;

import com.example.todo.dao.EmployeeDAO;
import com.example.todo.dao.LoginDAO;
import com.example.todo.entities.Employee;
import com.example.todo.entities.Login;
import com.example.todo.input_forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestServiceImplementation implements RestService{

    private EmployeeDAO employeeDAO;
    private LoginDAO loginDAO;

    @Autowired
    public RestServiceImplementation(EmployeeDAO employeeDAO, LoginDAO loginDAO) {
        this.employeeDAO = employeeDAO;
        this.loginDAO = loginDAO;
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) {
        return null;
    }

    @Override
    @Transactional
    public Employee loginEmployee(LoginForm loginForm) {
        Login login = loginDAO.login(loginForm);
        if (login == null) {
            return null;
        }
        return employeeDAO.logedinEmployee(login);
    }

    @Override
    @Transactional
    public List<Employee> allEmployees() {
        return employeeDAO.allEmployees();
    }
}
