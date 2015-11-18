<%-- 
    Document   : index
    Created on : 14.11.2015, 17:35:59
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div id="main">
            <aside class="leftAside">
                <h2>Виды номеров</h2>
                <ul>
                    <li><a href="#">Люкс</a></li>
                    <li><a href="#">Сьют</a></li>
                    <li><a href="#">Стандартный</a></li>
                </ul>
            </aside>
            <section>          
                    <c:forEach var="room" items="${rooms}">
                        <room>
			<h1>${room.type}</h1>
                        <div class="text-room">
                        ${fn:substring(room.rdesc,0,297)} ...
                        </div>
                       <div class="fotter-room">
                        <span class="read"><a href="room?id=${room.id}">
                                     Читать...</a></span>
                        </div>
                        </room>
		    </c:forEach>
            </section>
        </div>