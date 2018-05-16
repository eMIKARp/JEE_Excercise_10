<%-- 
    Document   : usermanager
    Created on : 2018-05-15, 16:43:57
    Author     : emikarp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manager</title>
    </head>
    <body>
        <h1>Welcome to User Manager</h1>
        <form action="UserServlet" method="post">
            <input type="text" placeholder="Pesel" name="pesel"><br>
            <input type="text" placeholder="First Name" name="firstname"><br>
            <input type="text" placeholder="Last Name" name="lastname"><br>
            Szukaj <input type="radio" name="option" value="search"> 
            Dodaj <input type="radio" name="option" value="add">
            Edytuj <input type="radio" name="option" value="update">
            Usuń <input type="radio" name="option" value="delete">
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
