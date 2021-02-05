package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.entidades.AgendaCitaMedica;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Secretaria;

class FacturaCabeceraTest {

	
	private FacturaCabecera factura;
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
		
		
		//Creacion de detalles
		detalle = new FacturaDetalle(1,"cita general para revison de gripe");
		detalle.setCitasDeFacturaDetalle(citamedica);
		detalle.setSubtotalFacturaDetalle(detalle.calcularSubtotalFacturaDetalle());
		
	}
	
	
	@Test
	@Tag("SubtotalFacturaCabecera")
	void CalculoSubtotalFacturaCabecera() {
		double subtotalEsperado = 20;
		Calendar fecha2 = Calendar.getInstance();
		factura = new FacturaCabecera(fecha2, "Cobro de factura cabecera", "Cita Medica", "PagarMedico", "facturaCabecera", (float)12.0);
		factura.agregarDetalleDeFacturaCabecera(detalle);
		factura.setMedico(detalle.getCitasDeFacturaDetalle().getMedico());
		double subtotalObtenido  = factura.calcularSubtotal();
		assertEquals(subtotalEsperado,subtotalObtenido);
	}
	
	@Test
	@Tag("SubtotalFacturaCabeceraMuchosDetalles")
	void CalculoSubtotalFacturaCabeceraMuchosDetalles() {
		double subtotalEsperado = 80;
		Calendar fecha2 = Calendar.getInstance();
		factura = new FacturaCabecera(fecha2, "Cobro de factura cabecera", "Cita Medica", "PagarMedico", "facturaCabecera", (float)12.0);
		for (int i = 0; i < 4; i++) {
			factura.agregarDetalleDeFacturaCabecera(detalle);
		}
		
		factura.setMedico(detalle.getCitasDeFacturaDetalle().getMedico());
		double subtotalObtenido  = factura.calcularSubtotal();
		assertEquals(subtotalEsperado,subtotalObtenido);
		
		
	
	}
	
	@Test
	@Tag("totalFacturaCabecera")
	void CalculoTotalFacturaCabecera() {
		double totalEsperado = 22.4;
		Calendar fecha2 = Calendar.getInstance();
		factura = new FacturaCabecera(fecha2, "Cobro de factura cabecera", "Cita Medica", "PagarMedico", "facturaCabecera", (float)12.0);
		factura.agregarDetalleDeFacturaCabecera(detalle);
		factura.setMedico(detalle.getCitasDeFacturaDetalle().getMedico());
		double subtotal = factura.calcularSubtotal();
		factura.setSubtotal(subtotal);
		
		double totalObtenido = factura.calcularTotalFactura();
		assertEquals(totalEsperado,totalObtenido);
		
		
	
	}
	
	
	@Test
	@Tag("totalFacturaCabeceraMuchosDetalles")
	void CalculoTotalFacturaCabeceraMuchosDetalles() {
		double totalEsperado = 89.6;
		Calendar fecha2 = Calendar.getInstance();
		factura = new FacturaCabecera(fecha2, "Cobro de factura cabecera", "Cita Medica", "PagarMedico", "facturaCabecera", (float)12.0);
		for (int i = 0; i < 4; i++) {
			factura.agregarDetalleDeFacturaCabecera(detalle);
		}
		
		factura.setMedico(detalle.getCitasDeFacturaDetalle().getMedico());
		double subtotal = factura.calcularSubtotal();
		factura.setSubtotal(subtotal);
		
		double totalObtenido = factura.calcularTotalFactura();
		assertEquals(totalEsperado,totalObtenido);
		
		
	
	}
	

}
