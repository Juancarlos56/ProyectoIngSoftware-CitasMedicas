package ec.edu.ups.jpa;

import ec.edu.ups.DAO.EspecialidadDAO;
import ec.edu.ups.entidades.Especialidad;

public class JPAEspecialidadDAO extends JPAGenericDAO<Especialidad, Integer> implements EspecialidadDAO{

	public JPAEspecialidadDAO() {
		super(Especialidad.class);
		
	}

}
