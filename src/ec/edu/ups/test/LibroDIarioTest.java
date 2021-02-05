package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ec.edu.ups.controladores.LibroDiarioControlador;
import ec.edu.ups.entidades.CajaDiaria;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Secretaria;

class LibroDIarioTest {
		private String respuesta="";

		private LibroDiarioControlador libro= new LibroDiarioControlador();

		@BeforeAll
		static void setUpBeforeClass() throws Exception {
		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}

		@BeforeEach
		void setUp() throws Exception {
			Secretaria secretaria = new Secretaria("0102286440", "Maria", "Alvarez", "Azogues", new GregorianCalendar(), "Ecuatoriana", "Femenino", "Malvarez@hotmail.com", "Secretaria", "Activo", "sec1", "clave1");
			respuesta=libro.nuevoLibro(secretaria, new CajaDiaria(100, 200, 50, 10, new GregorianCalendar()));
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
