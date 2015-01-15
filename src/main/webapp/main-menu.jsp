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
            <h3>Банковская система онлайн.Главное меню</h3>
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
                    <th>Описание</th>
                    <th>Меню</th>
                </tr>
                <tr>
                    <td>Баланс текущего пользователя</td>
                    <td>
                        <form action="balance.jsp?paramName=123">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-usd" aria-hidden="true"></span> Меню баланса
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Конвертер валют</td>
                    <td>
                        
                            <button class="btn btn-danger btn-block" type="submit">
                                <span class="glyphicon glyphicon-retweet" aria-hidden="true"></span> Меню конвертера валют
                            </button>

                    </td>    
                </tr>
                <tr>
                    <td>Платежи текущего пользователя</td>
                    <td>
                        <form action="payment-menu.jsp">
                            <button class="btn btn-info btn-block">
                                <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span> Меню платежей
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Статистика</td>
                    <td>
                        <form action="stat-menu.jsp">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Меню статистики
                            </button> 
                        </form>
                    </td>
                </tr>

                <%
                    if (user != null) {
                        if (user.getAdmin().equals("admin")) {
                            out.write("<tr>");
                            out.write("<td>Управление пользователями</td>");
                            out.write("<td>");
                            out.write("<form action=\"user-menu.jsp\">");
                            out.write("<button class=\"btn btn-warning btn-block\">");
                            out.write("<span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> Меню пользователей");
                            out.write("</button>");
                            out.write("</form>");
                            out.write("</td>");
                            out.write("</tr>");

                            out.write("<tr>");
                            out.write("<td>Управление картами</td>");
                            out.write("<td>");
                            out.write("<form action=\"card-menu.jsp\">");
                            out.write("<button class=\"btn btn-warning btn-block\">");
                            out.write("<span class=\"glyphicon glyphicon-credit-card\" aria-hidden=\"true\"></span> Меню карт");
                            out.write("</button>");
                            out.write("</form>");
                            out.write("</td>");
                            out.write("</tr>");
                        }
                    }
                %>

            </table>

            <form class="form-signin" method="GET" action="/onlinebanking/webresources/logout">
                <button class="btn btn-info" type="submit">
                    <span class="glyphicon glyphicon-off"></span> Выход
                </button>
            </form>
        </div>

    </body>
</html>
