package com.prudnikova.onlinebanking.controller.rest;

import com.prudnikova.SpringFactory;
import com.prudnikova.onlinebanking.model.Card;
import com.prudnikova.onlinebanking.model.User;
import com.prudnikova.onlinebanking.service.CardService;
import com.prudnikova.onlinebanking.service.UserService;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("cards")
public class CardController {
    
    public CardController() {
    }
    
    @GET
    @Path("create")
    @Produces("text/html")
    public Response create(@QueryParam("paramCurrency") String currency, @QueryParam("paramBalance") int balance,  @QueryParam("paramState") String state, @QueryParam("paramUserId") int userId) {
        java.net.URI location = null;        
        
        try {
            Card card = new Card();
            card.setId(0);
            card.setCurrency(currency);
            card.setBalance(balance);
            card.setState(state);
            card.setUserId(userId);
            
            CardService cardService = (CardService) SpringFactory.getspringApplicationContext().getBean("cardService");
            cardService.createCard(card);
            location = new java.net.URI("../card-menu.jsp");

        } catch (URISyntaxException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }
    
}
