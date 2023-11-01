package com.example.gym_crm.dao;

import com.example.gym_crm.config.Storage;
import com.example.gym_crm.model.Trainer;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component

public class TrainerDAOImpl implements TrainerDAO {

    private final Storage storage;

    public TrainerDAOImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void create(Trainer trainer) {
        storage.getTrainerMap().put(trainer.getUser().getUsername(), trainer);
    }

    @Override
    public void update(Trainer trainer) {
        storage.getTrainerMap().put(trainer.getUser().getUsername(), trainer);
    }

    @Override
    public void get(String username) {
        storage.getTrainerMap().get(username);
    }

    @Override
    public Set<String> getAllUsernames() {
        return storage.getTrainerMap().keySet();
    }
}
