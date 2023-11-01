package com.example.gym_crm.service;

import com.example.gym_crm.model.User;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;

@Component
public class UserServiceImpl implements UserService {
    private static final int PASSWORD_LENGTH = 10;

    @Override
    public String generateUsername(String firstName, String lastName, Set<String> allUsernames) {
        String originalUsername = firstName + "." + lastName;
        String possiblyAllowedUsername = originalUsername;
        boolean isUsernameNotAllowed = true;
        int usernameSequentialNumber = 1;

        while (isUsernameNotAllowed) {
            if (allUsernames.contains(possiblyAllowedUsername)) {
                ++usernameSequentialNumber;
                possiblyAllowedUsername = originalUsername + usernameSequentialNumber;
            } else {
                isUsernameNotAllowed = false;
            }
        }

        return possiblyAllowedUsername;
    }

    @Override
    public String generatePassword() {
        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder passwordBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int nextCharacterIndex = random.nextInt(validChars.length());
            passwordBuilder.append(validChars.charAt(nextCharacterIndex));
        }
        return passwordBuilder.toString();
    }

    @Override
    public User generateUser(String firstName, String lastName, Set<String> allUsernames) {
        User user = new User();
        user.setActive(true);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(generateUsername(firstName, lastName, allUsernames));
        user.setPassword(generatePassword());
        return user;
    }
}
