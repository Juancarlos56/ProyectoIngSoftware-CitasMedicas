package ec.edu.ups.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import ec.edu.ups.entidades.Especialidad;
import ec.edu.ups.entidades.EstudioMedico;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.controladores.MedicoControlador;
import ec.edu.ups.controladores.EspecialidadControlador;

class EstudioMedicoTest {

	private EstudioMedico estudiosMedicos;
	private EspecialidadControlador especialidadCon;
	

	@BeforeEach
	void setUp() throws Exception {
		this.estudiosMedicos = new EstudioMedico(Calendar.getInstance(), new Medico("0106574893", "Elver", "Ramiro", "Madrid", Calendar.getInstance(), "Espana", "Masculino", "elverf@gmail.com", "Colaborador", "Activo", "elverf", "notengo", "por ahora"), new Especialidad("Ginecologo"));
	}

	@Test
	void test() {
		assertEquals("Ingresado", null);
	}

}
