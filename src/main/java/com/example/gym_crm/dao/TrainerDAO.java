package com.example.gymcrm.dao;

import com.example.gymcrm.model.Trainer;

public interface TrainerDAO {
    void create(Trainer trainee);

    void update(Trainer trainee);

    void get(String username);
}
