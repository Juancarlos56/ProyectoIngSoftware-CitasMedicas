package ec.edu.ups.jpa;

import ec.edu.ups.DAO.ConsultaDAO;
import ec.edu.ups.entidades.Consulta;

public class JPAConsultaDAO extends JPAGenericDAO<Consulta, Integer> implements ConsultaDAO{

	public JPAConsultaDAO() {
		super(Consulta.class);
		// TODO Auto-generated constructor stub
	}

}
