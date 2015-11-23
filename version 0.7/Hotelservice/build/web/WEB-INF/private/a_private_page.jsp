<%-- 
    Document   : a_private_page
    Created on : 18.11.2015, 19:39:40
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="main">
<aside class="leftAside">
        <h1>Добро пожаловать в раздел администрирования, ${name}!</h1>
        <p>Будьте внимательны при редактировании заявок и создании счетов.
        </p>
</aside>
<section>
        <a href="a_messages">Посмотреть заявки</a>
        <a href="a_delete_message">Удалить заявку</a>
        <a href="a_rooms">Посмотреть информацию о номерах</a>
        <a href="a_bills">Выписать счет</a>
        <a href="a_watch_bill">Посмотреть счета</a>
        <a href="a_delete_bill">Удалить счет</a>
        <a href="a_redact_bill">Отредактировать счет</a>
        <a href="logout">Выйти</a>
</section>
</div>