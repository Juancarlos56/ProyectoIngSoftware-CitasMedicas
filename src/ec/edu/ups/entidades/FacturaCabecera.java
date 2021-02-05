package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaCabecera
 *
 */
@Entity

public class FacturaCabecera extends FacturaGeneral<FacturaCabecera> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "detallesDeFacturaCabecera")
    private List<FacturaDetalle> detallesDeFacturaCabecera=new ArrayList<FacturaDetalle>();
	
	@ManyToOne
	@JoinColumn(name = "FK_FacturaCabecera_Activo")
	private Activo activoCobroCitaMedica;
	
	@ManyToOne
	@JoinColumn(name = "FK_FacturaCabecera_Medico")
	private Medico medico;
	
	
	@ManyToOne
	@JoinColumn(name = "FK_FacturaCabecera_FacturaSalario")
	private FacturaSalario cabeceraPagoSalario;
	
	public FacturaCabecera() {
		super();
	}
	
	
	public FacturaCabecera(Calendar fecha, String descripcion, String tipoTransaccion,
			String estado, double subtotal, double iva, double total, String tipoFactura) {
		
		super(fecha, descripcion, tipoTransaccion, estado, subtotal, iva, total, tipoFactura);
	}
	
	public FacturaCabecera(Calendar fecha, String descripcion, String tipoTransaccion,
			String estado, double subtotal, double iva, double total, String tipoFactura,
			Activo activoCobroCitaMedica, FacturaSalario cabeceraPagoSalario, Medico medico) {
		
		super(fecha, descripcion, tipoTransaccion, estado, subtotal, iva, total, tipoFactura);
		this.activoCobroCitaMedica = activoCobroCitaMedica;
		this.cabeceraPagoSalario = cabeceraPagoSalario;
		this.medico = medico;
	}
	
	public FacturaCabecera(int idFactura, Calendar fecha, String descripcion, String tipoTransaccion,
			String estado, double subtotal, double iva, double total, String tipoFactura,
			Activo activoCobroCitaMedica, FacturaSalario cabeceraPagoSalario, Medico medico) {
		
		super(idFactura, fecha, descripcion, tipoTransaccion, estado, subtotal, iva, total, tipoFactura);
		this.activoCobroCitaMedica = activoCobroCitaMedica;
		this.cabeceraPagoSalario = cabeceraPagoSalario;
		this.medico = medico;
	}

	
	public FacturaCabecera(Calendar fecha, String descripcion, String tipoTransaccion, String estado, String tipoFactura, float iva) {
		super(fecha, descripcion, tipoTransaccion, estado, tipoFactura, iva);
	}


	@Override
	public double calcularSubtotal() {
		double subtotalFacturaCabecera = 0.0; 
		List<FacturaDetalle> destalles = getDetallesDeFacturaCabecera();
		
		for (FacturaDetalle facturaDetalle : destalles) {
			subtotalFacturaCabecera = subtotalFacturaCabecera + facturaDetalle.getSubtotalFacturaDetalle();
		}
		
		return subtotalFacturaCabecera;
	}

	
	public double calcularTotalFactura() {
		return super.calcularTotalFactura();
	}
	
	
	public double calcularValorFactura() {
		return super.calcularValorFactura();
	}



	@Override
	public LibroDiario actualizarLibroDiario(FacturaCabecera factura, LibroDiario libroDiario) {
		//Activo activoPorCobroCita = getActivoCobroCitaMedica();
		//activoPorCobroCita.get
		
		return null;
	}




	public List<FacturaDetalle> getDetallesDeFacturaCabecera() {
		return detallesDeFacturaCabecera;
	}



	public void setDetallesDeFacturaCabecera(List<FacturaDetalle> detallesDeFacturaCabecera) {
		this.detallesDeFacturaCabecera = detallesDeFacturaCabecera;
	}
   
	public void agregarDetalleDeFacturaCabecera(FacturaDetalle detalleDeFacturaCabecera) {
		this.detallesDeFacturaCabecera.add(detalleDeFacturaCabecera);
	}


	public Activo getActivoCobroCitaMedica() {
		return activoCobroCitaMedica;
	}



	public void setActivoCobroCitaMedica(Activo activoCobroCitaMedica) {
		this.activoCobroCitaMedica = activoCobroCitaMedica;
	}



	public FacturaSalario getCabeceraPagoSalario() {
		return cabeceraPagoSalario;
	}



	public void setCabeceraPagoSalario(FacturaSalario cabeceraPagoSalario) {
		this.cabeceraPagoSalario = cabeceraPagoSalario;
	}



	public Medico getMedico() {
		return medico;
	}



	public void setMedico(Medico medico) {
		this.medico = medico;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detallesDeFacturaCabecera == null) ? 0 : detallesDeFacturaCabecera.hashCode());
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
		FacturaCabecera other = (FacturaCabecera) obj;
		if (detallesDeFacturaCabecera == null) {
			if (other.detallesDeFacturaCabecera != null)
				return false;
		} else if (!detallesDeFacturaCabecera.equals(other.detallesDeFacturaCabecera))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FacturaCabecera [detallesDeFacturaCabecera=" + detallesDeFacturaCabecera + ", activoCobroCitaMedica="
				+ activoCobroCitaMedica + ", cabeceraPagoSalario=" + cabeceraPagoSalario + "]";
	}









	
}
