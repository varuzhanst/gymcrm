package com.example.gymcrm.dao;

import com.example.gymcrm.config.Storage;
import com.example.gymcrm.model.Training;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TrainingDAOImpl implements TrainingDAO {
    private final Storage storage;

    @Override
    public void create(Training training) {
        storage.getTrainingMap().put(training.getName(), training);
    }

    @Override
    public void get(String trainingName) {
        storage.getTrainingMap().get(trainingName);
    }
}
