package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.controladores.AgendaCitaMedicaControlador;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Secretaria;

class AgendaCitaMedicaTest {

	private String respuesta="";

	private AgendaCitaMedicaControlador agenda= new AgendaCitaMedicaControlador();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		Paciente paciente = new Paciente("0102286445", "Manuel", "Armijos", "Machala", new GregorianCalendar(), "Ecuatoriana", "Masculino", "marmijos@hotmail.com", "Paciente", "Activo", "O+"); 
		Medico medico = new Medico("0102285779", "Zoila", "Carrasco", "Nulti", new GregorianCalendar(), "Ecuatoriana", "Femenino", "zcarrasco@hotmail.com", "Medico", "Activo", "medico1", "clave1", "facebook.com/ZoilaCarrasco");
		Secretaria secretaria = new Secretaria("0102286440", "Maria", "Alvarez", "Azogues", new GregorianCalendar(), "Ecuatoriana", "Femenino", "Malvarez@hotmail.com", "Secretaria", "Activo", "sec1", "clave1");
		respuesta=agenda.nuevaCita(paciente , medico , new GregorianCalendar(), "Seguimiento", "Activa", 20, secretaria );
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
