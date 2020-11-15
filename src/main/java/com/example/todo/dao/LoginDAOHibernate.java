package com.example.todo.dao;

import com.example.todo.entities.Login;
import com.example.todo.input_forms.LoginForm;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class LoginDAOHibernate implements LoginDAO {
    EntityManager entityManager;

    @Autowired
    public LoginDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Login login(LoginForm loginform) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery(
                "from Login where username=:username and password=:password"
                );
        theQuery.setParameter("username",loginform.getUsername());
        theQuery.setParameter("password",loginform.getPassword());

        return (Login) theQuery.getSingleResult();
    }
}
