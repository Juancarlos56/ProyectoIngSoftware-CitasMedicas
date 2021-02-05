package ec.edu.ups.jpa;

import ec.edu.ups.DAO.FacturaCabeceraDAO;
import ec.edu.ups.entidades.FacturaCabecera;

public class JPAFacturaCabeceraDAO extends JPAGenericDAO<FacturaCabecera, Integer> implements FacturaCabeceraDAO{

	public JPAFacturaCabeceraDAO() {
		super(FacturaCabecera.class);
		// TODO Auto-generated constructor stub
	}

}
