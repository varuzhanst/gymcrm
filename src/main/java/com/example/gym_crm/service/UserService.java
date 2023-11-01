package com.example.gym_crm.service;

import com.example.gym_crm.model.User;

import java.util.Set;

public interface UserService {
    String generateUsername(String firstName, String lastName, Set<String> allUsernames);

    String generatePassword();

    User generateUser(String firstName, String lastName, Set<String> allUsernames);
}
