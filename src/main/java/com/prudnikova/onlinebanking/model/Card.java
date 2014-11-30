package com.prudnikova.onlinebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity 
@Table (name="CARD")
public class Card {
    
    public static final String DEFAULT_CURRENCY = "dollar";
    public static final int DEFAULT_BALANCE = 0;
    public static final String DEFAULT_STATE = "active";
    
    
    private int id;
    private String currency;
    private int balance;
    private String state;
    private int userId;
    
    public Card(){
        id = 0;
        currency = DEFAULT_CURRENCY;
        balance = DEFAULT_BALANCE;
        state = DEFAULT_STATE;
        userId= 0;
    }
    
    public Card(String currency, int balance, String state, int userId){
        id = 0;
        this.currency = currency;
        this.balance = balance;
        this.state = state;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column (name="CURRENCY")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column (name="BALANCE")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Column (name="STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column (name="USER_ID")
    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
