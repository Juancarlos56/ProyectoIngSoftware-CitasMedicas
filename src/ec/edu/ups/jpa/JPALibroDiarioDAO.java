package ec.edu.ups.jpa;

import ec.edu.ups.DAO.LibroDiarioDAO;
import ec.edu.ups.entidades.LibroDiario;

public class JPALibroDiarioDAO extends JPAGenericDAO<LibroDiario, Integer> implements LibroDiarioDAO{

	public JPALibroDiarioDAO() {
		super(LibroDiario.class);
		// TODO Auto-generated constructor stub
	}

}
