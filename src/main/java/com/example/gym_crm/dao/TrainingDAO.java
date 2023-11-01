package com.example.gym_crm.dao;


import com.example.gym_crm.model.Training;

public interface TrainingDAO {
    void create(Training training);

    void get(String trainingName);
}
