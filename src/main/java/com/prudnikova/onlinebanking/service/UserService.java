package com.prudnikova.onlinebanking.service;

import com.prudnikova.onlinebanking.model.User;

public interface UserService {
    
    void createUser(User user);
    User readUser(int userId);
    void updateUser(User user);
    void deleteUser(User user);
    
}
