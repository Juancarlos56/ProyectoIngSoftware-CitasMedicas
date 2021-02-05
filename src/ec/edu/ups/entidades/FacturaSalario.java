package ec.edu.ups.entidades;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaSalario
 *
 */
@Entity

public class FacturaSalario extends FacturaGeneral<FacturaSalario> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "totalPagoMedicoFacturaSalario")
	private double totalPagoMedicoFacturaSalario;
	
	@Column(name = "comisionEmpresaFacturaSalario")
	private double comisionEmpresaFacturaSalario;
	
	
	
	
	@ManyToOne 
    @JoinColumn
    private Medico facturasSalarioDeMedico;
	
	@ManyToOne
	@JoinColumn(name = "FK_FacturaSalario_Pasivo")
	private Pasivo pasivoPagoSalario;
	
	
	public FacturaSalario() {
		super();
	}
	
	

	public FacturaSalario(Calendar fecha, String descripcion, String tipoTransaccion,
			String estado, double subtotal, double iva, double total, String tipoFactura, 
			double totalPagoMedicoFacturaSalario, double comisionEmpresaFacturaSalario, 
			Medico facturasSalarioDeMedico, Pasivo pasivoPagoSalario) {
		
		
		super(fecha, descripcion, tipoTransaccion, estado, subtotal, iva, total, tipoFactura);
		
		this.totalPagoMedicoFacturaSalario = totalPagoMedicoFacturaSalario;
		this.comisionEmpresaFacturaSalario = comisionEmpresaFacturaSalario;
		this.facturasSalarioDeMedico = facturasSalarioDeMedico;
		this.pasivoPagoSalario = pasivoPagoSalario;
	}
	
	public FacturaSalario(int idFactura, Calendar fecha, String descripcion, String tipoTransaccion,
			String estado, double subtotal, double iva, double total, String tipoFactura, 
			double totalPagoMedicoFacturaSalario, double comisionEmpresaFacturaSalario, 
			Medico facturasSalarioDeMedico, Pasivo pasivoPagoSalario) {
		
		
		super(idFactura, fecha, descripcion, tipoTransaccion, estado, subtotal, iva, total, tipoFactura);
		
		this.totalPagoMedicoFacturaSalario = totalPagoMedicoFacturaSalario;
		this.comisionEmpresaFacturaSalario = comisionEmpresaFacturaSalario;
		this.facturasSalarioDeMedico = facturasSalarioDeMedico;
		this.pasivoPagoSalario = pasivoPagoSalario;
	}
	
	
	public FacturaSalario(Calendar fecha, String descripcion, String tipoTransaccion,
			String estado, double iva, String tipoFactura, double comisionEmpresaFacturaSalario) {
		super(fecha, descripcion, tipoTransaccion, estado, tipoFactura, iva);
		this.comisionEmpresaFacturaSalario = comisionEmpresaFacturaSalario;
	}



	@Override
	public double calcularSubtotal() {
		Medico facturasMedico = getFacturasSalarioDeMedico();
		double subtotalPagoMedico = 0.0;
		for (FacturaCabecera facturaCabecera : facturasMedico.getFacturasCabeceraDeUnMedico()) {
			if (facturaCabecera.getEstado().equals("PagarMedico")) {
				subtotalPagoMedico = subtotalPagoMedico+facturaCabecera.getTotal();
			}
		} 
		return subtotalPagoMedico;
	}

	
	public double calcularSalarioTotalPagoMedico() {
		
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.DOWN);
		double totalSalario = getSubtotal()-((getSubtotal()*getComisionEmpresaFacturaSalario())/100);
		return Double.parseDouble(df.format(totalSalario).replace(",","."));
	}
	
	
	@Override
	public LibroDiario actualizarLibroDiario(FacturaSalario factura, LibroDiario libroDiario) {
		// TODO Auto-generated method stub
		return null;
	}



	public double getTotalPagoMedicoFacturaSalario() {
		return totalPagoMedicoFacturaSalario;
	}



	public void setTotalPagoMedicoFacturaSalario(double totalPagoMedicoFacturaSalario) {
		this.totalPagoMedicoFacturaSalario = totalPagoMedicoFacturaSalario;
	}



	public double getComisionEmpresaFacturaSalario() {
		return comisionEmpresaFacturaSalario;
	}



	public void setComisionEmpresaFacturaSalario(double comisionEmpresaFacturaSalario) {
		this.comisionEmpresaFacturaSalario = comisionEmpresaFacturaSalario;
	}



	public Medico getFacturasSalarioDeMedico() {
		return facturasSalarioDeMedico;
	}



	public void setFacturasSalarioDeMedico(Medico facturasSalarioDeMedico) {
		this.facturasSalarioDeMedico = facturasSalarioDeMedico;
	}


	

	public Pasivo getPasivoPagoSalario() {
		return pasivoPagoSalario;
	}



	public void setPasivoPagoSalario(Pasivo pasivoPagoSalario) {
		this.pasivoPagoSalario = pasivoPagoSalario;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(comisionEmpresaFacturaSalario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalPagoMedicoFacturaSalario);
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
		FacturaSalario other = (FacturaSalario) obj;
		if (Double.doubleToLongBits(comisionEmpresaFacturaSalario) != Double
				.doubleToLongBits(other.comisionEmpresaFacturaSalario))
			return false;
		if (Double.doubleToLongBits(totalPagoMedicoFacturaSalario) != Double
				.doubleToLongBits(other.totalPagoMedicoFacturaSalario))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FacturaSalario [totalPagoMedicoFacturaSalario=" + totalPagoMedicoFacturaSalario
				+ ", comisionEmpresaFacturaSalario=" + comisionEmpresaFacturaSalario + ", facturasSalarioDeMedico="
				+ facturasSalarioDeMedico + ", pasivoPagoSalario=" + pasivoPagoSalario + "]";
	}



	


	
   
}
