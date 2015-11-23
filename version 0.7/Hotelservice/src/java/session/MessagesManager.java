/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entity.Messages;
import static java.lang.System.out;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 1
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MessagesManager {
        @PersistenceContext(unitName = "HotelservicePU")
        private EntityManager em1;
        
        @Resource
        private SessionContext context1;
        
        @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer addMessage(final String usLogin, final String name, final String surname, final String phone,final String roomtype, final String seats, final String startdate) {
        try{
           List resultList = em1.createNamedQuery("Users.findByLogin").setParameter("login", usLogin).getResultList();
                if (resultList.size()==0){
               Messages message=newMessage(usLogin, name,
                          surname, phone, roomtype, seats, startdate);               
                return 0;
                }else {return 2;}
        }catch (Exception e){
            context1.setRollbackOnly();
            e.printStackTrace();
            return 1;
        }
    }

    private Messages newMessage(String Login, String name,
                          String surname, String phone, String roomtype, String seats, String startdate) {
       Messages message=new Messages(Login, name,
                          surname, phone, roomtype, seats, startdate);
        em1.persist(message);
        return message;
    }
    
    public Integer deleteMessage (String login){
    try{
         List resultList = em1.createNamedQuery("Users.findByLogin").setParameter("login", login).getResultList();
                if (resultList.size()!=0){
            Messages m = em1.find(Messages.class, login);
            em1.remove (m);
            return 0;}
                else {return 2;}
    }catch(Exception e){
            context1.setRollbackOnly();
            e.printStackTrace();
            return 1;
        }
}
    
      public Integer redactMessage(String usLogin, String name,String surname, 
              String phone,String roomtype,String seats,String startdate) {
                try{
                    out.println (usLogin+" "+ name+" "+
                         surname+" "+ phone+" "+ roomtype+" "+ seats+" "+ startdate+" ");
            Messages b = em1.find(Messages.class, usLogin);            
             b.setUsersLogin(usLogin);              
             b.setName(name);             
             b.setSurname(surname);             
             b.setPhone(phone);              
             b.setRoomtype(roomtype);              
             b.setSeats(seats);              
             b.setStartdate(startdate);                
            em1.merge(b);
            return 0;
            }catch(Exception e){
            context1.setRollbackOnly();
            e.printStackTrace();
            return 1;
        }
      }
      
      
    public Messages personalMessage (String login){
            Messages b = em1.find(Messages.class, login);
            return (b);
        }
}

