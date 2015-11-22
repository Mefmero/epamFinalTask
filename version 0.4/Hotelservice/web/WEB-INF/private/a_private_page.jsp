<%-- 
    Document   : a_private_page
    Created on : 18.11.2015, 19:39:40
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Добро пожаловать в раздел администрирования, ${name}!</h1>
        <a href="a_messages">Посмотреть заявки</a>
        <a href="a_delete_message">Удалить заявку</a>
        <a href="a_rooms">Посмотреть информацию о номерах</a>
        <a href="a_bills">Выписать счет</a>
        <a href="a_watch_bill">Посмотреть счета</a>
        <a href="a_delete_bill">Удалить счет</a>
        <a href="a_redact_bill">Отредактировать счет</a>
        <a href="logout">Выйти</a>
    </body>
</html>
