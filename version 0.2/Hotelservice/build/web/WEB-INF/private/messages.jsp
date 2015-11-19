<%-- 
    Document   : messages
    Created on : 19.11.2015, 18:20:25
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div id="main">
            <aside class="leftAside">
                <h2>Что для заполнения заявки</h2>
                <p>Что бы заявка была зарегестрирована успешно, заполните все поля и нажмите на
                кнопку "Отправить".
                </p>
            </aside>
            <section>
                <a href="logout">Выйти</a>
                <room>
                    <h1>Заявка на бронирование номера</h1>
                    <div class="text-article">
                        <c:if test="${notif ne null}">
                             <div class="notif">
                                 <span>${notif}</span> 
                             </div>
                        </c:if>
                        <form method="POST" action="registration">
                        <p>
                            <label for="login">Логин</label>
                            <input type="text" name="login" id="login"/>
                        </p>
                        <p>
                        <label for="name">Имя</label>
                        <input type="name" name="name" id="name"/>
                        </p>
                        <p>
                        <label for="surname">Фамилия</label>
                        <input type="surname" name="surname" id="surname"/>
                        </p>
                        <p>
                        <label for="phone">Сотовый телефон</label>
                        <input type="phone" name="phone" id="phone"/>
                        </p>
                        <p>
                        <label for="roomtype">Тип номера</label>
                        <input type="roomtype" name="roomtype" id="roomtype"/>
                        </p>
                        <p>
                        <label for="seats">Число мест</label>
                        <input type="seats" name="seats" id="seats"/>
                        </p>
                        <p>
                        <label for="startdate">Дата заселения</label>
                        <input type="startdate" name="startdate" id="startdate"/>
                        </p>
                        <p>
                            <button type="submit">Отправить</button>
                        </p>
                        </form>
                    </div>
                </room>
            </section>
        </div>
