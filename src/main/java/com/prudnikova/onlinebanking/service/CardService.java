package com.prudnikova.onlinebanking.service;

import com.prudnikova.onlinebanking.model.Card;
import java.util.List;

public interface CardService {
    
    void createCard(Card card);
    Card readCard(int cardId);
    void updateCard(Card card);
    void deleteCard(Card card);
    
    List getAllCards(); 
}
