package com.example.gym_crm.dao;


import com.example.gym_crm.model.Trainee;

import java.util.Set;

public interface TraineeDAO {
    void create(Trainee trainee);

    void update(Trainee trainee);

    void get(String username);

    void delete(String username);

    Set<String> getAllUsernames();
}
