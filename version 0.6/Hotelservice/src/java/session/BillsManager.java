/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Bills;
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
public class BillsManager {
        @PersistenceContext(unitName = "HotelservicePU")
        private EntityManager em2;
        
        @Resource
        private SessionContext context2;
        
        @TransactionAttribute(TransactionAttributeType.REQUIRED)
        public Integer addBill(final String usLogin, final String name, final String surname, 
                final String phone,final String roomtype, final String number, final String startdate,final String count, final String info ) {
        try{
                List resultList = em2.createNamedQuery("Users.findByLogin").setParameter("login", usLogin).getResultList();
                if (resultList.size()==0){
           Bills bill=newBill(usLogin, name,
                          surname, phone, roomtype, number, startdate, count, info);               
                return 0;
                } else {return 2;}
        }catch (Exception e){
            context2.setRollbackOnly();
            e.printStackTrace();
            return 1;
        }
    }

    private Bills newBill(String Login, String name,
                          String surname, String phone, String roomtype, String number, String startdate, String count, String info) {
       Bills bill=new Bills(Login, name,
                          surname, phone, roomtype, number, startdate, count, info);
        em2.persist(bill);
        return bill;
    }
    
        public Integer deleteBill (String login){
    try{
         List resultList = em2.createNamedQuery("Users.findByLogin").setParameter("login", login).getResultList();
                if (resultList.size()!=0){
            Bills b = em2.find(Bills.class, login);
            em2.remove (b);
            return 0;}
                else {return 2;}
    }catch(Exception e){
            context2.setRollbackOnly();
            e.printStackTrace();
            return 1;
        }
}
        
        public Integer redactBill (String usLogin, String name, String surname, 
                String phone,String roomtype, String number, String startdate,
                 String count, String info){
            try{
            Bills b = em2.find(Bills.class, usLogin);            
             b.setUsersLogin(usLogin);              
             b.setName(name);             
             b.setSurname(surname);             
             b.setPhone(phone);              
             b.setRoomtype(roomtype);              
             b.setNumber(number);              
             b.setStartdate(startdate);                
             b.setCount(count);               
             b.setInfo(info);
            em2.merge(b);
            return 0;
            }catch(Exception e){
            context2.setRollbackOnly();
            e.printStackTrace();
            return 1;
        }        
        }
        
        public Bills personalBill (String login){
            Bills b = em2.find(Bills.class, login);
            return (b);
        }
}
