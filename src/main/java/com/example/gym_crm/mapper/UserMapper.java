package com.example.gym_crm.mapper;

import com.example.gym_crm.dto.UserDTO;
import com.example.gym_crm.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

    public User getUserFromDto(UserDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        return user;
    }
}
