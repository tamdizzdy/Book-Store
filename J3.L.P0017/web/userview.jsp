<%-- 
    Document   : userview
    Created on : May 30, 2021, 7:26:32 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User View</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/background.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#" style="color: green;">The User Management</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#" style="font-weight: bold;" >Welcome ${requestScope.USER.name}</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
 
        </nav>
                    
        <font color="red"> ${requestScope.UPDATE}</font></br>
        <table border="1">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Image</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>               
            <tr>
            <form action="userAction" method="POST" enctype="multipart/form-data">    
                
                <c:set var="errors" value="${requestScope.ERROR}"/>
                <c:if test="${not empty errors.nameError}">
                    <font color = "red">${errors.nameError}</font><br>
                </c:if>
                <c:if test="${not empty errors.addressError}">
                    <font color = "red">${errors.addressError}</font><br>
                </c:if>
                
                <th>${requestScope.USER.userID}
                    <input type="hidden" name="userID" value="${requestScope.USER.userID}" >
                </th>   
                <th><input type="text" name="name" value="${requestScope.USER.name}">                    
                </th>
                <td> <img src="images/${requestScope.USER.image}" width="100" height="100">
                    <input type="file" name="file">
                </td>
                <th><input type="text" name="address" value="${requestScope.USER.address}">
                </th>
                <th><input class="btn btn-success" type="submit" name="Action" value="Update"></th>
                
            </form>
        </tr>                               
    </tbody>
</table>
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
