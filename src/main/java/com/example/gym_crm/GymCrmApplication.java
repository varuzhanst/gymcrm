package com.example.gym_crm;

import com.example.gym_crm.config.GymCRMConfig;
import com.example.gym_crm.config.Storage;
import com.example.gym_crm.dto.TraineeDTO;
import com.example.gym_crm.dto.UserDTO;
import com.example.gym_crm.facade.UserFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GymCrmApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GymCRMConfig.class);
        Storage storage = context.getBean(Storage.class);
        System.out.println(storage.getTraineeMap());
        System.out.println(storage.getTrainingMap());
        System.out.println(storage.getTrainerMap());


        UserFacade facade = context.getBean(UserFacade.class);
        UserDTO userDto = new UserDTO();
        userDto.setFirstName("John");
        userDto.setLastName("Smith");
        TraineeDTO traineeDTO = new TraineeDTO();
        traineeDTO.setUserDto(userDto);
        LocalDate bDate = LocalDate.now().minusYears(25);
        traineeDTO.setDateOfBirth(bDate);
        traineeDTO.setAddress("105 Teryan,Yerevan");
        facade.registerTrainee(traineeDTO);


        System.out.println("After facade call");


        System.out.println(storage.getTraineeMap());
        System.out.println(storage.getTrainingMap());
        System.out.println(storage.getTrainerMap());
    }
}
