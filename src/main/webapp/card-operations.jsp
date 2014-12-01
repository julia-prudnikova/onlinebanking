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

        <title>Cards operations page</title>
    </head>
    <body>
        <div class="container">
            <h3>Cards operations menu</h3>
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

            <form class="form-signin" method="GET" action="/onlinebanking/webresources/cards/create">
                <input name = "paramCurrency" type="text" id="login" class="form-control" placeholder="currency (dollar, euro)">   
                <br>
                <input name = "paramBalance" type="text" id="name" class="form-control" placeholder="balance">                          
                <br>
                <input name = "paramState" type="text" id="password" class="form-control" placeholder="State (active, disabled)">
                <br>
                <input name = "paramUserId" type="text" id="role" class="form-control" placeholder="use ID">
                <br>
                <br>

                <table>
                    <tr>
                        <td>

                            <button class="btn btn-info" type="submit">
                                <span class="glyphicon glyphicon-credit-card"></span> Create new card
                            </button>
                            </form>
                        </td>
                        <td>
                            &nbsp
                        </td>

                        <td>
                            <form action="card-menu.jsp">
                                <button class="btn btn-info">
                                    <span class="glyphicon glyphicon-credit-card"></span> Back to card menu
                                </button>
                            </form>
                        </td>
                    </tr>
                </table>

        </div>
    </body>
</html>