package com.example.gymcrm.dao;

import com.example.gymcrm.model.Trainee;

public interface TraineeDAO {
    void create(Trainee trainee);

    void update(Trainee trainee);

    void get(String username);

    void delete(String username);
}
