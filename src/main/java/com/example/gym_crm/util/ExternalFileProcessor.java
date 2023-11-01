package com.example.gymcrm.util;

import com.example.gymcrm.config.Storage;
import com.example.gymcrm.service.TraineeService;
import com.example.gymcrm.service.TrainerService;
import com.example.gymcrm.service.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExternalFileProcessor {
    private final Storage storage;
    private final TrainerService trainerService;
    private final TrainingService trainingService;
    private final TraineeService traineeService;

    public static void loadFileDataIntoStorage(String dataFilePath){
        System.out.println("Hello from " + dataFilePath);
    }
}
