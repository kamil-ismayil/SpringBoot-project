package com.example.todo.dao;

import com.example.todo.entities.Employee;
import com.example.todo.entities.Login;
import org.hibernate.Session;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class EmployeeDAOHibernate implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee findEmployeeById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Employees where id=:id");
        theQuery.setParameter("id", id);

        return (Employee) theQuery.getSingleResult();
    }

    @Override
    public Employee logedinEmployee(Login login) {

        return findEmployeeById(login.getEmployeeId());
    }

    @Override
    public List<Employee> allEmployees() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Employee");
        List<Employee> allEmployees = theQuery.getResultList();

        return allEmployees;
    }
}
