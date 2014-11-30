package com.prudnikova.onlinebanking.service.implementation;

import com.prudnikova.HibernateFactory;
import com.prudnikova.onlinebanking.model.Card;
import com.prudnikova.onlinebanking.model.User;
import com.prudnikova.onlinebanking.service.CardService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImplementation implements CardService{
    
    public CardServiceImplementation(){
        
    }
    
    @Override
    public void createCard(Card card) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(card);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Card readCard(int cardId) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Card card;
        card = (Card) session.get(Card.class, cardId);
        session.close();

        return card;
    }

    @Override
    public void updateCard(Card card) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(card);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteCard(Card card) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(card);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List getAllCards(){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List cardsList = session.createCriteria(Card.class).list();
        session.close();

        return cardsList;
    }
    
}
