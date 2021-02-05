package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.entidades.Activo;
import ec.edu.ups.entidades.AgendaCitaMedica;
import ec.edu.ups.entidades.CajaDiaria;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.FacturaCompra;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.FacturaSalario;
import ec.edu.ups.entidades.LibroDiario;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Pasivo;
import ec.edu.ups.entidades.Secretaria;

class CajaDiariaTest {

	private CajaDiaria caja; 
	private LibroDiario libro; 
	private Secretaria secretaria;
	private Activo activo; 
	private Pasivo pasivo; 
	private FacturaCabecera factura;
	private FacturaDetalle detalle;
	private AgendaCitaMedica citamedica;
	private Paciente paciente;
	private Medico medico;
	private FacturaSalario salario;
	private FacturaCompra compra;
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		Calendar fecha = Calendar.getInstance();
	
		
		//Creacion de Factura Cabacera
		
		fecha.set(1984,2,7);
		secretaria = new Secretaria("0106113303", "Lucy", "Sarmiento", "Paute", fecha, "Ecuatoriana", "Femenino", 
			"lucySarmiento@gmail.com", "Secretaria", "Activo", "lucySecre", "1234");
		
		
		paciente = new Paciente("0106113301", "Juan", "Barrera", "Paute", fecha, "Ecuatoriana", "Masculino", 
				"barrerajuan930@gmail.com", "Paciente", "Activo", "Desconocido");
		fecha.set(1965,1,7);
		
		medico = new Medico("0106113302", "Homero", "Sarmiento", "Paute", fecha, "Ecuatoriana", "Masculino", 
						"homeroSarmiento@gmail.com", "Medico", "Activo", "homeroSarmiento", "1234", "colocarURL");
		
		citamedica = new AgendaCitaMedica(Calendar.getInstance(), fecha, "Consulta Medica General", 
				"Pendiente",(float)20.0, secretaria, medico, paciente);
		
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
		//Creacion de Activo Citas
		activo = new Activo();
		activo.setTipoActivo("circulante");
		activo.agregarActivoCobroCitaMedica(factura);
		
		
		
		
		//Creacion de Pasivo
		medico.agregarFacturaCabeceraAMedico(factura);
		Calendar fecha3 = Calendar.getInstance();
		salario = new FacturaSalario(fecha3, "Pago salario a medico", "PagoSalario", "PorPagar", (float)12.0, "FacturaSalario", 20.0);
		salario.setFacturasSalarioDeMedico(medico);
		salario.setSubtotal(salario.calcularSubtotal());
		salario.setTotal(salario.calcularSalarioTotalPagoMedico());
		salario.setEstado("Pagado");
		pasivo = new Pasivo();
		pasivo.agregarPasivoPorPagoSalarios(salario);
		
		
		
		
		//Creacion de Libro diario
		fecha.set(2020,1,9);
		libro = new LibroDiario(fecha, secretaria);
		libro.agregarActivoALibroDiario(activo);
		libro.agregarPasivoDeLibroDiario(pasivo);
		
		
	}

	@Test
	@Tag("calcularTotalPatrimonio")
	void calcularTotalPatrimonio() {
		double patrimonioEsperado = 4.48;
		//Creacion de CajaDiaria
		Calendar fecha2 = Calendar.getInstance();
		caja = new CajaDiaria();
		caja.setFechaCajaDiaria(fecha2);
		caja.agregarLibroDiario(libro);
		double patrimonioObtenido = caja.calcularTotalPatrimonio();
		assertEquals(patrimonioEsperado, patrimonioObtenido);
	}
	
	
	@Test
	@Tag("calcularTotalEntradas")
	void calcularTotalEntradas() {
		double entradaEsperado = 22.4;
		//Creacion de CajaDiaria
		Calendar fecha2 = Calendar.getInstance();
		caja = new CajaDiaria();
		caja.setFechaCajaDiaria(fecha2);
		caja.agregarLibroDiario(libro);
		double entradaObtenido = caja.calcularTotalEntradas();
		assertEquals(entradaEsperado, entradaObtenido);
	}
	
	
	@Test
	@Tag("calcularEntradasPorCitaMedica")
	void calcularEntradasPorCitaMedica() {
		double entradaCitaEsperado = 22.4;
		//Creacion de CajaDiaria
		Calendar fecha2 = Calendar.getInstance();
		caja = new CajaDiaria();
		caja.setFechaCajaDiaria(fecha2);
		caja.agregarLibroDiario(libro);
		double entradaCitaObtenido = caja.calcularTotalEntradas();
		assertEquals(entradaCitaEsperado, entradaCitaObtenido);
	}
	
	
	@Test
	@Tag("calcularEntradasPorCompra")
	void calcularEntradasPorCompra() {
		double entradaPorCompraEsperado = 0.0;
		//Creacion de CajaDiaria
		Calendar fecha2 = Calendar.getInstance();
		caja = new CajaDiaria();
		caja.setFechaCajaDiaria(fecha2);
		caja.agregarLibroDiario(libro);
		double entradaPorCompraObtenido = caja.calcularEntradasPorCompra();
		assertEquals(entradaPorCompraEsperado, entradaPorCompraObtenido);
	}
	
	@Test
	@Tag("calcularEntradasPorCompraRealizada")
	void calcularEntradasPorCompraRealizada() {
		
		Calendar fecha2 = Calendar.getInstance();
		compra = new FacturaCompra(fecha2, "Compra de producto sanitario cloro", "Compra", "Comprado", "facturaCompra", (float)12.0, 10, 2.50);
		compra.setSubtotal(compra.calcularSubtotal());
		compra.setTotal(compra.calcularTotalFactura());
		activo = new Activo();
		activo.setTipoActivo("fijo");
		activo.agregarActivoCompraEmpresa(compra);
		libro.agregarActivoALibroDiario(activo);
		
		double entradaPorCompraEsperado = 28.0;
		//Creacion de CajaDiaria
		caja = new CajaDiaria();
		caja.setFechaCajaDiaria(fecha2);
		caja.agregarLibroDiario(libro);
		double entradaPorCompraObtenido = caja.calcularEntradasPorCompra();
		assertEquals(entradaPorCompraEsperado, entradaPorCompraObtenido);
	}
	
}
