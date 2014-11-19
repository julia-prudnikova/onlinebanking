package com.prudnikova.onlinebanking.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="User")
public class User {
    
    public static final String DEFAULT_NAME = "default name";
    public static final String DEFAULT_LOGIN = "default login";
    public static final String DEFAULT_PASSWORD = "default password";
        

    private Long id;
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
     * @return the id
     */
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    @Column(name="name")
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
    @Column(name="login")
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
    @Column(name="password")
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
    @Column(name="registrationDate")
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
