package com.example.todo.service;

import com.example.todo.dao.CustomerDAO;
import com.example.todo.dao.EmployeeDAO;
import com.example.todo.dao.LoginDAO;
import com.example.todo.entities.Customer;
import com.example.todo.entities.Employee;
import com.example.todo.entities.Login;
import com.example.todo.input_forms.CustomerSearchForm;
import com.example.todo.input_forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestServiceImplementation implements RestService{

    private EmployeeDAO employeeDAO;
    private LoginDAO loginDAO;
    private CustomerDAO customerDAO;

    @Autowired
    public RestServiceImplementation(EmployeeDAO employeeDAO, LoginDAO loginDAO, CustomerDAO customerDAO) {
        this.employeeDAO = employeeDAO;
        this.loginDAO = loginDAO;
        this.customerDAO = customerDAO;
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

    @Override
    @Transactional
    public Customer findCustomerByName(CustomerSearchForm customerSearchForm) {
        return customerDAO.findCustomerByName(customerSearchForm);
    }

    @Override
    @Transactional
    public List<Customer> allCustomers() {
        return customerDAO.allCustomers();
    }
}
