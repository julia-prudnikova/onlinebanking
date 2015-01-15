<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>

        <title>Balance low page</title>
    </head>
    <body>
        <div class="form-signin">
            <h4>Недостаточно средств!</h4>
            <br>
            <form action="payment-menu.jsp">
                <button class="btn btn-info">
                    <span class="glyphicon glyphicon-home"></span> Вернуться в меню оплаты
                </button>
            </form>            
        </div>
    </body>
</html>
