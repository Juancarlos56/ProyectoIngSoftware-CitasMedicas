package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.controladores.HistorialControlador;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;


class HistorialMedicoTest {

	private String respuesta="";

	private HistorialControlador historial= new HistorialControlador();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Paciente paciente = new Paciente("0102286445", "Manuel", "Armijos", "Machala", new GregorianCalendar(), "Ecuatoriana", "Masculino", "marmijos@hotmail.com", "Paciente", "Activo", "O+"); 	
		respuesta=historial.nuevoHistorial("Anamnesis", "Examen Fisico", "Examen Semiologico", "Diagnostico Presuntivo", "Metodos complementario", "Evolucion", "Epicrisis", new GregorianCalendar(), "medicacion", "enfermedades actuales",60, 10, paciente);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Tag("LibroDiario")
	void test() {
		assertEquals("Ingresado", respuesta);
	}
}
