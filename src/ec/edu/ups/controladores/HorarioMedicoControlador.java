package ec.edu.ups.controladores;

import java.util.Calendar;

import ec.edu.ups.entidades.HorarioMedico;
import ec.edu.ups.entidades.Medico;

public class HorarioMedicoControlador {
	public void nuevoHorario(Calendar diaHorarioMedico, Calendar horaInicioHorarioMedico, Calendar horaFinHorarioMedico,
			String estadoHorarioMedico, Medico horarioDisponiblePorMedico) {
		HorarioMedico horario = new HorarioMedico(diaHorarioMedico, horaInicioHorarioMedico, horaFinHorarioMedico, estadoHorarioMedico, horarioDisponiblePorMedico);
	}
}
