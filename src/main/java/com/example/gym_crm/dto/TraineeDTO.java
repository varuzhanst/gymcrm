package com.example.gym_crm.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TraineeDTO {
    String address;
    LocalDate dateOfBirth;
    UserDTO userDto;
}
