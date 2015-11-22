<%-- 
    Document   : bills
    Created on : 19.11.2015, 18:20:34
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="main">
            <aside class="leftAside">
                <h2>Ваши счета</h2>
                <p>Вы можете оплатить счета в ближайшем терминале банка, используя номер ИНН. 
                </p>
            </aside>
               <section>
               <a href="logout">Выйти</a>
               <a href="login">В кабинет</a>
               <h1>Ваш счет(если его нет, значит администратор еще не успел посмотреть ваш запрос)</h1>
               <bill>
                   ${bill.name}
               </bill>
            </section>
        </div>
