package ec.edu.ups.jpa;

import ec.edu.ups.DAO.PasivoDAO;
import ec.edu.ups.entidades.Pasivo;

public class JPAPasivoDAO extends JPAGenericDAO<Pasivo, Integer> implements PasivoDAO{

	public JPAPasivoDAO() {
		super(Pasivo.class);
		// TODO Auto-generated constructor stub
	}

}
