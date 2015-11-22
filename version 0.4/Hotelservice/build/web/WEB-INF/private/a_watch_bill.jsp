<%-- 
    Document   : a_watch_bill
    Created on : 22.11.2015, 12:37:08
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="main">
            <aside class="leftAside">
                <h2>Просмотр счетов</h2>
                <p>Тут приведены все выписанные счета. 
                </p>
            </aside>
            <section>
               <a href="logout">Выйти</a>
               <a href="login">В кабинет</a>
                <c:forEach var="bill" items="${bills}">
                    <bill>                                          
                        <p>Логин:                    ${bill.usersLogin}
                        </p>  
                        <p>Имя:                      ${bill.name}
                        </p>
                        <p>Фамилия:                  ${bill.surname}
                        </p>
                        <p>Телефон:                  ${bill.phone}
                        </p>
                        <p>Тип номера:               ${bill.roomtype}
                        </p>
                        <p>Номер комнаты:            ${bill.number}
                        </p>
                        <p>Дата заселения:           ${bill.startdate}
                        </p>
                        <p>Сумма к оплате:           ${bill.count}
                        </p>
                        <p>Дополнительная информация: ${bill.info}
                        </p>
                     ---------------------------------------------
                    </bill>
                </c:forEach>
            </section>
        </div>
