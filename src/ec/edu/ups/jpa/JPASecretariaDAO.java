package ec.edu.ups.jpa;

import ec.edu.ups.DAO.SecretariaDAO;
import ec.edu.ups.entidades.Secretaria;

public class JPASecretariaDAO extends JPAGenericDAO<Secretaria, Integer> implements SecretariaDAO{

	public JPASecretariaDAO() {
		super(Secretaria.class);
		// TODO Auto-generated constructor stub
	}

}
