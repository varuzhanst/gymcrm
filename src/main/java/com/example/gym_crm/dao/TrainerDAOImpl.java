package com.example.gymcrm.dao;

import com.example.gymcrm.config.Storage;
import com.example.gymcrm.model.Trainer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
public class TrainerDAOImpl implements TrainerDAO {
    public TrainerDAOImpl(Storage storage) {
        this.storage = storage;
    }

    private final Storage storage;
    @Override
    public void create(Trainer trainer) {
        storage.getTrainerMap().put(trainer.getUser().getUsername(),trainer);
    }

    @Override
    public void update(Trainer trainer) {
        storage.getTrainerMap().put(trainer.getUser().getUsername(),trainer);
    }

    @Override
    public void get(String username) {
        storage.getTrainerMap().get(username);
    }
}
