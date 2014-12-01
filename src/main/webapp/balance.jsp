<%@page import="java.util.ArrayList"%>
<%@page import="com.prudnikova.onlinebanking.model.Card"%>
<%@page import="java.util.List"%>
<%@page import="com.prudnikova.onlinebanking.service.CardService"%>
<%@page import="com.prudnikova.onlinebanking.model.User"%>
<%@page import="com.prudnikova.SessionBean"%>
<%@page import="com.prudnikova.SessionBean"%>
<%@page import="com.prudnikova.SpringFactory"%>
<%@page import="com.prudnikova.SpringFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <link href="resources/css/bank.css" rel="stylesheet">

        <title>Balance menu page</title>
    </head>
    <body>
        <div class="container">

            <h3>Online banking system balance menu</h3>
            <br>         
            <br>
            <h4>
                <span class="glyphicon glyphicon-user"></span>
                <%
                    SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
                    User user = sessionBean.getCurrentUser();
                    String login = "";
                    if (user != null) {
                        login = user.getName();

                        String admin = user.getAdmin();
                        login += " (" + admin + ")";
                    }

                %>
                <%=login%>
            </h4>
            <br>  

            <%
                if (user != null) {
                    CardService cardService = (CardService) SpringFactory.getspringApplicationContext().getBean("cardService");
                    List<Card> cardsList = new ArrayList<>();
                    cardsList = cardService.getAllCards();
                    List<Card> finalCardsList = new ArrayList<>();
                    
                    for (int i = 0; i < cardsList.size(); i++) {
                        Card card = cardsList.get(i);
                        if (card != null) {
                            int userId = card.getUserId();
                            if (userId == user.getId()) {
                                finalCardsList.add(card);
                            } 
                        }
                    }

                    for (int i = 0; i < finalCardsList.size(); i++) {
                        out.write("<table class=\"table table-striped\">");
                        out.write("<tr>");
                        out.write("<th>Card number</th>");
                        out.write("<th>Card currency</th>");
                        out.write("<th>Card balance</th>");
                        out.write("<th>Card state</th>");
                        out.write("</tr>");

                        Card card = finalCardsList.get(i);
                        if (card != null) {
                            int cardId = card.getId();
                            out.write("<td>" + cardId + "</td>");

                            String cardCurrency = card.getCurrency();
                            out.write("<td>" + cardCurrency + "</td>");

                            int cardBalance = card.getBalance();
                            out.write("<td>" + cardBalance + "</td>");

                            String cardState = card.getState();
                            out.write("<td>" + cardState + "</td>");
                        }

                        out.write("<tr>");
                        out.write("</tr>");
                        out.write("</table>");
                        out.write("<br>");
                    }
                }
            %>

            <form action="main-menu.jsp">
                <button class="btn btn-warning">
                    <span class="glyphicon glyphicon-home"></span> Back to main menu
                </button>
            </form>

        </div>
    </body>
</html>
