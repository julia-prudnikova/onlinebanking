package com.prudnikova.onlinebanking.controller.rest;

import com.prudnikova.SessionBean;
import com.prudnikova.SpringFactory;
import com.prudnikova.onlinebanking.model.Card;
import com.prudnikova.onlinebanking.model.Stat;
import com.prudnikova.onlinebanking.model.User;
import com.prudnikova.onlinebanking.service.CardService;
import com.prudnikova.onlinebanking.service.StatService;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("pay")
public class PayController {

    public PayController() {

    }

    @GET
    @Path("phone")
    @Produces("text/html")
    public Response payPhone(@QueryParam("paramCardId") int cardId, @QueryParam("paramPayment") int payment) {
        java.net.URI location = null;

        try {
            SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
            User currentUser = sessionBean.getCurrentUser();

            if (currentUser != null) {
                CardService cardService = (CardService) SpringFactory.getspringApplicationContext().getBean("cardService");
                Card card = cardService.readCard(cardId);
                int balance = card.getBalance();

                if (balance >= payment) {

                    balance -= payment;
                    card.setBalance(balance);
                    cardService.updateCard(card);

                    Stat stat = new Stat();
                    stat.setId(0);
                    String currentUserName = currentUser.getName();
                    String description = currentUserName + " pay for phone. Summ: " + payment;
                    stat.setDescription(description);
                    Date date = new Date();
                    stat.setDate(date);
                    int currentUserId = currentUser.getId();
                    stat.setUserId(currentUserId);

                    StatService statService = (StatService) SpringFactory.getspringApplicationContext().getBean("statService");
                    statService.createStat(stat);

                    location = new java.net.URI("../main-menu.jsp");
                } else {
                    location = new java.net.URI("../balance-low.jsp");
                }
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }

    @GET
    @Path("home")
    @Produces("text/html")
    public Response payHome(@QueryParam("paramCardId") int cardId, @QueryParam("paramPayment") int payment) {
        java.net.URI location = null;

        try {
            SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
            User currentUser = sessionBean.getCurrentUser();

            if (currentUser != null) {
                CardService cardService = (CardService) SpringFactory.getspringApplicationContext().getBean("cardService");
                Card card = cardService.readCard(cardId);
                int balance = card.getBalance();

                if (balance >= payment) {

                    balance -= payment;
                    card.setBalance(balance);
                    cardService.updateCard(card);

                    Stat stat = new Stat();
                    stat.setId(0);
                    String currentUserName = currentUser.getName();
                    String description = currentUserName + " pay for home. Summ: " + payment;
                    stat.setDescription(description);
                    Date date = new Date();
                    stat.setDate(date);
                    int currentUserId = currentUser.getId();
                    stat.setUserId(currentUserId);

                    StatService statService = (StatService) SpringFactory.getspringApplicationContext().getBean("statService");
                    statService.createStat(stat);

                    location = new java.net.URI("../main-menu.jsp");
                } else {
                    location = new java.net.URI("../balance-low.jsp");
                }
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }

}
