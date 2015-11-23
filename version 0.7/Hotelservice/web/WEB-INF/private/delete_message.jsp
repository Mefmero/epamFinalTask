<%-- 
    Document   : delete_message
    Created on : 22.11.2015, 16:46:36
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="main">
            <aside class="leftAside">
                <h2>Удаление заявки</h2>
                <p>Введите свой логин,для удаления заявки.
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
                        <form method="POST" action="delete_message">
                            <p>
                            <label for="uslogin">Логин</label>
                            <input type="text" name="uslogin" id="login"/>
                        </p>
                        <p>
                            <button type="submit">Удалить</button>
                        </p>
                        </form>
                    </div>
                </message>
            </section>
        </div>

