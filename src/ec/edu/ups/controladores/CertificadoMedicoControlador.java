package ec.edu.ups.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ec.edu.ups.entidades.Certificado;
import ec.edu.ups.entidades.Consulta;

public class CertificadoMedicoControlador {

	public String nuevoCertificadoMedico(GregorianCalendar fechaEnvioDeCerficado, int numeroDiasDeReposoParaPaciente,
			String descripcionParaCertificado, Consulta certificadoDeUnaConsulta) {
		Certificado certificado= new Certificado(fechaEnvioDeCerficado, numeroDiasDeReposoParaPaciente, descripcionParaCertificado, certificadoDeUnaConsulta);
		return "Ingresado";
	}
}
