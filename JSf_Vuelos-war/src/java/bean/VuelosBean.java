/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.CityFacade;
import ejb.CountryFacade;
import ejb.FlightFacade;
import entity.City;
import entity.Country;
import entity.Flight;
import entity.FlightPK;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author david
 */
@Named(value = "vuelosBean")
@SessionScoped
public class VuelosBean implements Serializable {

    @EJB
    private FlightFacade flightFacade;

    @EJB
    private CityFacade cityFacade;

    @EJB
    private CountryFacade countryFacade;

    private List<Country> listCountry;
    private List<String> listCountryISOSelected;
    private List<City> listCity;
    private List<Flight> listaVuelos;
    private Flight vueloActual;
    private Boolean esEditar;
    private FlightPK flightPK;

    public FlightPK getFlightPK() {
        return flightPK;
    }

    public void setFlightPK(FlightPK flightPK) {
        this.flightPK = flightPK;
    }

    /**
     * Creates a new instance of VuelosBean
     */
    public VuelosBean() {
    }

    @PostConstruct
    public void init() {
        listCountry = countryFacade.findAll();
        this.listCity = cityFacade.findAll();
        this.esEditar = false;
    }

    public Flight getVueloActual() {
        return vueloActual;
    }

    public void setVueloActual(Flight vueloActual) {
        this.vueloActual = vueloActual;
    }

    public List<Country> getListCountry() {
        return listCountry;
    }

    public void setListCountry(List<Country> listCountry) {
        this.listCountry = listCountry;
    }

    public List<String> getListCountryISOSelected() {
        return listCountryISOSelected;
    }

    public void setListCountryISOSelected(List<String> listCountryISOSelected) {
        this.listCountryISOSelected = listCountryISOSelected;
    }

    public List<City> getListCity() {
        return listCity;
    }

    public void setListCity(List<City> listCity) {
        this.listCity = listCity;
    }

    public List<Flight> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(List<Flight> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public Boolean getEsEditar() {
        return esEditar;
    }

    public void setEsEditar(Boolean esEditar) {
        this.esEditar = esEditar;
    }

    public String buscarVuelos(List<String> listaSeleccionados) {
        this.listaVuelos = flightFacade.buscarPorCiudad(listaSeleccionados);
        return "listarVuelos";
    }

    public void iniciarVuelo() {
        this.vueloActual = new Flight();
        this.flightPK = new FlightPK("",0);
    }

    public String borrar(Flight vuelo) {
        flightFacade.remove(vuelo);
        listaVuelos.remove(vuelo);
        return "listarVuelos";
    }

    public String crearVuelo() {
        iniciarVuelo();
        return "newVuelo";
    }

}
