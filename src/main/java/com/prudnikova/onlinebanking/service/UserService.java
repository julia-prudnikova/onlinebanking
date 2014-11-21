package com.prudnikova.onlinebanking.service;

import com.prudnikova.onlinebanking.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UserService {
    
    private final SessionFactory sessionFactory;
    
    public UserService(){
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    
    public void createUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();        
        session.close();
    }
    
    public User readUser(int userId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();        
        User user;
        user = (User) session.get(User.class, userId);
        session.close();
        
        return user;
    }
    
    public void updateUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
    
    public void deleteUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
    
}
