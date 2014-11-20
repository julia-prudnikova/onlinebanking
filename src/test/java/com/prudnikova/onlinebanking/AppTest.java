package com.prudnikova.onlinebanking;

import com.prudnikova.onlinebanking.model.User;
import java.util.Date;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.junit.Test;

public class AppTest {

    @Test
    public void testUsers() {
        System.out.println("Working Directory = "
                + System.getProperty("user.dir"));

        User user = new User();
        user.setLogin("hibernate");
        user.setName("Hibernate fist user");
        user.setPassword("hibernate");
        user.setRegistrationDate(new Date());

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();        
        session.close();        
        user = null;
        
        session = sessionFactory.openSession();
        session.beginTransaction();        
        user = (User) session.get(User.class, 1l);
        session.close();
        
        System.out.println("User login: " + user.getLogin());
    }

}
