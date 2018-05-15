<%-- 
    Document   : index
    Created on : 2018-05-15, 10:43:50
    Author     : emikarp
--%>

<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Viewer</title>
    </head>
    <body>
        <h1>Welcome to Library Viewer</h1>
        <form action="BookServlet" method="post">
            <input type="text" placeholder="ISBN" name="isbn"><br>
            <input type="text" placeholder="Tytuł" name="title"><br>
            <input type="text" placeholder="Opis" name="description"><br>
            Szukaj<input type="radio" name="option" value="search"> 
            Dodaj <input type="radio" name="option" value="add">
            Edytuj <input type="radio" name="option" value="update">
            Usuń <input type="radio" name="option" value="delete">
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
