/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Hotelrooms;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 1
 */
@Stateless
public class HotelroomsFacade extends AbstractFacade<Hotelrooms> {

    @PersistenceContext(unitName = "HotelservicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HotelroomsFacade() {
        super(Hotelrooms.class);
    }
    
}
