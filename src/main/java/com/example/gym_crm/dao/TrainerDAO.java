package com.example.gym_crm.dao;


import com.example.gym_crm.model.Trainer;

import java.util.Set;

public interface TrainerDAO {
    void create(Trainer trainee);

    void update(Trainer trainee);

    void get(String username);

    Set<String> getAllUsernames();
}
