<%-- 
    Document   : a_delete_bill
    Created on : 22.11.2015, 14:01:03
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="main">
            <aside class="leftAside">
                <h2>Удаление счета</h2>
                <p>Чтобы удалить счет пользователя введите логин этого пользователя.
                </p>
            </aside>
            <section>
                <message>
                    <h1>Удаление</h1>
                    <div class="text-messages">
                        <c:if test="${notif ne null}">
                             <div class="notif">
                                 <span>${notif}</span> 
                             </div>
                        </c:if>
                        <form method="POST" action="a_delete_bill">
                            <p>
                            <label for="uslogin1">Логин</label>
                            <input type="text" name="uslogin1" id="login"/>
                        </p>
                        <p>
                            <button type="submit">Удалить</button>
                        </p>
                        </form>
                    </div>
                </message>
            </section>
        </div>
