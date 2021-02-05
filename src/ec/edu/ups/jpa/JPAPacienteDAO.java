package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.DAO.PacienteDAO;
import ec.edu.ups.entidades.Paciente;

public class JPAPacienteDAO extends JPAGenericDAO<Paciente, Integer> implements PacienteDAO{

	private String consulta;
	
	
	public JPAPacienteDAO() {
		super(Paciente.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> encontrarPacientePorNombre(String nombre) {
		List<Paciente> paciente =  new ArrayList<Paciente>();
		consulta ="Select p From Paciente p Where p.nombre like :nombre AND p.estado='Activo'";
		
		try {
			paciente = (List<Paciente>)em.createQuery(consulta).setParameter("nombre", nombre+"%").getResultList();
			System.out.println(paciente.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Revisar encontrarPacientePorNombre ERROR");
		}
		
		return paciente;
	}
	
	
	@SuppressWarnings("unchecked")
	public Paciente encontrarPacientePorCedula(String cedula) {
		Paciente paciente =  new Paciente();
		consulta ="Select p From Paciente p Where p.cedula like :cedula  AND p.estado='Activo'";
		
		try {
			em.clear();
			paciente = (Paciente)em.createQuery(consulta).setParameter("cedula", cedula).getSingleResult();
			System.out.println(paciente.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Revisar encontrarPacientePorCedula ERROR");
		}
		
		return paciente;
	}

}
