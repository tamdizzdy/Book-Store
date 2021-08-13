<%-- 
    Document   : create
    Created on : Jun 5, 2021, 4:46:06 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/background.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="adminView" style="color: green;">The User Management</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                </ul>

            </div>
        </nav>
        
        <form action="Create" method="POST" enctype="multipart/form-data">
            <form action="login" method="POST">
            <div class="container">
                <div style="text-align: center;">
                    <h1>Login</h1>
                </div>
                <hr>
            <c:set var="errors" value="${requestScope.ERROR}"/>

            User ID : <input type="text" name="userID"  size="10" value="${usercancel.userID}"/>*</br>
            <c:if test="${not empty errors.userIDError}">
                <font color = "red">${errors.userIDError}</font><br>
            </c:if>

            Password : <input type="password" name="password"/>*</br>
            <c:if test="${not empty errors.passwordError}">
                <font color = "red">${errors.passwordError}</font><br>
            </c:if>

            Confirm : <input type="password" name="confirm"/>*</br>
            <c:if test="${not empty errors.confirmPassword}">
                <font color = "red">${errors.confirmPassword}</font><br>
            </c:if>

            Name : <input type="text" name="name" size="15"  value="${usercancel.name}"/>*</br>
            <c:if test="${not empty errors.nameError}">
                <font color = "red">${errors.nameError}</font><br>
            </c:if>
            Address : <input type="text" name="address" value="${usercancel.address}"/>*</br>
            <c:if test="${not empty errors.addressError}">
                <font color = "red">${errors.addressError}</font><br>
            </c:if>
            Image : <input type="file" name="file"><br>
            <hr>
            <input type="submit" value="Create">
            <input type="reset" value="Reset"> <br>
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
