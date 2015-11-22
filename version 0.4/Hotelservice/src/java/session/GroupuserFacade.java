/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Groupuser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 1
 */
@Stateless
public class GroupuserFacade extends AbstractFacade<Groupuser> {

    @PersistenceContext(unitName = "HotelservicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupuserFacade() {
        super(Groupuser.class);
    }
    
}
