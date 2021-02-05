package ec.edu.ups.jpa;

import ec.edu.ups.DAO.FacturaCompraDAO;
import ec.edu.ups.entidades.FacturaCompra;

public class JPAFacturaCompraDAO extends JPAGenericDAO<FacturaCompra, Integer> implements FacturaCompraDAO{

	public JPAFacturaCompraDAO() {
		super(FacturaCompra.class);
	}

}
