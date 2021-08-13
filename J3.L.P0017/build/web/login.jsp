<%-- 
    Document   : login
    Created on : May 30, 2021, 9:15:47 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/registration.css">
    <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
    <link rel="stylesheet" href="css/login.css">
</head>
    <body>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <c:if test="${not empty requestScope.NOTI}">
            <font color="red">${requestScope.NOTI}</font>
        </c:if>
        <form action="login" method="POST">
            <div class="container">
                <div style="text-align: center;">
                    <h1>Login</h1>
                </div>
                <hr>
            <label><b>User ID</b></label>
            <input type="text" name="userID"placeholder="Enter UserID"/><br>
            <label><b>Password</b></label>
            <input type="password" name="password"placeholder="Enter Password"/><br>
            <div class="g-recaptcha"
                 data-sitekey="6Ldg4tgaAAAAAPLUNZUahIgO-6QnjbYVRL5-eOVZ"></div>
            <hr>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/><br>
            </div>
        </form>
            
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>    
    </body>
</html>
