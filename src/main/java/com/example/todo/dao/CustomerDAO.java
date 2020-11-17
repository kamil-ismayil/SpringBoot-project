package com.example.todo.dao;

import com.example.todo.entities.Customer;
import com.example.todo.entities.Employee;
import com.example.todo.input_forms.CustomerSearchForm;

import java.util.List;

public interface CustomerDAO {
    public Customer findCustomerByName(CustomerSearchForm customerSearchForm);
    public List<Customer> allCustomers();
}
