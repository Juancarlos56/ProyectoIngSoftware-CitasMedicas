package ec.edu.ups.jpa;

import ec.edu.ups.DAO.FacturaSalarioDAO;
import ec.edu.ups.entidades.FacturaSalario;

public class JPAFacturaSalario extends JPAGenericDAO<FacturaSalario, Integer> implements FacturaSalarioDAO{

	public JPAFacturaSalario() {
		super(FacturaSalario.class);
		
	}

}
