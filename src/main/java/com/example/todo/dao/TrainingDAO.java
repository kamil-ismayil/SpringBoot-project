package com.example.todo.dao;

import com.example.todo.entities.Training;
import com.example.todo.input_forms.TrainingSearchForm;

import java.util.List;

public interface TrainingDAO {
    public List<Training> findTrainingByDescription(TrainingSearchForm trainingSearchForm);
    public List<Training> allTrainings();
}
