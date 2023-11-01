package com.example.gym_crm.mapper;

import com.example.gym_crm.dto.TraineeDTO;
import com.example.gym_crm.model.Trainee;
import com.example.gym_crm.model.User;
import org.springframework.stereotype.Component;

@Component

public class TrainerMapper {
    private final UserMapper userMapper;

    public TrainerMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Trainee getTraineeFromDto(TraineeDTO dto) {
        Trainee trainee = new Trainee();
        User user = userMapper.getUserFromDto(dto.getUserDto());
        trainee.setUser(user);
        return trainee;
    }
}
