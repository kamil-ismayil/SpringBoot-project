package com.example.todo.dao;

import com.example.todo.entities.Customer;
import com.example.todo.entities.Employee;
import com.example.todo.input_forms.CustomerSearchForm;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAOHibernate implements CustomerDAO{
    private EntityManager entityManager;

    public CustomerDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer findCustomerByName(CustomerSearchForm customerSearchForm) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Employee where company_name=:name");
        theQuery.setParameter("name",customerSearchForm.getName());

        return (Customer) theQuery.getSingleResult();
    }

    @Override
    public List<Customer> allCustomers() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Customer");
        List<Customer> allCustomers = theQuery.getResultList();

        return allCustomers;

    }
}
