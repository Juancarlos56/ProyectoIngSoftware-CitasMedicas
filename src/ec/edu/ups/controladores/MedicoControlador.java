package ec.edu.ups.controladores;

import java.util.Calendar;

import ec.edu.ups.entidades.Medico;

public class MedicoControlador {
	public void nuevoMedico(String cedula, String nombre, String apellido, String lugarNacimiento,
			Calendar fechaDeNacimiento, String nacionalidad, String sexo, String email, String tipoUsuario,
			String estado, String userMedico, String passwordMedico, String urlFotoMedico) {
		Medico medico = new Medico(cedula, nombre, apellido, lugarNacimiento, fechaDeNacimiento, nacionalidad, sexo, email, tipoUsuario, estado, userMedico, passwordMedico, urlFotoMedico);
	}
}
