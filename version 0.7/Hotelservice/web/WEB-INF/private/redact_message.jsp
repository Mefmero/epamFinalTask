<%-- 
    Document   : redact_message
    Created on : 22.11.2015, 16:21:04
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div id="main">
            <aside class="leftAside">
                <h2>Редактирование заявки</h2>
                <p>Перепишите все поля, изменяя необходимые.
                </p>
            </aside>
            <section>
                <message>
                    <h1>Заявка на бронирование номера</h1>
                    <div class="text-messages">
                        <c:if test="${notif ne null}">
                             <div class="notif">
                                 <span>${notif}</span> 
                             </div>
                        </c:if>
                        <form method="POST" action="redact_message">
                            <p>
                            <label for="login">Логин</label>
                            <input type="text" name="login" id="login"/>
                        </p>
                        <p>
                        <label for="name">Имя</label>
                        <input type="text" name="name" id="name"/>
                        </p>
                        <p>
                        <label for="surname">Фамилия</label>
                        <input type="text" name="surname" id="surname"/>
                        </p>
                        <p>
                        <label for="phone">Сотовый телефон</label>
                        <input type="text" name="phone" id="phone"/>
                        </p>
                        <p>
                        <label for="roomtype">Тип номера</label>
                        <input type="text" name="roomtype" id="roomtype"/>
                        </p>
                        <p>
                        <label for="seats">Число мест</label>
                        <input type="text" name="seats" id="seats"/>
                        </p>
                        <p>
                        <label for="startdate">Дата заселения</label>
                        <input type="text" name="startdate" id="startdate"/>
                        </p>
                        <p>
                            <button type="submit">изменить</button>
                        </p>
                        </form>
                    </div>
                </message>
            </section>
        </div>