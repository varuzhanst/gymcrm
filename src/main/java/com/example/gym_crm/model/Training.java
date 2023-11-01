package com.example.gym_crm.model;

import lombok.*;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Training {
    private long id;
    private Trainee trainee;
    private Trainer trainer;
    private String name;
    private LocalDate date;
    private int duration;
    private TrainingType trainingType;

}