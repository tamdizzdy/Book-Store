<%-- 
    Document   : promotionList
    Created on : Jun 6, 2021, 12:45:39 AM
    Author     : DELL
--%>

<%@page import="tblPromotion.PromotionDTO"%>
<%@page import="cart.CartObject"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>View Promotion List</title>
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
                </ul>
            </div>
        </nav>
        <font color="red"> ${requestScope.NOTI} </font><br>

        <% CartObject cart = (CartObject) session.getAttribute("CART");
            if (cart != null) {
                if (cart.getCart() != null) {
        %>
        
        <table border="1">
            <form action="adminActionList" method="POST">
                <thead>
                <input type="submit" name="Action" value="Save to database">
                <tr>
                    <th>No</th>
                    <th>UserID</th>
                    <th>Full Name User</th>
                    <th>Rank</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                    <% int count = 0; %>
                    <% for (PromotionDTO dto : cart.getCart().values()) {
                            count++;
                    %>
                    <form action="adminActionList" method="POST">
                    <tr>
                        <td><%= count%></td>
                        <td><input type="text" name="user" value="<%= dto.getUserID()%>" readonly></td>
                        <td><input type="text" name="name" value="<%= dto.getNameUser()%>" readonly</td>
                        <td><input type="text" name="rank" value="<%= dto.getRank()%>"></td>
                        <td><input type="hidden" name="userID" value="<%= dto.getUserID()%>">
                            <input class="btn btn-danger" type="submit" name="Action" value="Delete">
                            <input class="btn btn-success" type="submit" name="Action" value="Update">
                        </td>
                    </tr>
                    </form>
                    <% } %>
                </tbody>
            </form>
        </table>

        <% } else {  %> 
        <h2><font color="red"> List is empty </font></h2>
            <% }%>  
            <% }%> 

        <a class="nav-link" href="#" style="font-weight: bold;"> -- LIST ALL USER IN PROMOTION LIST -- </a>
            <form action="viewListPromotion" method="POST">
            Search by date add: <input type="date" name="dateAdd">
            <input type="submit" name="search" value="Search"><br>
            </form>
            <c:set var="listAll" value="${requestScope.LIST_PROMOTION}"/>
        <c:if test="${not empty listAll}">
            
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>UserID</th>
                        <th>Full Name User</th>
                        <th>Rank</th>
                        <th>Date add</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.LIST_PROMOTION}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.userID}</td>
                            <td>${dto.nameUser}</td>
                            <td>${dto.rank}</td>
                            <td>${dto.dateAdd}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

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
