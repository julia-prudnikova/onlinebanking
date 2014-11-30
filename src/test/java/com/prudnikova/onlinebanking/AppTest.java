package com.prudnikova.onlinebanking;

import com.prudnikova.SpringFactory;
import com.prudnikova.onlinebanking.model.Card;
import com.prudnikova.onlinebanking.model.User;
import com.prudnikova.onlinebanking.service.CardService;
import com.prudnikova.onlinebanking.service.UserService;
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
        
        UserService userService = (UserService) SpringFactory.getspringApplicationContext().getBean("userService");

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
        
        String userLogin = user.getLogin();
        User tempUser = userService.getUserByLogin(userLogin);
        System.out.println("Test userService.getUserByLogin: " + tempUser.getName());
        
        userService.deleteUser(user);
        System.out.println("Delete user done!");
        
        
        // Card service test!
        System.out.println("Card service test.");
        
        CardService cardService = (CardService) SpringFactory.getspringApplicationContext().getBean("cardService");

        Card card = new Card();
        card.setId(0);
        card.setCurrency("dollar");
        int balance = 500;
        card.setBalance(balance);
        card.setState("active");
        card.setUserId(1);
                                
        cardService.createCard(card);
        int cardId = card.getId();
        System.out.println("create card done. Card id: " + cardId);
        
        card = cardService.readCard(cardId);        
        if (card.getBalance() != balance){
            fail("Card balance from create and read operations are not equals!!!");
        } else {
            System.out.println("Read card done!");
        }
        
        balance = 550;
        card.setBalance(balance);
        cardService.updateCard(card);
        cardId = card.getId();
        card = cardService.readCard(cardId);        
        if (card.getBalance() != balance){
            fail("Card balance from update and read operations are not equals!!!");
        } else {
            System.out.println("Update card done!");
        }
               
        cardService.deleteCard(card);
        System.out.println("Delete card done!");
    }

}
