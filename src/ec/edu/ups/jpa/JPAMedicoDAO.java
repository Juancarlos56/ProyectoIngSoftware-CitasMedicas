package ec.edu.ups.jpa;

import ec.edu.ups.DAO.MedicoDAO;
import ec.edu.ups.entidades.Medico;

public class JPAMedicoDAO extends JPAGenericDAO<Medico, Integer> implements MedicoDAO{

	public JPAMedicoDAO() {
		super(Medico.class);
	}

}
