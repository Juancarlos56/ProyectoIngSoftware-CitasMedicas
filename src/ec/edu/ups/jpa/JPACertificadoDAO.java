package ec.edu.ups.jpa;

import ec.edu.ups.DAO.CertificadoDAO;
import ec.edu.ups.entidades.Certificado;

public class JPACertificadoDAO extends JPAGenericDAO<Certificado, Integer> implements CertificadoDAO{

	public JPACertificadoDAO() {
		super(Certificado.class);
		// TODO Auto-generated constructor stub
	}

}
