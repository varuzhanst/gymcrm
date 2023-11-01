package com.example.gym_crm.dao;

import com.example.gym_crm.config.Storage;
import com.example.gym_crm.model.Trainee;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TraineeDAOImpl implements TraineeDAO {

    private final Storage storage;

    public TraineeDAOImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void create(Trainee trainee) {
        storage.getTraineeMap().put(trainee.getUser().getUsername(), trainee);
    }

    @Override
    public void update(Trainee trainee) {
        storage.getTraineeMap().put(trainee.getUser().getUsername(), trainee);
    }

    @Override
    public void get(String username) {
        storage.getTraineeMap().get(username);
    }

    @Override
    public void delete(String username) {
        storage.getTraineeMap().remove(username);
    }

    @Override
    public Set<String> getAllUsernames() {
        return storage.getTraineeMap().keySet();
    }
}
