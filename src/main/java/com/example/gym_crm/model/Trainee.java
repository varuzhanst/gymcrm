package com.example.gym_crm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainee {
    private LocalDate dateOfBirth;
    private String address;
    private User user;

}