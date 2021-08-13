<%-- 
    Document   : adminview
    Created on : May 31, 2021, 11:33:15 PM
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
        <title>Admin View</title>
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
                        <a class="nav-link" href="#" style="font-weight: bold;" >Welcome ${sessionScope.LOGIN_USER.name}</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <a href="createPage">Create New Account</a><br>
        <a href="promotionListPage">View Promotion List</a><br>
        <form action="adminView" method="POST">
            Search By Name <input type="text" name="txtSearchName" value="${param.txtSearchName}"/>
            <input type="submit" name="searchAll" value="Search"><br>
        </form>
        <font color="red"> ${requestScope.DELETE} </font><br>
        <font color="red"> ${requestScope.UPDATE} </font><br>
        <font color="red"> ${requestScope.NOTI} </font><br>
        <c:set var="listAll" value="${requestScope.LIST_ALL}"/>
        <c:set var="searchName" value="${param.txtSearchName}"/>
        <c:if test="${empty listAll}">
            <font color="red"> No record </font><br>
        </c:if>
        <c:if test="${not empty listAll}">
            <div class="container">
                <div style="text-align: center;">
                </div>
            <a class="nav-link" href="#" style="font-weight: bold;"> -- LIST ALL -- </a>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>User ID</th>      
                        <th>Full Name</th>
                        <th>Image</th>
                        <th>Address</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${listAll}" varStatus="counter">
                        <tr>
                    <form action="adminAction" method="POST">
                        <td>${counter.count}</td>
                        <td>${dto.userID}
                            <input type="hidden" name="userID" value="${dto.userID}">
                        </td>
                        <td><input type="text" name="name" value="${dto.name}" readonly></td>
                        <td> <img src="images/${dto.image}" width="100" height="100">
                        </td>
                        <td><input type="text" name="address" value="${dto.address}" readonly></td>             
                        <td>
                            <c:if test="${dto.roleID == 2}">
                                <input class="btn btn-danger" type="submit" name="Action" value="Delete">
                                <input class="btn btn-success" type="submit" name="Action" value="Update">
                            </c:if>
                        </td>
                    </form>
                </tr> 
            </c:forEach>
        </tbody>
    </table> 
            
    <a class="nav-link" href="#" style="font-weight: bold;"> -- LIST USER --</a>        
    
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>User ID</th>
                <th>Full Name</th>
                <th>Image</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dto" items="${listAll}" varStatus="counter">
                <tr>
            <form action="adminAction" method="POST">
                <c:if test="${dto.roleID == 2}">
                    <td>${counter.count}</td>
                    <th>${dto.userID}
                        <input type="hidden" name="userID" value="${dto.userID}">
                    </th>
                    <th><input type="text" name="name" value="${dto.name}" readonly></th>
                    <td> <img src="images/${dto.image}" width="100" height="100">
                    </td>
                    <th><input type="text" name="address" value="${dto.address}" readonly></th>             
                    <th>
                        <input class="btn btn-success" type="submit" name="Action" value="Add to promotion">
                    </th>
                </c:if>
            </form>
        </tr> 
    </c:forEach>
</tbody>
</table>

<a class="nav-link" href="#" style="font-weight: bold;"> -- LIST ADMIN -- </a>

<table border="1">
    <thead>
        <tr>
            <th>No</th>
            <th>User ID</th>
            <th>Full Name</th>
            <th>Image</th>
            <th>Address</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="dto" items="${listAll}" varStatus="counter">
            <tr>
        <form action="adminAction" method="POST">
            <c:if test="${dto.roleID == 1}">
                <td>${counter.count}</td>
                <th>${dto.userID}
                    <input type="hidden" name="userID" value="${dto.userID}">
                </th>
                <th><input type="text" name="name" value="${dto.name} " readonly></th>
                <td> <img src="images/${dto.image}" width="100" height="100">
                </td>
                <th><input type="text" name="address" value="${dto.address} " readonly></th>
                </c:if>
        </form>
    </tr> 
</c:forEach>
</tbody>
</table>
            </div>
</c:if>
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
