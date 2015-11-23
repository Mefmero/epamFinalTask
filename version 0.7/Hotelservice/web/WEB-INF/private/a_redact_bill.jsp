<%-- 
    Document   : a_redact_bill
    Created on : 22.11.2015, 14:18:13
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="main">
            <aside class="leftAside">
                <h2>Редактирование счета</h2>
                <p>Будьте внимательны при вводе даннх клиента, чтобы избежать ошибок при заселении. 
                    Перепишите все поля, изменяя необходимые.
                </p>
            </aside>
            <section>
                <room>
                    <h1>Счет</h1>
                    <div class="text-article">
                        <c:if test="${notif ne null}">
                             <div class="notif">
                                 <span>${notif}</span> 
                             </div>
                        </c:if>
                        <form method="POST" action="a_redact_bill">
                        <p>
                            <label for="login">Логин клиента</label>
                            <input type="text" name="login" id="login"/>
                        </p>
                        <p>
                        <label for="name">Имя клиента</label>
                        <input type="text" name="name" id="name"/>
                        </p>
                        <p>
                        <label for="surname">Фамилия клиента</label>
                        <input type="text" name="surname" id="surname"/>
                        </p>
                        <p>
                        <label for="phone">Сотовый телефон клиента</label>
                        <input type="text" name="phone" id="phone"/>
                        </p>
                        <p>
                        <label for="roomtype">Тип номера</label>
                        <input type="text" name="roomtype" id="roomtype"/>
                        </p>
                        <p>
                        <label for="number">Номер комнаты</label>
                        <input type="text" name="number" id="number"/>
                        </p>
                        <p>
                        <label for="startdate">Дата заселения</label>
                        <input type="text" name="startdate" id="startdate"/>
                        </p>
                        <p>
                        <label for="count">Сумма к оплате</label>
                        <input type="text" name="count" id="count"/>
                        </p>
                        <p>
                        <label for="info">Дополнительная информация</label>
                        <input type="text" name="info" id="info"/>
                        </p>
                        <p>
                            <button type="submit">Изменить</button>
                        </p>
                        </form>
                    </div>
                </room>
            </section>
        </div>
