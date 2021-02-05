package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.ups.entidades.Especialidad;

class EspecialidadTest {
	
	private Especialidad especialidad;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


	@AfterEach
	void tearDown() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		this.especialidad = new Especialidad("Ginecologia");
		
	}

	@Test
	void test() {
		assertEquals("Ingresador", null);
	}

}
