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
                                   <div class="text-article">
                        <c:if test="${notif ne null}">
                             <div class="notif">
                                 <span>${notif}</span> 
                             </div>
                        </c:if>
            </section>
        </div>
