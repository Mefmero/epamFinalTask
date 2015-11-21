/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import session.BillsManager;
import session.MessagesManager;

/**
 *
 * @author 1
 */
@WebServlet(name = "private_controller",loadOnStartup=1, urlPatterns = {"/login","/logout",
    "/a_messages","/a_bills","/a_rooms","/messages", "/bills"})
@ServletSecurity( @HttpConstraint(rolesAllowed = {"private", "admin"}) )
public class private_controller extends HttpServlet {
    @EJB
    MessagesManager messageManager;
    @EJB
    BillsManager billManager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if ("/login".equals(request.getServletPath())){
            request.setAttribute("name", request.getUserPrincipal().getName());
            if (request.isUserInRole("private")){
            request.getRequestDispatcher("WEB-INF/private/private_page.jsp").forward(request, response);
            } 
            if (request.isUserInRole("admin")){
            request.getRequestDispatcher("WEB-INF/private/a_private_page.jsp").forward(request, response);
            }
        }else if ("/a_messages".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){
              request.getRequestDispatcher("WEB-INF/private/a_messages.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            } }else
          if ("/a_bills".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){
              request.getRequestDispatcher("WEB-INF/private/a_bills.jsp").forward(request, response);
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
                    out.println (login+" "+ name+" "+
                          surname+" "+ phone+" "+ roomtype+" "+ number+" "+ startdate+" "+ count+" "+ info);
            Integer codeOperation1=billManager.addBill(login, name,
                          surname, phone, roomtype, number, startdate, count, info);
            if (codeOperation1!=0)
            {request.setAttribute("notif", "Код завершения операции: "+codeOperation1);}
            else
            {request.setAttribute("notif", "Заявка успешно создана создана!");}            
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }else
          if ("/a_rooms".equals(request.getServletPath())){
            if (request.isUserInRole("admin")){
              request.getRequestDispatcher("WEB-INF/private/a_rooms.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }else   
            if ("/messages".equals(request.getServletPath())){
            if (request.isUserInRole("private")){
                request.getRequestDispatcher("WEB-INF/private/messages.jsp").forward(request, response);
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
            {request.setAttribute("notif", "Код завершения операции: "+codeOperation);}
            else
            {request.setAttribute("notif", "Заявка успешно создана создана!");}
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
            
         }else
          if ("/bills".equals(request.getServletPath())){
            if (request.isUserInRole("private")){
              request.getRequestDispatcher("WEB-INF/private/bills.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("WEB-INF/private/doc_error.jsp").forward(request, response);
            }
         }
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
