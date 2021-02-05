package ec.edu.ups.controladores;

import java.util.GregorianCalendar;

import ec.edu.ups.entidades.Paciente;

public class PacienteControlador {
	public String nuevoPaciente(String tipo,String cedula,String nombre, String apellido, String lugarN, GregorianCalendar fechaN, String nacionalidad, String sexo, String email, String tipoUsuario,
			String estado, int idPaciente, String tipoSangre) {
		Paciente paciente = new Paciente(cedula, nombre, apellido, lugarN, fechaN, nacionalidad, sexo, email, tipoUsuario, estado, idPaciente, tipoSangre);
		return "Ingresado";
	}
}
