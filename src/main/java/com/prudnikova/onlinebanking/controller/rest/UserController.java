package com.prudnikova.onlinebanking.controller.rest;

import com.prudnikova.SpringFactory;
import com.prudnikova.onlinebanking.service.UserService;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("generic")
public class UserController {

    public UserController() {
    }

    @GET
    @Produces("text/html")
    public Response login(@QueryParam("paramEmail") String login) {
        boolean isUserExist = false;
        java.net.URI location = null;

        UserService userService = (UserService) SpringFactory.getspringApplicationContext().getBean("userService");
        isUserExist = userService.CheckUser(login);

        if (isUserExist == true) {
            try {
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
}