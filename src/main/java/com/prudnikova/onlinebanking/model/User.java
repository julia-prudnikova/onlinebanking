package com.prudnikova.onlinebanking.model;

import java.util.Date;

public class User {
    
    public static final String DEFAULT_NAME = "default name";
    public static final String DEFAULT_LOGIN = "default login";
    public static final String DEFAULT_PASSWORD = "default password";
        
    private String name;
    private String login;
    private String password;
    private Date registrationDate;
    
    public User(){
        name = DEFAULT_NAME;
        login = DEFAULT_LOGIN;
        password = DEFAULT_PASSWORD;
        registrationDate = new Date();
    }
    
    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
        registrationDate = new Date();        
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
}
