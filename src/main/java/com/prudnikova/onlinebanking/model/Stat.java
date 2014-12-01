package com.prudnikova.onlinebanking.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity 
@Table (name="STAT")
public class Stat {
    
    public static final String DEFAULT_DESCRIPTION = "Default user action description.";
    public static final int DEFAULT_USERID = 0;
    
    private int id;
    private String description;
    private int userId;
    private Date date;
    
    public Stat(){
        id = 0;
        description = DEFAULT_DESCRIPTION;
        userId = DEFAULT_USERID;
        date  =new Date();
    }
    
    public Stat(String description, int UserId){
        id = 0;
        this.description = description;
        this.userId = userId;
        date = new Date();
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

    @Column (name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column (name="USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column (name="DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
