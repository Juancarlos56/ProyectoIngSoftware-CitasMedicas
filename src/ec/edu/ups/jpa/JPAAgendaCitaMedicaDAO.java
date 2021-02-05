package ec.edu.ups.jpa;

import ec.edu.ups.DAO.AgendaCitaMedicaDAO;
import ec.edu.ups.entidades.AgendaCitaMedica;

public class JPAAgendaCitaMedicaDAO extends JPAGenericDAO<AgendaCitaMedica, Integer> implements AgendaCitaMedicaDAO{

	public JPAAgendaCitaMedicaDAO() {
		super(AgendaCitaMedica.class);
	}

	
}
