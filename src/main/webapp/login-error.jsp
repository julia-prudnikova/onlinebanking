<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>

        <title>Login error page</title>
    </head>
    <body>
        <div class="form-signin">
            <h3>Current user does not exist!!!</h3>

            <form action="login.html">
                <button class="btn btn-lg btn btn-warning btn-block" type="submit">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span> Please, try again
                </button>
            </form>
            
        </div>
    </body>
</html>
