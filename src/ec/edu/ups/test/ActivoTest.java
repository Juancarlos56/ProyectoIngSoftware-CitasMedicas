package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.entidades.Activo;

class ActivoTest {
	private Activo activo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		this.activo=new Activo(10, 12, "normal");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Tag("Activo")
	void test() {
		assertEquals("Ingresado", null);
	}
	
}
