package com.example.gym_crm.util;

import com.example.gym_crm.model.*;
import com.example.gym_crm.service.UserService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

@Component
public class ExternalFileProcessor {
    private static final String SPLITTER = ";";
    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX = 1;
    private static final int TRAINEE_BIRTHDAY_INDEX = 2;
    private static final int TRAINER_SPECIALIZATION_INDEX = 2;
    private static final int TRAINEE_ADDRESS_INDEX = 3;
    private static final int TRAINING_TYPE_NAME__INDEX = 0;
    private static final int TRAINEE_USERNAME_INDEX = 0;
    private static final int TRAINER_USERNAME_INDEX = 1;
    private static final int TRAINING_NAME_INDEX = 2;
    private static final int TRAINING_DATE_INDEX = 3;
    private static final int TRAINING_DURATION_INDEX = 4;
    private static final int TRAINING_TYPE_NAME_INDEX = 5;
    private final UserService userService;


    public ExternalFileProcessor(UserService userService) {
        this.userService = userService;
    }

    public void loadTrainingTypeData(Map<String, TrainingType> trainingTypeMap, String line) {
        String trainingTypeName;
        String[] info = line.trim().split(SPLITTER);
        if (info.length == 1) {
            trainingTypeName = info[TRAINING_TYPE_NAME__INDEX];
            TrainingType trainingType = new TrainingType();
            trainingType.setTypeName(trainingTypeName);
            trainingTypeMap.put(trainingTypeName, trainingType);
        }
    }

    public void loadTrainingData(Map<String, Trainer> trainerMap,
                                 Map<String, TrainingType> trainingTypeMap,
                                 Map<String, Trainee> traineeMap,
                                 Map<String, Training> trainingMap,
                                 String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String[] info = line.trim().split(SPLITTER);
        String traineeUsername;
        String trainingTypeName;
        String trainerUsername;
        String extractedTrainingDate;
        String extractedDuration;
        String trainingName;
        if (info.length == 6) {
            traineeUsername = info[TRAINEE_USERNAME_INDEX];
            trainerUsername = info[TRAINER_USERNAME_INDEX];
            trainingName = info[TRAINING_NAME_INDEX];
            extractedTrainingDate = info[TRAINING_DATE_INDEX];
            extractedDuration = info[TRAINING_DURATION_INDEX];
            trainingTypeName = info[TRAINING_TYPE_NAME_INDEX];
            Trainer trainer = trainerMap.get(trainerUsername);
            Trainee trainee = traineeMap.get(traineeUsername);
            TrainingType trainingType = trainingTypeMap.get(trainingTypeName);
            int duration = Integer.parseInt(extractedDuration);
            LocalDate date = LocalDate.parse(extractedTrainingDate, formatter);

            Training training = new Training();
            training.setName(trainingName);
            training.setTrainingType(trainingType);
            training.setDate(date);
            training.setDuration(duration);
            training.setTrainee(trainee);
            training.setTrainer(trainer);

            trainingMap.put(trainingName + trainingMap.keySet().size(), training);
        }
    }

    public void loadTrainerData(Map<String, Trainer> trainerMap,
                                Map<String, TrainingType> trainingTypeMap,
                                Set<String> allUsernames,
                                String line) {
        String[] info = line.trim().split(SPLITTER);
        String firstName;
        String lastName;
        String specialization;
        if (info.length == 3) {
            firstName = info[FIRST_NAME_INDEX];
            lastName = info[LAST_NAME_INDEX];
            specialization = info[TRAINER_SPECIALIZATION_INDEX];
            User user = userService.generateUser(firstName, lastName, allUsernames);
            Trainer trainer = new Trainer();
            TrainingType trainingType = trainingTypeMap.get(specialization);
            trainer.setSpecialization(trainingType);
            trainer.setUser(user);
            trainerMap.put(user.getUsername(), trainer);
        }
    }

    public void loadTraineeData(Map<String, Trainee> traineeMap, Set<String> allUsernames, String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String firstName;
        String lastName;
        String birthdayFromFile;
        String address;
        String[] info = line.trim().split(SPLITTER);
        if (info.length == 4) {
            firstName = info[FIRST_NAME_INDEX];
            lastName = info[LAST_NAME_INDEX];
            birthdayFromFile = info[TRAINEE_BIRTHDAY_INDEX];
            LocalDate birthDayDate = LocalDate.parse(birthdayFromFile, formatter);
            address = info[TRAINEE_ADDRESS_INDEX];
            User user = userService.generateUser(firstName, lastName, allUsernames);
            Trainee trainee = new Trainee();
            trainee.setAddress(address);
            trainee.setDateOfBirth(birthDayDate);
            trainee.setUser(user);
            traineeMap.put(user.getUsername(), trainee);
        }
    }

}
