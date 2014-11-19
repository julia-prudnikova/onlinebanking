package com.prudnikova.onlinebanking;

import com.prudnikova.onlinebanking.model.User;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static org.junit.Assert.assertTrue;

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
        user.setRegistrationDate(null);

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        //assertTrue(user.getName().equals(User.DEFAULT_NAME));
    }

}
