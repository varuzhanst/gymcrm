package com.example.gym_crm.service;

import com.example.gym_crm.dao.TrainerDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class TrainerServiceImpl implements TrainerService {
    private final TrainerDAO trainerDAO;
    @Override
    public Set<String> getAllTrainerUsernames() {
       return trainerDAO.getAllUsernames();
    }
}
