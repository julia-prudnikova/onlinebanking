<%@page import="com.prudnikova.onlinebanking.model.User"%>
<%@page import="com.prudnikova.SpringFactory"%>
<%@page import="com.prudnikova.SessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <link href="resources/css/bank.css" rel="stylesheet">

        <title>Payment operations page</title>
    </head>
    <body>
        <div class="container">
            <h3>Users operations menu</h3>
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

            <table>
                <tr>
                    <td>
                        <form class="form-signin" method="GET" action="/onlinebanking/webresources/pay/phone">                                                        
                            <input name = "paramCardId" type="text" id="login" class="form-control" placeholder="Card id" required autofocus>                            

                            </td>
                            <td> &nbsp</td>
                            <td>
                                <input name = "paramPayment" type="text" id="login" class="form-control" placeholder="Pay phone balance" required autofocus>
                            </td>
                            <td> &nbsp</td>
                            <td>
                                <button class="btn btn-info btn-block" type="submit">
                                    <span class="glyphicon glyphicon-usd" aria-hidden="true"></span> Pay for phone
                                </button>
                            </td>
                        </form>
                </tr>
                <tr>
                    <td><br></td>
                </tr>
                <tr>
                    <td>
                        <form class="form-signin" method="GET" action="/onlinebanking/webresources/pay/home">
                            <input name = "paramCardId" type="text" id="login" class="form-control" placeholder="Card Id" required autofocus>                            
                            </td>
                            <td> &nbsp</td>
                            <td>
                                <input name = "paramPayment" type="text" id="login" class="form-control" placeholder="Pay home balance" required autofocus>
                            </td>
                            <td> &nbsp</td>
                            <td>
                                <button class="btn btn-info btn-block" type="submit">
                                    <span class="glyphicon glyphicon-usd" aria-hidden="true"></span> Pay for home
                                </button>
                            </td>
                        </form>
                </tr>
            </table>

            <br>
            <form action="main-menu.jsp">
                <button class="btn btn-info">
                    <span class="glyphicon glyphicon-home"></span> Back to main menu
                </button>
            </form>

        </div>
    </body>
</html>