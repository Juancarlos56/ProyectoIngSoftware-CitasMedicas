package ec.edu.ups.jpa;

import ec.edu.ups.DAO.ActivoDAO;
import ec.edu.ups.entidades.Activo;

public class JPAActivoDAO extends JPAGenericDAO<Activo, Integer> implements  ActivoDAO{

	public JPAActivoDAO() {
		super(Activo.class);
		
	}

}
