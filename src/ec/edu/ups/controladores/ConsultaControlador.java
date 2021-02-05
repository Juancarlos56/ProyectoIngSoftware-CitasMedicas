package ec.edu.ups.controladores;

import java.util.GregorianCalendar;

import ec.edu.ups.entidades.Certificado;
import ec.edu.ups.entidades.Consulta;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;

public class ConsultaControlador {
	public String nuevaConsulta(GregorianCalendar fechaActualDeLaConsulta, String sintomasDelPaciente,
			String diagnosticoDeLaConsulta, String observacionesDeLaConsulta, String medicinasParaElPaciente,
			String dosis, Paciente pacienteConsulta, Medico medicoConsulta) {
		Consulta consulta = new Consulta(fechaActualDeLaConsulta, sintomasDelPaciente, diagnosticoDeLaConsulta, observacionesDeLaConsulta, medicinasParaElPaciente, dosis, pacienteConsulta, medicoConsulta);
		return "Ingresado";
	}
}
