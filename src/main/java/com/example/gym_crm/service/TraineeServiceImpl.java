package com.example.gym_crm.service;

import com.example.gym_crm.dao.TraineeDAO;
import com.example.gym_crm.model.Trainee;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TraineeServiceImpl implements TraineeService {
    private TraineeDAO traineeDAO;
    public TraineeServiceImpl(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    @Override
    public void register(Trainee trainee) {
        traineeDAO.create(trainee);
    }

    @Override
    public Set<String> getAllTraineeUsernames() {
        return traineeDAO.getAllUsernames();
    }
}
