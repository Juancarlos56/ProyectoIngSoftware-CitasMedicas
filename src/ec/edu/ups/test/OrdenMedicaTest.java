package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.controladores.OrdenMedicaControlador;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Secretaria;

class OrdenMedicaTest {

	private String respuesta="";

	private OrdenMedicaControlador orden= new OrdenMedicaControlador();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		Paciente paciente = new Paciente("0102286445", "Manuel", "Armijos", "Machala", new GregorianCalendar(), "Ecuatoriana", "Masculino", "marmijos@hotmail.com", "Paciente", "Activo", "O+"); 		
		respuesta=orden.nuevaOrdenMedica("Descripcion", "Diagnostico", new Date(), paciente);
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
