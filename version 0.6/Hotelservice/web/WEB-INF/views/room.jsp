<%-- 
    Document   : room
    Created on : 14.11.2015, 18:28:10
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div id="main">
            <aside class="leftAside">
                <h2>Темы статей</h2>
                <ul>
                    <li><a href="#">Тема 1</a></li>
                    <li><a href="#">Тема 2</a></li>
                    <li><a href="#">Тема 3</a></li>
                </ul>
            </aside>
            ${param.name}
            <section>
                <room>
                    <h1>${room.type}</h1>
                    <div class="text-room">
                        ${room.rdesc} 
                    </div>
              </room>
            </section>
        </div>