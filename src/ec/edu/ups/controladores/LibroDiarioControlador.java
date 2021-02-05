package ec.edu.ups.controladores;

import java.util.GregorianCalendar;

import ec.edu.ups.entidades.CajaDiaria;
import ec.edu.ups.entidades.LibroDiario;
import ec.edu.ups.entidades.Secretaria;

public class LibroDiarioControlador {

	public String nuevoLibro(Secretaria secretaria,CajaDiaria caja) {
		LibroDiario nuevoLibro=new LibroDiario(0, new GregorianCalendar(), caja, secretaria);
		return "Ingresado";
	}

}
