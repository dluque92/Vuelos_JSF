/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.City;
import entity.Flight;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author david
 */
@Stateless
public class FlightFacade extends AbstractFacade<Flight> {

    @PersistenceContext(unitName = "JSf_Vuelos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlightFacade() {
        super(Flight.class);
    }
    
    public List<Flight> buscarPorCiudad(List<String> listCity){
        List<Flight> vuelos;
        Query q;
        q = this.em.createQuery("SELECT f FROM Flight f WHERE f.origAirport.countryIsoCode in :listCity");
        q.setParameter("listCity", listCity);
        vuelos = q.getResultList();
        return vuelos;
    }
    
}
