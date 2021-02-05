package ec.edu.ups.jpa;

import ec.edu.ups.DAO.OrdenMedicaDAO;
import ec.edu.ups.entidades.OrdenMedica;

public class JPAOrdenMedicaDAO extends JPAGenericDAO<OrdenMedica, Integer> implements OrdenMedicaDAO{

	public JPAOrdenMedicaDAO() {
		super(OrdenMedica.class);
		
	}
	
}
