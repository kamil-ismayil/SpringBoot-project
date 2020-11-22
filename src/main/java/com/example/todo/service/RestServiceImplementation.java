package com.example.todo.service;

import com.example.todo.dao.CustomerDAO;
import com.example.todo.dao.EmployeeDAO;
import com.example.todo.dao.LoginDAO;
import com.example.todo.dao.TrainingDAO;
import com.example.todo.entities.Customer;
import com.example.todo.entities.Employee;
import com.example.todo.entities.Login;
import com.example.todo.entities.Training;
import com.example.todo.input_forms.CustomerSearchForm;
import com.example.todo.input_forms.LoginForm;
import com.example.todo.input_forms.TrainingSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestServiceImplementation implements RestService{

    private EmployeeDAO employeeDAO;
    private LoginDAO loginDAO;
    private CustomerDAO customerDAO;
    private TrainingDAO trainingDAO;

    @Autowired
    public RestServiceImplementation(EmployeeDAO employeeDAO, LoginDAO loginDAO,
                                     CustomerDAO customerDAO, TrainingDAO trainingDAO) {
        this.employeeDAO = employeeDAO;
        this.loginDAO = loginDAO;
        this.customerDAO = customerDAO;
        this.trainingDAO = trainingDAO;
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

    @Override
    @Transactional
    public List<Training> findTrainingByDescription(TrainingSearchForm trainingSearchForm) {
        return trainingDAO.findTrainingByDescription(trainingSearchForm);
    }

    @Override
    @Transactional
    public List<Training> allTrainings() {
        return trainingDAO.allTrainings();
    }
}
