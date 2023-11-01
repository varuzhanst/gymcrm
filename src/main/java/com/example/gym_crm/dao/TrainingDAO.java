package com.example.gymcrm.dao;

import com.example.gymcrm.model.Training;

public interface TrainingDAO {
    void create(Training training);

    void get(String trainingName);
}
