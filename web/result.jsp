<%-- 
    Document   : result
    Created on : 2018-05-15, 10:44:01
    Author     : emikarp
--%>

<%@page import="pl.myapplication.model.Book"%>
<%@page import ="pl.myapplication.model.User"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
   Book book = null;
   User user = null;        
            
   if (request.getAttribute("book") != null){
        book = (Book)request.getAttribute("book");
   } else if (request.getAttribute("user") != null){
        user = (User)request.getAttribute("user");
   }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wyniki operacji <%= request.getAttribute("option")%></title>
    </head>
    <body>
        <h1>Wynik operacji <%= request.getAttribute("option")%></h1>
        <p>W wyniku Twojego zapytania otrzymano następujące rekordy:</p>
        
        <% if (book != null){ %>
            <p>Tytuł: <%= book.getTitle()%><br>
            ISBN: <%= book.getIsbn()%> <br>
            Opis: <%= book.getDescription()%></p>
        <% } else if (user != null) { %>
            <p>Pesel: <%= user.getPesel()%><br>
            First Name: <%= user.getFirstName()%> <br>
            Last Name: <%= user.getLastName()%></p>
        <% } %>    
    
    </body>
</html>
