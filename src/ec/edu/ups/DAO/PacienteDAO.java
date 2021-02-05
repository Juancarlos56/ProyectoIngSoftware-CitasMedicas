package ec.edu.ups.DAO;

import java.util.List;

import ec.edu.ups.entidades.Paciente;

public interface PacienteDAO extends GenericDAO<Paciente, Integer>{

	public abstract List<Paciente> encontrarPacientePorNombre(String nombre);
	public abstract Paciente encontrarPacientePorCedula(String cedula);
}
