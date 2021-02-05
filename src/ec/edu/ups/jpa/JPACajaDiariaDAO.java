package ec.edu.ups.jpa;

import ec.edu.ups.DAO.CajaDiariaDAO;
import ec.edu.ups.entidades.CajaDiaria;

public class JPACajaDiariaDAO extends JPAGenericDAO<CajaDiaria, Integer> implements CajaDiariaDAO{

	public JPACajaDiariaDAO() {
		super(CajaDiaria.class);
		// TODO Auto-generated constructor stub
	}

}
