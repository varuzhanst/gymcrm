package com.example.gym_crm.mapper;

import com.example.gym_crm.dto.TraineeDTO;
import com.example.gym_crm.model.Trainee;
import com.example.gym_crm.model.User;

public class TraineeMapper {

    public Trainee getTraineeFromDto(TraineeDTO dto){
        Trainee trainee = new Trainee();
        User user = new User();
        user.setActive(true);
        user.setLastName(dto.getLastName());
        user.setFirstName(dto.getFirstName());
    }
}
