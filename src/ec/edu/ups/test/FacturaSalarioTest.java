package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.entidades.AgendaCitaMedica;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.FacturaSalario;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Secretaria;

class FacturaSalarioTest {

	private FacturaSalario salario; 
	private Medico medico;
	private FacturaCabecera factura;
	private FacturaDetalle detalle;
	private AgendaCitaMedica citamedica;
	private Paciente paciente;
	private Secretaria secretaria;
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		//Creacion de Paciente
		Calendar fecha = Calendar.getInstance();
		fecha.set(1998,7,20);

		paciente = new Paciente("0106113301", "Juan", "Barrera", "Paute", fecha, "Ecuatoriana", "Masculino", 
				"barrerajuan930@gmail.com", "Paciente", "Activo", "Desconocido");
		
				
		//Creacion de Medico
		fecha.set(1998,7,20);
		medico = new Medico("0106113302", "Homero", "Sarmiento", "Paute", fecha, "Ecuatoriana", "Masculino", 
				"homeroSarmiento@gmail.com", "Medico", "Activo", "homeroSarmiento", "1234", "colocarURL");
		
		
		//Creacion de Secretaria
		fecha.set(1984,2,7);
		secretaria = new Secretaria("0106113303", "Lucy", "Sarmiento", "Paute", fecha, "Ecuatoriana", "Femenino", 
			"lucySarmiento@gmail.com", "Secretaria", "Activo", "lucySecre", "1234");
		
		//Creacion de CitaMedica
		
		citamedica = new AgendaCitaMedica(Calendar.getInstance(), fecha, "Consulta Medica General", 
				"Pendiente",(float)20.0, secretaria, medico, paciente);
		
		//Creacion de detalles
		detalle = new FacturaDetalle(1,"cita general para revison de gripe");
		detalle.setCitasDeFacturaDetalle(citamedica);
		detalle.setSubtotalFacturaDetalle(detalle.calcularSubtotalFacturaDetalle());
		
		
		Calendar fecha2 = Calendar.getInstance();
		factura = new FacturaCabecera(fecha2, "Cobro de factura cabecera", "Cita Medica", "PagarMedico", "facturaCabecera", (float)12.0);
		factura.agregarDetalleDeFacturaCabecera(detalle);
		factura.setMedico(detalle.getCitasDeFacturaDetalle().getMedico());
		double subtotal = factura.calcularSubtotal();
		factura.setSubtotal(subtotal);
		double total = factura.calcularTotalFactura();
		factura.setTotal(total);
		
		
		
		
	}

	@Test
	@Tag("SubtotalFacturaSalario")
	void CalculoSubtotalSalario() {
		double subtotalEsperado = 22.4;
		medico.agregarFacturaCabeceraAMedico(factura);
		Calendar fecha3 = Calendar.getInstance();
		salario = new FacturaSalario(fecha3, "Pago salario a medico", "PagoSalario", "PorPagar", (float)12.0, "FacturaSalario", 20.0);
		salario.setFacturasSalarioDeMedico(medico);
		
		double subtotalObtenido  = salario.calcularSubtotal();
		assertEquals(subtotalEsperado,subtotalObtenido);
	}
	
	
	@Test
	@Tag("CalculoSubtotalSalarioMuchasFacturasCabeceras")
	void CalculoSubtotalSalarioMuchasFacturasCabeceras() {
		double subtotalEsperado = 89.6;
		
		for (int i = 0; i < 4; i++) {
			medico.agregarFacturaCabeceraAMedico(factura);
		}
		
		Calendar fecha3 = Calendar.getInstance();
		salario = new FacturaSalario(fecha3, "Pago salario a medico", "PagoSalario", "PorPagar", (float)12.0, "FacturaSalario", 20.0);
		salario.setFacturasSalarioDeMedico(medico);
		
		double subtotalObtenido  = salario.calcularSubtotal();
		assertEquals(subtotalEsperado,subtotalObtenido);
	}
	
	
	@Test
	@Tag("CalculoTotalSalario")
	void CalculoTotalSalario() {
		double totalEsperado = 17.91;
		
		medico.agregarFacturaCabeceraAMedico(factura);
		
		Calendar fecha3 = Calendar.getInstance();
		salario = new FacturaSalario(fecha3, "Pago salario a medico", "PagoSalario", "PorPagar", (float)12.0, "FacturaSalario", 20.0);
		salario.setFacturasSalarioDeMedico(medico);
		
		double subtotal = salario.calcularSubtotal();
		salario.setSubtotal(subtotal);
		
		double totalObtenido = salario.calcularSalarioTotalPagoMedico();
		
		assertEquals(totalEsperado,totalObtenido);
	}
	
	
	

}
