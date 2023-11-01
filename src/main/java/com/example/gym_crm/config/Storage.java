package com.example.gym_crm.config;

import com.example.gym_crm.model.Trainee;
import com.example.gym_crm.model.Trainer;
import com.example.gym_crm.model.Training;
import com.example.gym_crm.model.TrainingType;
import com.example.gym_crm.util.ExternalFileProcessor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Component
public class Storage {
    private static final String TRAINER = "Trainer";
    private static final String TRAINEE = "Trainee";
    private static final String TRAINING = "Training";
    private static final String TRAINING_TYPE = "Training type";

    private final ExternalFileProcessor externalFileProcessor;

    @Getter
    private final Map<String, Trainee> traineeMap;
    @Getter
    private final Map<String, Trainer> trainerMap;
    @Getter
    private final Map<String, Training> trainingMap;
    @Getter
    private final Map<String, TrainingType> trainingTypeMap;

    @Value("${data.file.path}")
    private String dataFilePath;


    public Storage(ExternalFileProcessor externalFileProcessor) {
        this.externalFileProcessor = externalFileProcessor;
        this.traineeMap = new HashMap<>();
        this.trainerMap = new HashMap<>();
        this.trainingMap = new HashMap<>();
        this.trainingTypeMap = new HashMap<>();
    }


    @PostConstruct
    private void initializeStorage() {

        loadFileDataIntoStorage();

    }

    private void loadFileDataIntoStorage() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String currentEntityType = "";
            String line;
            while ((line = reader.readLine()) != null) {
                switch (line) {
                    case TRAINEE:
                        currentEntityType = TRAINEE;
                        break;
                    case TRAINER:
                        currentEntityType = TRAINER;
                        break;
                    case TRAINING:
                        currentEntityType = TRAINING;
                        break;
                    case TRAINING_TYPE:
                        currentEntityType = TRAINING_TYPE;
                        break;
                    default:
                        processNotEntityTypeDefiningLine(currentEntityType, line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processNotEntityTypeDefiningLine(String currentEntityType, String line) {
        Set<String> allUsernames = new HashSet<>();
        allUsernames.addAll(traineeMap.keySet());
        allUsernames.addAll(trainerMap.keySet());
        switch (currentEntityType) {
            case TRAINEE:
                externalFileProcessor.loadTraineeData(traineeMap, allUsernames, line);
                break;
            case TRAINER:
                externalFileProcessor.loadTrainerData(trainerMap, trainingTypeMap, allUsernames, line);
                break;
            case TRAINING:
                externalFileProcessor.loadTrainingData(trainerMap,trainingTypeMap,traineeMap,trainingMap,line);
                break;
            case TRAINING_TYPE:
                externalFileProcessor.loadTrainingTypeData(trainingTypeMap, line);
                break;

        }
    }


    public void saveTrainer(Trainer trainer) {
        this.trainerMap.put(trainer.getUser().getUsername(), trainer);
    }

    public void saveTrainee(Trainee trainee) {
        this.traineeMap.put(trainee.getUser().getUsername(), trainee);
    }


}

