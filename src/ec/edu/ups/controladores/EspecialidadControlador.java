package ec.edu.ups.controladores;

import ec.edu.ups.entidades.Especialidad;

public class EspecialidadControlador {
	public String nuevaEspecialidad(String nombre) {
		Especialidad especialidad = new Especialidad(nombre);
		return "Ingresado";
	}
}
