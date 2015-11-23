<%-- 
    Document   : index
    Created on : 14.11.2015, 17:35:59
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div id="main">
            <aside class="leftAside">
                <h2>Добро пожаловать в сервис бронирования номеров</h2>
                <p>На этой странице вы можете просмотреть информацию о доступных номерах.
                    Чтобы забронировать номер войдите или зарегестрируйтесь. 
                </p>
            </aside>
            <section>  
        <a href="login">Вход</a>
        <a href="registration">Регистрация</a>
        <c:forEach var="room" step="4" items="${rooms}">
                        <room>
			<h1>${room.type}</h1>
                        <div class="text-room">
                        ${fn:substring(room.rdesc,0,297)} ...
                        </div>
                       <div class="fotter-room">
                        <span class="read"><a href="room?id=${room.id}">
                                     Читать...</a></span>
                        </div>
                        </room>
           </c:forEach>
            </section>
        </div>