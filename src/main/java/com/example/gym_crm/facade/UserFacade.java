package com.example.gym_crm.facade;

import com.example.gym_crm.dto.TraineeDTO;
import com.example.gym_crm.model.Trainee;
import com.example.gym_crm.model.User;
import com.example.gym_crm.service.TraineeService;
import com.example.gym_crm.service.TrainerService;
import com.example.gym_crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class UserFacade {
    private TraineeService traineeService;
    private TrainerService trainerService;
    private UserService userService;


    public void registerTrainee(TraineeDTO traineeDTO) {
        String firstname = traineeDTO.getUserDto().getFirstName();
        String lastname = traineeDTO.getUserDto().getLastName();
        Set<String> allTraineeUsernames = traineeService.getAllTraineeUsernames();
        Set<String> allTrainerUsernames = trainerService.getAllTrainerUsernames();
        Set<String> allUsernames = new HashSet<>();
        allUsernames.addAll(allTraineeUsernames);
        allUsernames.addAll(allTrainerUsernames);
        User user = userService.generateUser(firstname, lastname, allUsernames);
        Trainee trainee = new Trainee();
        trainee.setUser(user);
        trainee.setAddress(traineeDTO.getAddress());
        trainee.setDateOfBirth(traineeDTO.getDateOfBirth());
        traineeService.register(trainee);
    }

}
