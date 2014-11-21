package com.prudnikova.onlinebanking;

import com.prudnikova.onlinebanking.model.User;
import com.prudnikova.onlinebanking.service.UserService;
import com.prudnikova.onlinebanking.service.implementation.UserServiceImplementation;
import java.util.Date;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AppTest {

    @Test
    public void testUsers() {
        System.out.println("********************************************************************************");
        System.out.println("Working Directory = "
                + System.getProperty("user.dir"));
        
        // User service test!
        System.out.println("User service test.");
        UserService userService = new UserServiceImplementation();
        User user = new User();
        user.setId(0);
        user.setLogin("hibernateUser");        
        String userName = "Hibernate test user";
        user.setName(userName);
        user.setPassword("hibernate");
        user.setRegistrationDate(new Date());
                        
        userService.createUser(user);
        int userId = user.getId();
        System.out.println("create user done. User id: " + userId);
        
        user = userService.readUser(userId);        
        if (!user.getName().equals(userName)){
            fail("User name from create and read operations are not equals!!!");
        } else {
            System.out.println("Read user done!");
        }
        
        userName = "new Name";
        user.setName(userName);
        userService.updateUser(user);
        userId = user.getId();
        user = userService.readUser(userId);        
        if (!user.getName().equals(userName)){
            fail("User name from update and read operations are not equals!!!");
        } else {
            System.out.println("Update user done!");
        }
        
        userService.deleteUser(user);
        System.out.println("Delete user done!");
    }

}
