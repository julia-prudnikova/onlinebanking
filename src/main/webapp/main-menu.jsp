<%@page import="com.prudnikova.onlinebanking.model.User"%>
<%@page import="com.prudnikova.SessionBean"%>
<%@page import="com.prudnikova.SessionBean"%>
<%@page import="com.prudnikova.SpringFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <link href="resources/css/bank.css" rel="stylesheet">

        <title>Main menu Page</title>
    </head>
    <body>
        <div class="container">
            <h3>Online banking system main menu</h3>
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
                    <th>Description</th>
                    <th>Menu</th>
                </tr>
                <tr>
                    <td>Money balance</td>
                    <td>
                        <form action="balance.jsp?paramName=123">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-usd" aria-hidden="true"></span> Balance menu
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Exchange currency</td>
                    <td>
                        <form action="login.html">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-retweet" aria-hidden="true"></span> Exchange menu
                            </button>
                        </form>
                    </td>    
                </tr>
                <tr>
                    <td>Payment operations</td>
                    <td>
                        <form action="">
                            <button class="btn btn-info btn-block">
                                <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span> Payment menu
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Statistic</td>
                    <td>
                        <form action="stat-menu.jsp">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Statistic menu
                            </button> 
                        </form>
                    </td>
                </tr>

                <%
                    if (user != null) {
                        if (user.getAdmin().equals("admin")) {
                            out.write("<tr>");
                            out.write("<td>User operations</td>");
                            out.write("<td>");
                            out.write("<form action=\"user-menu.jsp\">");
                            out.write("<button class=\"btn btn-warning btn-block\">");
                            out.write("<span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> User menu");
                            out.write("</button>");
                            out.write("</form>");
                            out.write("</td>");
                            out.write("</tr>");

                            out.write("<tr>");
                            out.write("<td>User operations</td>");
                            out.write("<td>");
                            out.write("<form action=\"card-menu.jsp\">");
                            out.write("<button class=\"btn btn-warning btn-block\">");
                            out.write("<span class=\"glyphicon glyphicon-credit-card\" aria-hidden=\"true\"></span> Card menu");
                            out.write("</button>");
                            out.write("</form>");
                            out.write("</td>");
                            out.write("</tr>");
                        }
                    }
                %>

            </table>

            <form class="form-signin" method="GET" action="/onlinebanking/webresources/logout">
                <button class="btn btn-warning" type="submit">
                    <span class="glyphicon glyphicon-off"></span> Log out
                </button>
            </form>
        </div>

    </body>
</html>
