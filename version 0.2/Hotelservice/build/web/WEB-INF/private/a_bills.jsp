<%-- 
    Document   : a_bills
    Created on : 19.11.2015, 20:17:57
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="main">
            <aside class="leftAside">
                <h2>Оформление счетая</h2>
                <p>Будьте внимательны при вводе даннх клиента, чтобы избежать ошибок при заселении.
                    Графа "дополнительная информация" заполняется только в случае отсутствия места для клиента.
                </p>
            </aside>
            <section>
                <a href="logout">Выйти</a>
                <room>
                    <h1>Счет</h1>
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
                        <label for="number">Номер комнаты</label>
                        <input type="number" name="number" id="number"/>
                        </p>
                        <p>
                        <label for="startdate">Дата заселения</label>
                        <input type="startdate" name="startdate" id="startdate"/>
                        </p>
                        <p>
                        <label for="count">Сумма к оплате</label>
                        <input type="count" name="count" id="count"/>
                        </p>
                        <p>
                        <label for="info">Дополнительная информация</label>
                        <input type="info" name="info" id="info"/>
                        </p>
                        <p>
                            <button type="submit">Оформить</button>
                        </p>
                        </form>
                    </div>
                </room>
            </section>
        </div>
