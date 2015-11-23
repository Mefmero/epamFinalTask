<%-- 
    Document   : a_messages
    Created on : 19.11.2015, 20:17:47
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="main">
            <aside class="leftAside">
                <h2>Просмотр заявок</h2>
                <p>Тут приведены все доступные заявки. 
                </p>
            </aside>
            <section>
                <c:forEach var="message" items="${messages}">
                    <message>
                        <p>Логин:                    ${message.usersLogin}
                        </p>  
                        <p>Имя:                      ${message.name}
                        </p>
                        <p>Фамилия:                  ${message.surname}
                        </p>
                        <p>Телефон:                  ${message.phone}
                        </p>
                        <p>Тип номера:               ${message.roomtype}
                        </p>
                        <p>Количество мест в номере: ${message.seats}
                        </p>
                        <p>Дата заселения:           ${message.startdate}
                        </p>
                     ---------------------------------------------
                    </message>
                </c:forEach>
            </section>
        </div>
