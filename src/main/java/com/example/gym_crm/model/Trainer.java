package com.example.gymcrm.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Trainer {
    public TrainingType getSpecialization() {
        return specialization;
    }

    public void setSpecialization(TrainingType specialization) {
        this.specialization = specialization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private TrainingType specialization;
    private User user;
}