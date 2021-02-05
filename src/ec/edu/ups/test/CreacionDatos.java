package ec.edu.ups.test;

import java.io.Serializable;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CreacionDatos implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@EJB
	private ClienteFacade ejbCliente;
	@EJB
	private ReservaFacade ejbReserva;
	@EJB
	private RestauranteFacade ejbRestaurante;
	
	public CreacionDatos() {
		
	}

	public void creacionPrincipal() {
		
	}
	
	
	
}
