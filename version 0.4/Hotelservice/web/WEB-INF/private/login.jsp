<%-- 
    Document   : login
    Created on : 18.11.2015, 16:43:49
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Авторизация</h1>
<a href="index.jsp">На главную</a>
<form action="j_security_check" method="POST">
    <div id="loginBox">
        <p><strong>Ваш логин:</strong>
            <input placeholder="Введите логин" type="text" size="20" name="j_username"></p>
        <p><strong>Пароль:</strong>
            <input placeholder="Введите пароль" type="password" size="20" name="j_password"></p>
        <p><input type="submit" value="Авторизоваться"></p>
    </div>
</form>