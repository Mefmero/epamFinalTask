<%-- 
    Document   : login
    Created on : 18.11.2015, 16:43:49
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <div id="main">
<aside class="leftAside">
<h1>Авторизация</h1>
<p>Введите свой логин и пароль, чтобы получить доступ к личному кабинету..
</p>
</aside>
<section>
<form action="j_security_check" method="POST">
    <div id="loginBox">
        <p><strong>Ваш логин:</strong>
            <input placeholder="Введите логин" type="text" size="20" name="j_username"></p>
        <p><strong>Пароль:</strong>
            <input placeholder="Введите пароль" type="password" size="20" name="j_password"></p>
        <p><input type="submit" value="Авторизоваться"></p>
    </div>
</form>
</section>
 </div>