<%@page import="com.prudnikova.onlinebanking.service.UserService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.prudnikova.onlinebanking.model.Card"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.prudnikova.onlinebanking.service.CardService"%>
<%@page import="com.prudnikova.onlinebanking.model.User"%>
<%@page import="com.prudnikova.SpringFactory"%>
<%@page import="com.prudnikova.SessionBean"%>
<%@page import="com.prudnikova.SessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <link href="resources/css/bank.css" rel="stylesheet">

        <title>Cards menu page</title>
    </head>
    <body>
        <div class="container">
            <h3>Cards menu</h3>
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

            <table class="table table-striped">
                <tr>
                    <th>Card id</th>
                    <th>Currency</th>
                    <th>Balance</th>
                    <th>State</th>
                    <th>Owner</th>
                </tr>

                <%
                    UserService userService = (UserService) SpringFactory.getspringApplicationContext().getBean("userService");
                    CardService cardService = (CardService) SpringFactory.getspringApplicationContext().getBean("cardService");
                    List<Card> cardsList = new ArrayList<>();
                    cardsList = cardService.getAllCards();

                    for (int i = 0; i < cardsList.size(); i++) {
                        Card card = cardsList.get(i);
                        if (user != null) {
                            out.write("<tr>");
                            int cardId = card.getId();
                            out.write("<td>" + cardId + "</td>");

                            String currency = card.getCurrency();
                            out.write("<td>" + currency + "</td>");

                            int balance = card.getBalance();
                            out.write("<td>" + balance + "</td>");

                            String state = card.getState();
                            out.write("<td>" + state + "</td>");

                            int userId = card.getUserId();
                            user = userService.readUser(userId);
                            if (user != null) {
                                String userName = user.getName();
                                out.write("<td>" + userName + "</td>");

                            } else {
                                out.write("<td></td>");
                            }
                            out.write("</tr>");
                        }

                        out.write("");
                    }
                %>

            </table>    


            <table> 
                <tr>
                    <td>
                        <form action="card-operations.jsp">
                            <button class="btn btn-warning" type="submit">
                                <span class="glyphicon glyphicon-credit-card"></span> Card operations
                            </button>
                        </form>
                    </td>
                    <td>
                        &nbsp
                    </td>
                    <td>
                        <form action="main-menu.jsp">
                            <button class="btn btn-warning" type="submit">
                                <span class="glyphicon glyphicon-home"></span> Back to main menu
                            </button>
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
