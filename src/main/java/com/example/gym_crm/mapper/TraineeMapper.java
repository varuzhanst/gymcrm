package com.example.gym_crm.mapper;

import com.example.gym_crm.dto.TraineeDTO;
import com.example.gym_crm.model.Trainee;
import org.springframework.stereotype.Component;

@Component
public class TraineeMapper {
    private final UserMapper userMapper;

    public TraineeMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Trainee getTraineeFromDto(TraineeDTO dto) {
        return Trainee.builder().user(
                userMapper.getUserFromDto(dto.getUserDto())
        ).build();
    }
}
