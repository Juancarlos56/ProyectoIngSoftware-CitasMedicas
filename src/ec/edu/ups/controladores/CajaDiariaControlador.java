package ec.edu.ups.controladores;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ec.edu.ups.entidades.CajaDiaria;

public class CajaDiariaControlador {
	public void cajaControlador(int totalDineroSalarioCajaDiaria, int totalDineroActivoCajaDiaria, int totalDineroDeudaCajaDiaria,
			int totalDineroPatrimonioCajaDiaria, Calendar fechaCajaDiaria) {
		CajaDiaria caja = new CajaDiaria(totalDineroSalarioCajaDiaria, totalDineroActivoCajaDiaria, totalDineroDeudaCajaDiaria, totalDineroPatrimonioCajaDiaria, fechaCajaDiaria);
	}
}
