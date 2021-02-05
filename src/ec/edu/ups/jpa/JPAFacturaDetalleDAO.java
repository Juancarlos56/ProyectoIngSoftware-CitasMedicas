package ec.edu.ups.jpa;

import ec.edu.ups.DAO.FacturaDetalleDAO;
import ec.edu.ups.entidades.FacturaDetalle;

public class JPAFacturaDetalleDAO extends JPAGenericDAO<FacturaDetalle, Integer> implements FacturaDetalleDAO{

	public JPAFacturaDetalleDAO() {
		super(FacturaDetalle.class);
		// TODO Auto-generated constructor stub
	}

	
}
