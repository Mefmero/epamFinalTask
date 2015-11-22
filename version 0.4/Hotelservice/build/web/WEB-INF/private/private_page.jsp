<%-- 
    Document   : private_page
    Created on : 18.11.2015, 16:41:17
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Добро пожаловать в пользовательский раздел, ${name}!</h1>
        <a href="messages">Оставить заявку</a>
        <a href="bills">Просмотреть счета</a>
        <a href="logout">Выйти</a>
    </body>
</html>
