package com.example.gymcrm.config;

import com.example.gymcrm.model.Trainee;
import com.example.gymcrm.model.Trainer;
import com.example.gymcrm.model.Training;
import com.example.gymcrm.model.User;
import com.example.gymcrm.util.ExternalFileProcessor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component
public class Storage {
    private static final int PASSWORD_LENGTH = 10;
    private static final String TRAINER = "Trainer";
    private static final String TRAINEE = "Trainee";
    private static final String TRAINING = "Training";
    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX = 1;
    private static final String SPLITTER = ";";
    @Value("${data.file.path}")
    private String dataFilePath;
    @Getter
    private Map<String, Trainee> traineeMap;
    @Getter
    private Map<String, Trainer> trainerMap;
    @Getter
    private Map<String, Training> trainingMap;

    public Map<String, Trainee> getTraineeMap() {
        return traineeMap;
    }

    public Map<String, Trainer> getTrainerMap() {
        return trainerMap;
    }

    public Map<String, Training> getTrainingMap() {
        return trainingMap;
    }

    Storage() {
        this.traineeMap = new HashMap();
        this.trainerMap = new HashMap();
        this.trainingMap = new HashMap();
    }

    @PostConstruct
    private void initializeStorage() {
        ExternalFileProcessor.loadFileDataIntoStorage(dataFilePath);
//        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
//
//            String currentProcessingObject = "";
//            String line;
//            while ((line = reader.readLine()) != null) {
//                switch (line) {
//                    case "Trainee":
//                        currentProcessingObject = "Trainee";
//                        break;
//                    case "Trainer":
//                        currentProcessingObject = "Trainer";
//                        break;
//                    case "Training":
//                        currentProcessingObject = "Training";
//                        break;
//                    default:
//                        this.processLine(currentProcessingObject, line);
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

//    private void processLine(String currentProcessingObject, String line) {
//        String[] info = line.trim().split(";");
//        String firstName;
//        String lastName;
//        User user;
//        switch (currentProcessingObject) {
//            case "Trainee":
//                if (info.length > 2) {
//                    firstName = info[0];
//                    lastName = info[1];
//                    user = this.generateUser(firstName, lastName);
//                    Trainee trainee = new Trainee();
//                    trainee.setUser(user);
//                    this.saveTrainee(trainee);
//                }
//                break;
//            case TRAINER:
//                if (info.length > 3) {
//                    firstName = info[0];
//                    lastName = info[1];
//                    user = this.generateUser(firstName, lastName);
//                    Trainer trainer = new Trainer();
//                    trainer.setUser(user);
//                    this.saveTrainer(trainer);
//                }
//                break;
//            case "Training":
//                break;
//        }
//
//    }
//
//    public void saveTrainer(Trainer trainer) {
//        this.trainerMap.put(trainer.getUser().getUsername(), trainer);
//    }
//
//    public void saveTrainee(Trainee trainee) {
//        this.traineeMap.put(trainee.getUser().getUsername(), trainee);
//    }
//
//    private User generateUser(String firstName, String lastName) {
//        User user = new User();
//        user.setActive(true);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setUsername(this.generateUsername(firstName, lastName));
//        user.setPassword(this.generatePassword());
//        return user;
//    }
//
//    private String generateUsername(String firstName, String lastName) {
//        Set<String> allUsernames = new HashSet();
//        allUsernames.addAll(this.traineeMap.keySet());
//        allUsernames.addAll(this.trainerMap.keySet());
//        String originalUsername = firstName + "." + lastName;
//        String possiblyAllowedUsername = originalUsername;
//        boolean isUsernameNotAllowed = true;
//        int usernameSequentialNumber = 1;
//
//        while (isUsernameNotAllowed) {
//            if (allUsernames.contains(possiblyAllowedUsername)) {
//                ++usernameSequentialNumber;
//                possiblyAllowedUsername = originalUsername + usernameSequentialNumber;
//            } else {
//                isUsernameNotAllowed = false;
//            }
//        }
//
//        return possiblyAllowedUsername;
//    }
//
//    private String generatePassword() {
//        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
//        StringBuilder passwordBuilder = new StringBuilder();
//        Random random = new Random();
//
//        for (int i = 0; i < 10; ++i) {
//            int nextCharacterIndex = random.nextInt(validChars.length());
//            passwordBuilder.append(validChars.charAt(nextCharacterIndex));
//        }
//
//        return passwordBuilder.toString();
//    }
}
