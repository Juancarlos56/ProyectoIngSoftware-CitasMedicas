package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.ups.entidades.Medico;

class MedicoTest {

	private Medico medico;
	
	@BeforeEach
	void setUp() throws Exception {
		Calendar fecha = Calendar.getInstance();
		medico = new Medico("0106113302", "Homero", "Sarmiento", "Paute", fecha, "Ecuatoriana", "Masculino", "homeroSarmiento@gmail.com", "Medico", "Activo", "homeroSarmiento", "1234", "colocarURL");
	}

	@Test
	void test() {
		assertEquals("Ingresado", null);
	}

}
