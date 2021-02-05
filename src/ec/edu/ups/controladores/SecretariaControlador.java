package ec.edu.ups.controladores;

import java.util.Calendar;

import ec.edu.ups.entidades.Secretaria;

public class SecretariaControlador {
	public void nuevaSecretaria(String cedula, String nombre, String apellido, String lugarNacimiento,
			Calendar fechaDeNacimiento, String nacionalidad, String sexo, String email, String tipoUsuario,
			String estado,String user,String password) {
		Secretaria secretaria = new Secretaria(cedula, nombre, apellido, lugarNacimiento, fechaDeNacimiento, nacionalidad, sexo, email, tipoUsuario, estado, user, password);
	}
}
