<%-- 
    Document   : a_rooms
    Created on : 19.11.2015, 20:18:17
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="main">
            <aside class="leftAside">
                <h2>Просмотр информации о номерах</h2>
                <p>Тут вся текущая информация о доступных на данный момент номерах номерах. 
                </p>
            </aside>
            <section>
               <a href="logout">Выйти</a>
               <a href="login">В кабинет</a>
               <c:forEach var="room" items="${rooms}">
                    <room>
                        <p>Тип номера:                         ${room.type}
                        </p>  
                        <p>Номер комнаты:                      ${room.number}
                        </p>
                        <p>Количество мест:                    ${room.seats}
                        </p>
                     ---------------------------------------------
                    </room>
                </c:forEach>
            </section>
        </div>
