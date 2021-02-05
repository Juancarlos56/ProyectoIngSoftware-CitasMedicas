package ec.edu.ups.entidades;

import java.io.Serializable;

import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaCompra
 *
 */
@Entity

public class FacturaCompra extends FacturaGeneral<FacturaCompra> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="cantidadFacturaCompra",nullable=false)
	private int cantidadFacturaCompra;
	
	@Column(name="precioUnitarioFacturaCompra",nullable=false)
	private double precioUnitario;
	
	@ManyToOne
	@JoinColumn(name = "FK_FacturaCompra_Activo")
	private Activo activoCompra;
	
	public FacturaCompra() {
		super();
	}


	public FacturaCompra(Calendar fecha, String descripcion, String tipoTransaccion,
			String estado, double subtotal, double iva, double total, String tipoFactura, 
			int cantidadFacturaCompra, double precioUnitario, Activo activoCompra) {
		
		super(fecha, descripcion, tipoTransaccion, estado, subtotal, iva, total, tipoFactura);
		this.cantidadFacturaCompra = cantidadFacturaCompra;
		this.precioUnitario = precioUnitario;
		this.activoCompra = activoCompra;
	}

	public FacturaCompra(int idfactura, Calendar fecha, String descripcion, String tipoTransaccion,
			String estado, double subtotal, double iva, double total, String tipoFactura, 
			int cantidadFacturaCompra, double precioUnitario, Activo activoCompra) {
		
		super(idfactura, fecha, descripcion, tipoTransaccion, estado, subtotal, iva, total, tipoFactura);
		this.cantidadFacturaCompra = cantidadFacturaCompra;
		this.precioUnitario = precioUnitario;
		this.activoCompra = activoCompra;
	}

	
	public FacturaCompra(Calendar fecha, String descripcion, String tipoTransaccion, String estado, String tipoFactura, 
			double iva, int cantidadFacturaCompra, double precioUnitario) {
		super(fecha, descripcion, tipoTransaccion, estado, tipoFactura, iva);
		this.cantidadFacturaCompra = cantidadFacturaCompra;
		this.precioUnitario = precioUnitario;
	}


	@Override
	public double calcularSubtotal() {
		return getPrecioUnitario() * getCantidadFacturaCompra();
	}

	
	
	public double calcularTotalFactura() {
		return super.calcularTotalFactura();
	}
	
	
	public double calcularValorFactura() {
		return super.calcularValorFactura();
	}

	@Override
	public LibroDiario actualizarLibroDiario(FacturaCompra factura, LibroDiario libroDiario) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getCantidadFacturaCompra() {
		return cantidadFacturaCompra;
	}


	public void setCantidadFacturaCompra(int cantidadFacturaCompra) {
		this.cantidadFacturaCompra = cantidadFacturaCompra;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	


	public Activo getActivoCompra() {
		return activoCompra;
	}


	public void setActivoCompra(Activo activoCompra) {
		this.activoCompra = activoCompra;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidadFacturaCompra;
		long temp;
		temp = Double.doubleToLongBits(precioUnitario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturaCompra other = (FacturaCompra) obj;
		if (cantidadFacturaCompra != other.cantidadFacturaCompra)
			return false;
		if (Double.doubleToLongBits(precioUnitario) != Double.doubleToLongBits(other.precioUnitario))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "FacturaCompra [cantidadFacturaCompra=" + cantidadFacturaCompra + ", precioUnitario=" + precioUnitario
				+ ", activoCompra=" + activoCompra + "]";
	}


	

	
	
	
	
}
