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
            </section>
        </div>