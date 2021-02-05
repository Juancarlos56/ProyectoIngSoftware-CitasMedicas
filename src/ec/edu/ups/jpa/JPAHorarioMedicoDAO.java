package ec.edu.ups.jpa;

import ec.edu.ups.DAO.HorarioMedicoDAO;
import ec.edu.ups.entidades.HorarioMedico;

public class JPAHorarioMedicoDAO extends JPAGenericDAO<HorarioMedico, Integer> implements HorarioMedicoDAO{

	public JPAHorarioMedicoDAO() {
		super(HorarioMedico.class);
		// TODO Auto-generated constructor stub
	}

}
