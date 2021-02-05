package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ec.edu.ups.entidades.FacturaCompra;

class FacturaCompraTest {

	private FacturaCompra compra; 
	
	@BeforeEach
	void setUp() throws Exception {
		Calendar fecha2 = Calendar.getInstance();
		compra = new FacturaCompra(fecha2, "Compra de producto sanitario cloro", "Compra", "Comprado", "facturaCompra", (float)12.0, 10, 2.50);
	}

	@Test
	@Tag("SubtotalFacturaCompra")
	void CalculoSubtotalFacturaCabecera() {
		double subtotalEsperado = 25;
		double subtotalObtenido  = compra.calcularSubtotal();
		assertEquals(subtotalEsperado,subtotalObtenido);
	}
	
	
	@Test
	@Tag("totalFacturaCompra")
	void totalFacturaCabecera() {
		double totalEsperado = 28;
		
		compra.setSubtotal(compra.calcularSubtotal());
		double totalObtenido  = compra.calcularTotalFactura();
		assertEquals(totalEsperado,totalObtenido);
	}

}
