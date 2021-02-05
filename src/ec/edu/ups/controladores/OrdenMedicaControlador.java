package ec.edu.ups.controladores;

import java.util.Date;

import ec.edu.ups.entidades.OrdenMedica;
import ec.edu.ups.entidades.Paciente;

public class OrdenMedicaControlador {
	public String nuevaOrdenMedica(String descripcion, String diagnostico, Date fechaOrdenMedica,	Paciente ordenesMedicasDeUnaConsulta) {
		OrdenMedica orden = new OrdenMedica(descripcion, diagnostico, fechaOrdenMedica, ordenesMedicasDeUnaConsulta);
		return "Ingresado";
	}
}
