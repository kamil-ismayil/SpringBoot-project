package com.example.todo.dao;

import com.example.todo.entities.Customer;
import com.example.todo.entities.Training;
import com.example.todo.input_forms.TrainingSearchForm;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class TrainingDAOHibernate implements TrainingDAO{

    private EntityManager entityManager;

    public TrainingDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Training> findTrainingByDescription(TrainingSearchForm trainingSearchForm) {
        //java.sql.Date date = java.sql.Date.valueOf(LocalDate.now());

        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Training where " +
                "description=:description and start_date>=:start_date " +
                "and status=:status");
        theQuery.setParameter("description", trainingSearchForm.getDescription());
        theQuery.setParameter("start_date", trainingSearchForm.getStart_date());
        theQuery.setParameter("status", "aktiv");

        return theQuery.getResultList();
    }

    @Override
    public List<Training> allTrainings() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Training");
        List<Training> allTrainings = theQuery.getResultList();

        return allTrainings;
    }
}
