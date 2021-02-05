package ec.edu.ups.controladores;

import java.util.GregorianCalendar;

import ec.edu.ups.entidades.*;

public class AgendaCitaMedicaControlador {
	
	public String nuevaCita(Paciente paciente, Medico medico, GregorianCalendar fecha, String tipoCita, String estado, float precio,Secretaria secretaria ) {
		AgendaCitaMedica nuevaCita=new AgendaCitaMedica(new GregorianCalendar() , fecha, tipoCita, estado, precio, secretaria, medico, paciente, null);
		return "Ingresado";
	}	
	
}
