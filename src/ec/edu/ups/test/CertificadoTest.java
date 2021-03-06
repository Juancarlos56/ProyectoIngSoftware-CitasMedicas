package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.controladores.CertificadoMedicoControlador;
import ec.edu.ups.entidades.Consulta;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Secretaria;

class CertificadoTest {

	private String respuesta="";

	private CertificadoMedicoControlador certificado= new CertificadoMedicoControlador();

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
		respuesta=certificado.nuevoCertificadoMedico(new GregorianCalendar(), 1, "Descrippcion", new Consulta(new GregorianCalendar(), "Sintomas", "Diagnostico", "observaciones", "Medicinas", "Dosis", paciente, medico));
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
