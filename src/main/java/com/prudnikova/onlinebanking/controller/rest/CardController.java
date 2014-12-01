package com.prudnikova.onlinebanking.controller.rest;

import com.prudnikova.SessionBean;
import com.prudnikova.SpringFactory;
import com.prudnikova.onlinebanking.model.Card;
import com.prudnikova.onlinebanking.model.Stat;
import com.prudnikova.onlinebanking.model.User;
import com.prudnikova.onlinebanking.service.CardService;
import com.prudnikova.onlinebanking.service.StatService;
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
            
            SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
            User currentUser = sessionBean.getCurrentUser();
            
            UserService userService = (UserService) SpringFactory.getspringApplicationContext().getBean("userService");
            
            Stat stat = new Stat();
            stat.setId(0);
            String currentUserName = currentUser.getName();
            int cardId = card.getId();
            String description = currentUserName + " create a new card for user ID: " + userId + ".Card currency is: " + currency + ". Balance: " + balance + " New card ID: " + cardId;
            stat.setDescription(description);
            Date date = new Date();
            stat.setDate(date);
            int currentUserId = currentUser.getId();
            stat.setUserId(currentUserId);
            
            StatService statService = (StatService) SpringFactory.getspringApplicationContext().getBean("statService"); 
            statService.createStat(stat);
            
            location = new java.net.URI("../card-menu.jsp");

        } catch (URISyntaxException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }
    
}
