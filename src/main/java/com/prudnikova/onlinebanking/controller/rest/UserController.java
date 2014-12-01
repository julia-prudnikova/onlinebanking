package com.prudnikova.onlinebanking.controller.rest;

import com.prudnikova.SessionBean;
import com.prudnikova.SpringFactory;
import com.prudnikova.onlinebanking.model.Stat;
import com.prudnikova.onlinebanking.model.User;
import com.prudnikova.onlinebanking.service.StatService;
import com.prudnikova.onlinebanking.service.UserService;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("users")
public class UserController {

    public UserController() {
    }

    @GET
    @Path("login")
    @Produces("text/html")
    public Response login(@QueryParam("paramEmail") String login) {
        boolean isUserExist = false;
        java.net.URI location = null;

        UserService userService = (UserService) SpringFactory.getspringApplicationContext().getBean("userService");
        isUserExist = userService.CheckUser(login);

        if (isUserExist == true) {
            try {
                SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
                User user = userService.getUserByLogin(login);
                sessionBean.setCurrentUser(user);
                location = new java.net.URI("../main-menu.jsp");
            } catch (URISyntaxException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        try {
                location = new java.net.URI("../login-error.jsp");
            } catch (URISyntaxException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }

        return Response.temporaryRedirect(location).build();
    }
    
    @GET
    @Path("create")
    @Produces("text/html")
    public Response create(@QueryParam("paramLogin") String login, @QueryParam("paramName") String name,  @QueryParam("paramPassword") String password, @QueryParam("paramRole") String role) {
        java.net.URI location = null;        
        
        try {
            User user = new User();
            user.setId(0);
            user.setLogin(login);
            user.setName(name);
            user.setPassword(password);           
            Date date = new Date();
            user.setRegistrationDate(date);            
            user.setAdmin(role);
            
            UserService userService = (UserService) SpringFactory.getspringApplicationContext().getBean("userService");
            userService.createUser(user);
            
            SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
            User currentUser = sessionBean.getCurrentUser();
            
            Stat stat = new Stat();
            stat.setId(0);
            String currentUserName = currentUser.getName();
            String userName = user.getName();
            int userId = user.getId(); 
            String description = currentUserName + " create a new user: " + userName + " New user ID: " + userId;
            stat.setDescription(description);
            date = new Date();
            stat.setDate(date);
            int currentUserId = currentUser.getId();
            stat.setUserId(currentUserId);
            
            StatService statService = (StatService) SpringFactory.getspringApplicationContext().getBean("statService"); 
            statService.createStat(stat);                        
            
            location = new java.net.URI("../user-menu.jsp");

        } catch (URISyntaxException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }
}
