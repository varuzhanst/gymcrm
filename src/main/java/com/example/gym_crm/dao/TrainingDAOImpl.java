package com.example.gym_crm.dao;

import com.example.gym_crm.config.Storage;
import com.example.gym_crm.model.Training;
import org.springframework.stereotype.Component;

@Component
public class TrainingDAOImpl implements TrainingDAO {
    private final Storage storage;

    public TrainingDAOImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void create(Training training) {
        storage.getTrainingMap().put(training.getName(), training);
    }

    @Override
    public void get(String trainingName) {
        storage.getTrainingMap().get(trainingName);
    }
}
