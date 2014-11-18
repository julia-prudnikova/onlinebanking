package com.prudnikova.onlinebanking;

import com.prudnikova.onlinebanking.model.User;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class AppTest {
    
    @Test
    public void testUsers(){
        User user = new User();
        
        assertTrue(user.getName().equals(User.DEFAULT_NAME));        
    }
    
}
