<%-- 
    Document   : room
    Created on : 14.11.2015, 18:28:10
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div id="main">
            <aside class="leftAside">
                <h2>Подробная инофрмация о номерах</h2>
               <p>Тут вы можете прочитать подробную информацию о каждом номере.
                </p>
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