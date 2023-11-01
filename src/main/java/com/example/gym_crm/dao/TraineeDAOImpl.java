package com.example.gymcrm.dao;

import com.example.gymcrm.config.Storage;
import com.example.gymcrm.model.Trainee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class TraineeDAOImpl implements TraineeDAO {
    public TraineeDAOImpl(Storage storage) {
        this.storage = storage;
    }

    private final Storage storage;

    @Override
    public void create(Trainee trainee) {
        storage.getTraineeMap().put(trainee.getUser().getUsername(), trainee);
    }

    @Override
    public void update(Trainee trainee) {
        storage.getTraineeMap().put(trainee.getUser().getUsername(),trainee);
    }

    @Override
    public void get(String username) {
        storage.getTraineeMap().get(username);
    }

    @Override
    public void delete(String username) {
        storage.getTraineeMap().remove(username);
    }
}
