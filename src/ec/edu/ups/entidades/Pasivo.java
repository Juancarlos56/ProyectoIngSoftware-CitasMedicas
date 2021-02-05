package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pasivo
 *
 */
@Entity

public class Pasivo implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pasivoId")
	private int activoId;
	
	@Column(name = "valorPasivo", nullable = false)
	private double valorPasivo;
	
	//Patrimonio o circulante
	//@Column(name = "tipoActivo", length = 11, nullable = false)
	//private String tipoPasivo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasivoPagoSalario")
    private List<FacturaSalario> pasivosPorPagoSalarios=new ArrayList<FacturaSalario>();
	
	@ManyToOne
	@JoinColumn(name = "FK_libroDiario_Pasivo")
	private LibroDiario pasivoDelibroDiario; 
	
	public Pasivo() {
		super();
	}

	public Pasivo(int activoId, float valorPasivo, LibroDiario pasivoDelibroDiario) {
		super();
		this.activoId = activoId;
		this.valorPasivo = valorPasivo;
		this.pasivoDelibroDiario = pasivoDelibroDiario;
	}
	
	public Pasivo(float valorPasivo, LibroDiario pasivoDelibroDiario) {
		super();
		this.valorPasivo = valorPasivo;
		this.pasivoDelibroDiario = pasivoDelibroDiario;
	}

	
	//Metodos propios de la clase Pasivo
	
	public double calcularValorPasivoSalarioDoctor() {
		double valorPasivo = 0.0;
		List<FacturaSalario> facturasSalarios = getPasivosPorPagoSalarios();
		for (FacturaSalario facturaSalario : facturasSalarios) {
			if (facturaSalario.getEstado() == "Pagado") {
				valorPasivo = valorPasivo + facturaSalario.getTotal();
			}
		}
		return valorPasivo;
	}
	
	public int getActivoId() {
		return activoId;
	}

	public void setActivoId(int activoId) {
		this.activoId = activoId;
	}

	public double getValorPasivo() {
		return valorPasivo;
	}

	public void setValorPasivo(double valorActivo) {
		this.valorPasivo = valorActivo;
	}

	public List<FacturaSalario> getPasivosPorPagoSalarios() {
		return pasivosPorPagoSalarios;
	}

	public void setPasivosPorPagoSalarios(List<FacturaSalario> pasivosPorPagoSalarios) {
		this.pasivosPorPagoSalarios = pasivosPorPagoSalarios;
	}
	
	public void agregarPasivoPorPagoSalarios(FacturaSalario pagoSalarios) {
		this.pasivosPorPagoSalarios.add(pagoSalarios);
	}

	public LibroDiario getPasivoDelibroDiario() {
		return pasivoDelibroDiario;
	}

	public void setPasivoDelibroDiario(LibroDiario pasivoDelibroDiario) {
		this.pasivoDelibroDiario = pasivoDelibroDiario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activoId;
		result = prime * result + ((pasivoDelibroDiario == null) ? 0 : pasivoDelibroDiario.hashCode());
		result = prime * result + ((pasivosPorPagoSalarios == null) ? 0 : pasivosPorPagoSalarios.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorPasivo);
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
		Pasivo other = (Pasivo) obj;
		if (activoId != other.activoId)
			return false;
		if (pasivoDelibroDiario == null) {
			if (other.pasivoDelibroDiario != null)
				return false;
		} else if (!pasivoDelibroDiario.equals(other.pasivoDelibroDiario))
			return false;
		if (pasivosPorPagoSalarios == null) {
			if (other.pasivosPorPagoSalarios != null)
				return false;
		} else if (!pasivosPorPagoSalarios.equals(other.pasivosPorPagoSalarios))
			return false;
		if (Double.doubleToLongBits(valorPasivo) != Double.doubleToLongBits(other.valorPasivo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pasivo [activoId=" + activoId + ", valorPasivo=" + valorPasivo + ", pasivosPorPagoSalarios="
				+ pasivosPorPagoSalarios + ", pasivoDelibroDiario=" + pasivoDelibroDiario + "]";
	}

	
}
