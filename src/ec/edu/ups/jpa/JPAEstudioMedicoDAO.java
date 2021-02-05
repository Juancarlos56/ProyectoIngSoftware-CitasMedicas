package ec.edu.ups.jpa;

import ec.edu.ups.DAO.EstudioMedicoDAO;
import ec.edu.ups.entidades.EstudioMedico;

public class JPAEstudioMedicoDAO extends JPAGenericDAO<EstudioMedico, Integer> implements EstudioMedicoDAO{

	public JPAEstudioMedicoDAO() {
		super(EstudioMedico.class);
	}

}
