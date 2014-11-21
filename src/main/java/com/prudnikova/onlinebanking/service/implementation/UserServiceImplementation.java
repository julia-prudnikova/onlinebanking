package com.prudnikova.onlinebanking.service.implementation;

import com.prudnikova.NewHibernateUtil;
import com.prudnikova.onlinebanking.model.User;
import com.prudnikova.onlinebanking.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserServiceImplementation implements UserService{

    public UserServiceImplementation() {

    }

    @Override
    public void createUser(User user) {
        //SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User readUser(int userId) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user;
        user = (User) session.get(User.class, userId);
        session.close();

        return user;
    }

    @Override
    public void updateUser(User user) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

}