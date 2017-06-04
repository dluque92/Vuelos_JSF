/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.FlightFacade;
import entity.Flight;
import entity.FlightPK;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "vuelosModificarBean")
@RequestScoped
public class VuelosModificarBean {

    @EJB
    private FlightFacade flightFacade;

    @Inject
    VuelosBean session;
    
    private List<Flight> listaVuelos;
    private List<String> listISOCode;
    private Flight vueloActual;
    private FlightPK flightPK;

    public FlightPK getFlightPK() {
        return flightPK;
    }

    public void setFlightPK(FlightPK flightPK) {
        this.flightPK = flightPK;
    }
    
    public List<Flight> getListaVuelos() {
        return listaVuelos;
    }

    public Flight getVueloActual() {
        return vueloActual;
    }
 
    public VuelosModificarBean() {
    }
    
    @PostConstruct
    public void init(){
        this.vueloActual = this.session.getVueloActual();
        this.listaVuelos = this.session.getListaVuelos();
        this.listISOCode = this.session.getListCountryISOSelected();
        this.flightPK = this.session.getFlightPK();
    }
    
    public String modificarVuelo(Flight vuelo){
        this.session.setEsEditar(Boolean.TRUE);
        this.session.setVueloActual(vuelo);
        return "newVuelo";
    }
    
    public String guardarVuelo(){
        if(flightFacade.find(this.vueloActual.getFlightPK()) == null){
            this.vueloActual.setFlightPK(this.flightPK);
            flightFacade.create(this.vueloActual);
        }else{
            flightFacade.edit(this.vueloActual);
            this.session.setEsEditar(Boolean.FALSE);
        }
        this.session.setListaVuelos(flightFacade.buscarPorCiudad(this.listISOCode));
        return "listarVuelos";
    }
    
}
