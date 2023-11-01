package com.example.gym_crm.service;

import com.example.gym_crm.model.Trainee;

import java.util.Set;

public interface TraineeService {
    void register(Trainee trainee);
    Set<String> getAllTraineeUsernames();

}
