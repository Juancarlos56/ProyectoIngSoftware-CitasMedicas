package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.entidades.AgendaCitaMedica;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Secretaria;

class FacturaDetalleTest {

	private FacturaDetalle detalle;
	private AgendaCitaMedica citamedica;
	private Paciente paciente;
	private Medico medico;
	private Secretaria secretaria;
	
	@BeforeEach
	void setUp() throws Exception {
		//Creacion de Paciente
			Calendar fecha = Calendar.getInstance();
			fecha.set(1998,7,20);

			paciente = new Paciente("0106113301", "Juan", "Barrera", "Paute", fecha, "Ecuatoriana", "Masculino", 
					"barrerajuan930@gmail.com", "Paciente", "Activo", "Desconocido");
			
			
			//Creacion de Medico 
			fecha.set(1965,1,7);
			medico = new Medico("0106113302", "Homero", "Sarmiento", "Paute", fecha, "Ecuatoriana", "Masculino", 
					"homeroSarmiento@gmail.com", "Medico", "Activo", "homeroSarmiento", "1234", "colocarURL");
			
			//Creacion de Secretaria
			fecha.set(1984,2,7);
			secretaria = new Secretaria("0106113303", "Lucy", "Sarmiento", "Paute", fecha, "Ecuatoriana", "Femenino", 
				"lucySarmiento@gmail.com", "Secretaria", "Activo", "lucySecre", "1234");
			
			
			
			citamedica = new AgendaCitaMedica(Calendar.getInstance(), fecha, "Consulta Medica General", 
					"Pendiente",(float)20.0, secretaria, medico, paciente);
	
	}

	@Test
	@Tag("SubtotalFacturaDetalle")
	void CalculoSubtotalDetalle() {
		double subtotalEsperado = 20;
		detalle = new FacturaDetalle(1, "Consulta general");
		detalle.setCitasDeFacturaDetalle(citamedica);
		double subtotalObtenido  = detalle.calcularSubtotalFacturaDetalle();
		assertEquals(subtotalEsperado,subtotalObtenido);
	}
	
	
	@Test
	@Tag("SubtotalFacturaDetalleMuchasCitas")
	void CalculoSubtotalDetalleMuchasCitas() {
		double subtotalEsperado = 80;
		detalle = new FacturaDetalle(4, "Consulta general");
		detalle.setCitasDeFacturaDetalle(citamedica);
		double subtotalObtenido  = detalle.calcularSubtotalFacturaDetalle();
		assertEquals(subtotalEsperado,subtotalObtenido);
	}

}
