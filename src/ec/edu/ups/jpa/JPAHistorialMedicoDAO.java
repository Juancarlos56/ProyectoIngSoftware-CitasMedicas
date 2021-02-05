package ec.edu.ups.jpa;

import ec.edu.ups.DAO.HistorialMedicoDAO;
import ec.edu.ups.entidades.HistorialMedico;

public class JPAHistorialMedicoDAO extends JPAGenericDAO<HistorialMedico, Integer> implements HistorialMedicoDAO{

	public JPAHistorialMedicoDAO() {
		super(HistorialMedico.class);
		// TODO Auto-generated constructor stub
	}

}
