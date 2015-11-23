<%-- 
    Document   : private_page
    Created on : 18.11.2015, 16:41:17
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="main">
<aside class="leftAside">
        <h1>Добро пожаловать в пользовательский раздел, ${name}!</h1>
        <p>Тут вы можете редактировать и создавать заявки на бронирование.
        </p>
</aside>
<section>
        <a href="messages">Оставить заявку</a>
        <a href="delete_message">Удалить заявку</a>
        <a href="redact_message">Отредактировать заявку</a>
        <a href="watch_message">Посмотреть заявку</a>
        <a href="bill">Просмотреть счета</a>
        <a href="logout">Выйти</a>
</section>
</div>
