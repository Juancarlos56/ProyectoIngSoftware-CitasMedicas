package ec.edu.ups.CargaBaseDatos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ec.edu.ups.DAO.AgendaCitaMedicaDAO;
import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.EspecialidadDAO;
import ec.edu.ups.DAO.MedicoDAO;
import ec.edu.ups.DAO.OrdenMedicaDAO;
import ec.edu.ups.DAO.PacienteDAO;
import ec.edu.ups.DAO.PersonaDAO;
import ec.edu.ups.DAO.SecretariaDAO;
import ec.edu.ups.entidades.AgendaCitaMedica;
import ec.edu.ups.entidades.Especialidad;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.OrdenMedica;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Secretaria;

public class CreacionTablas {

	public static void main(String[] args) {
		
		Calendar fecha2 = Calendar.getInstance();
		fecha2.set(1965,1,7);
		//Persona p = new Persona("0106113302", "Homero", "Sarmiento", "Paute", fecha2, "Ecuatoriana", "Masculino", "homeroSarmiento@gmail.com", "Medico", "Activo");
		//PersonaDAO personaInterface = DAOFactory.getFactory().getPersonaDAO();		
		//personaInterface.create(p);
		
		
		MedicoDAO medicoInterface = DAOFactory.getFactory().getMedicoDAO();
		
		Medico medico = new Medico("0106113302", "Homero", "Sarmiento", "Paute", fecha2, "Ecuatoriana", "Masculino", "homeroSarmiento@gmail.com", "Medico", "Activo", "homeroSarmiento", "1234", "colocarURL");
		//System.out.println(medico.toString());
		medicoInterface.create(medico);
		
		fecha2.set(1998,7,20);
		PacienteDAO pacDAO = DAOFactory.getFactory().getPacienteDAO();
		Paciente paciente = new Paciente("0106113301", "Juan", "Barrera", "Paute", fecha2, "Ecuatoriana", "Masculino", "barrerajuan930@gmail.com", "Cliente", "Activo", "O+");
		pacDAO.create(paciente);
		
		SecretariaDAO secDAO = DAOFactory.getFactory().getSecretariaDAO();
		Secretaria secretaria = new Secretaria("0102286440", "Maria", "Alvarez", "Azogues", new GregorianCalendar(), "Ecuatoriana", "Femenino", "Malvarez@hotmail.com", "Secretaria", "Activo", "sec1", "clave1");
		secDAO.create(secretaria);
		
		AgendaCitaMedicaDAO agDAO = DAOFactory.getFactory().getAgendaCitaMedicaDAO();
		AgendaCitaMedica ag = new AgendaCitaMedica(Calendar.getInstance(), Calendar.getInstance(), "Consulta", "Sin Pagar", (float)20.0);
		ag.setMedico(medico);
		ag.setPacienteCitaMedica(paciente);
		ag.setSecretaria(secretaria);
		agDAO.create(ag);
		
	}
}
