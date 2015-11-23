/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bills;
import entity.Messages;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BillsFacade;
import session.BillsManager;
import session.HotelroomsFacade;
import session.MessagesFacade;
import session.MessagesManager;

/**
 *
 * @author 1
 */
@WebServlet(name = "private_controller",loadOnStartup=1, urlPatterns = {"/login","/logout",
    "/a_messages","/a_bills","/a_rooms","/messages", "/bill", "/a_watch_bill","/a_delete_message",
"/a_delete_bill","/a_redact_bill", "/redact_message", "/delete_message","/watch_message",
"/doc_error.jsp"})
@ServletSecurity( @HttpConstraint(rolesAllowed = {"private", "admin"}) )
public class private_controller extends HttpServlet {
    String usersLogin = null;
    
    @EJB
    MessagesManager messageManager;
    @EJB
    BillsManager billManager; 
    @EJB
    BillsFacade billsFacade;
    @EJB
    MessagesFacade messagesFacade;
    @EJB
    HotelroomsFacade hotelroomsFacade;
    
    @Override
    public void init() throws ServletException {
                  getServletContext().setAttribute("bills", billsFacade.findAll());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if ("/login".equals(request.getServletPath())){
            request.setAttribute("name", request.getUserPrincipal().getName());
            usersLogin=request.getUserPrincipal().getName();
            if (request.isUserInRole("private")){
            request.getRequestDispatcher("WEB-INF/private/private_page.jsp").forward(request, response);
            } 
            if (request.isUserInRole("admin")){
            request.getRequestDispatcher("WEB-INF/private/a_private_page.jsp").forward(request, response);
            }
        }else if ("/a_messages".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){
              request.getRequestDispatcher("WEB-INF/private/a_messages.jsp").forward(request, response);
              getServletContext().setAttribute("messages", messagesFacade.findAll());     
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            } }else if ("/a_delete_message".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){
              String uslogin=null;
              uslogin=request.getParameter("uslogin");
              Integer codeOperation1=messageManager.deleteMessage(uslogin);
              if (codeOperation1!=0){
                  if (codeOperation1==1)
            {request.setAttribute("notif", "Ошибка! Вы не указали логин пользователя.");}
                  else if (codeOperation1==2)
                   {request.setAttribute("notif", "Ошибка! Пользователя с таким логином не существует.");}   
              }
            else
            {request.setAttribute("notif", "Заявка успешно удалена!");}
              request.getRequestDispatcher("WEB-INF/private/a_delete_message.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            } }else if ("/a_delete_bill".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){ 
              String uslogin=null;
              uslogin=request.getParameter("uslogin1");
              Integer codeOperation1=billManager.deleteBill(uslogin);
              if (codeOperation1!=0){
                  if (codeOperation1==1)
            {request.setAttribute("notif", "Ошибка! Вы не указали логин пользователя.");}
                  else if (codeOperation1==2)
                   {request.setAttribute("notif", "Ошибка! Пользователя с таким логином не существует.");}   
              }
            else
            {request.setAttribute("notif", "Счет успешно удален!");}
               request.getRequestDispatcher("WEB-INF/private/a_delete_bill.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            } }else 
            if ("/a_watch_bill".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){
              request.getRequestDispatcher("WEB-INF/private/a_watch_bill.jsp").forward(request, response);
              getServletContext().setAttribute("bills", billsFacade.findAll());
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            } }else
          if ("/a_bills".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){
              String login=null,name=null,surname=null, phone=null, roomtype=null,
                    number=null, startdate=null, count = null, info = null ;
                    login=request.getParameter("login");
                    name=request.getParameter("name");
                    surname=request.getParameter("surname");
                    phone=request.getParameter("phone");
                    roomtype=request.getParameter("roomtype");
                    number=request.getParameter("number");
                    startdate=request.getParameter("startdate");
                    count=request.getParameter("count");
                    info=request.getParameter("info");
            Integer codeOperation1=billManager.addBill(login, name,
                          surname, phone, roomtype, number, startdate, count, info);
            if (codeOperation1!=0){
                if (codeOperation1==1)
            {request.setAttribute("notif", "Вы оставили пустые поля ");}
                else if (codeOperation1==2)
                {request.setAttribute("notif", "Счет на пользователя с таким логином уже существует.");}
            }
            else
            {request.setAttribute("notif", "Счет успешно создан!");} 
            request.getRequestDispatcher("WEB-INF/private/a_bills.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }else
          if ("/a_rooms".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){
              request.getRequestDispatcher("WEB-INF/private/a_rooms.jsp").forward(request, response);
               getServletContext().setAttribute("rooms", hotelroomsFacade.findAll());
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }else   if ("/a_redact_bill".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){   
                    String login=null,name=null,surname=null, phone=null, roomtype=null,
                    number=null, startdate=null, count = null, info = null ;
                    login=request.getParameter("login");
                    name=request.getParameter("name");
                    surname=request.getParameter("surname");
                    phone=request.getParameter("phone");
                    roomtype=request.getParameter("roomtype");
                    number=request.getParameter("number");
                    startdate=request.getParameter("startdate");
                    count=request.getParameter("count");
                    info=request.getParameter("info");
                Integer codeOperation1=billManager.redactBill(login, name,
                          surname, phone, roomtype, number, startdate, count, info);
            if (codeOperation1!=0)
            {request.setAttribute("notif", "Пользователь с таким логином не существует");}
            else
            {request.setAttribute("notif", "Заявка успешно отредактирована!");}
            request.getRequestDispatcher("WEB-INF/private/a_redact_bill.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }else 
            if ("/messages".equals(request.getServletPath())){
            if (request.isUserInRole("private")){    
            String login=null,name=null,surname=null, phone=null, roomtype=null,
                    seats=null, startdate=null ;
                    login=request.getParameter("login");
                    name=request.getParameter("name");
                    surname=request.getParameter("surname");
                    phone=request.getParameter("phone");
                    roomtype=request.getParameter("roomtype");
                    seats=request.getParameter("seats");
                    startdate=request.getParameter("startdate");
            Integer codeOperation=messageManager.addMessage(login, name,
                          surname, phone, roomtype, seats, startdate);
            if (codeOperation!=0)
            {  if (codeOperation==1)
            {request.setAttribute("notif", "Вы оставили пустые поля ");}
                else if (codeOperation==2)
                {request.setAttribute("notif", "Заявка на пользователя с таким логином уже существует.");};
            }
            else
            {request.setAttribute("notif", "Заявка успешно создана создана!");}
            request.getRequestDispatcher("WEB-INF/private/messages.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
            
         }else
          if ("/bill".equals(request.getServletPath())){
            if (request.isUserInRole("private")){
              Bills bill = billManager.personalBill(usersLogin);
              request.setAttribute("bill",bill);
              request.getRequestDispatcher("WEB-INF/private/bill.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }else
          if ("/watch_message".equals(request.getServletPath())){
            if (request.isUserInRole("private")){
              Messages message = messageManager.personalMessage(usersLogin);
              request.setAttribute("message",message);
              request.getRequestDispatcher("WEB-INF/private/watch_message.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }else
          if ("/redact_message".equals(request.getServletPath())){
            if (request.isUserInRole("private")){
              String login=null,name=null,surname=null, phone=null, roomtype=null,
                    seats=null, startdate=null ;
                    login=request.getParameter("login");
                    name=request.getParameter("name");
                    surname=request.getParameter("surname");
                    phone=request.getParameter("phone");
                    roomtype=request.getParameter("roomtype");
                    seats=request.getParameter("seats");
                    startdate=request.getParameter("startdate");
            Integer codeOperation=messageManager.redactMessage(login, name,
                          surname, phone, roomtype, seats, startdate);
            if (codeOperation!=0)
            {request.setAttribute("notif", "Ошибка вы оставили пустые поля");}
            else
            {request.setAttribute("notif", "Заявка успешно создана создана!");}
             request.getRequestDispatcher("WEB-INF/private/redact_message.jsp").forward(request, response); 
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }else if ("/delete_message".equals(request.getServletPath())){
            if (request.isUserInRole("private")){
              String uslogin=null;
              uslogin=request.getParameter("uslogin");
              Integer codeOperation1=messageManager.deleteMessage(uslogin);
              if (codeOperation1!=0)
            {if (codeOperation1==1)
            {request.setAttribute("notif", "Ошибка! Вы не указали логин пользователя.");}
                  else if (codeOperation1==2)
                   {request.setAttribute("notif", "Ошибка! Пользователя с таким логином не существует.");}}
            else
            {request.setAttribute("notif", "Заявка успешно создана создана!");}   
            request.getRequestDispatcher("WEB-INF/private/delete_message.jsp").forward(request, response);  
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            } }
        else
           if ("/logout".equals(request.getServletPath())){
            HttpSession session = request.getSession(false);
            if (session!= null){
                session.invalidate();
            }
            response.sendRedirect("/Hotelservice/");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
