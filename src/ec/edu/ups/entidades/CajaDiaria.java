package ec.edu.ups.entidades;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CajaDiaria
 *
 */
@Entity

public class CajaDiaria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoCajaDiaria")
    private int codigoCajaDiaria;
	
	@Column(name = "totalDineroSalarioCajaDiaria")
    private int totalDineroSalarioCajaDiaria;
	
	
	@Column(name = "totalDineroActivoCajaDiaria")
    private int totalDineroActivoCajaDiaria;
	
	@Column(name = "totalDineroDeudaCajaDiaria")
    private int totalDineroDeudaCajaDiaria;
	
	@Column(name = "totalDineroPatrimonioCajaDiaria")
    private int totalDineroPatrimonioCajaDiaria;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaCajaDiaria")
	private Calendar fechaCajaDiaria;
	
	/*Relacion de mucho a uno con la entidad LibroDiario, mapeado por libroDiario */
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libroDiarioDeCajaDiaria")
    private List<LibroDiario> registroLibroDiario=new ArrayList<LibroDiario>();
    
	public CajaDiaria() {
		super();
	}

	
	
	public CajaDiaria(int codigoCajaDiaria, int totalDineroSalarioCajaDiaria, int totalDineroActivoCajaDiaria,
			int totalDineroDeudaCajaDiaria, int totalDineroPatrimonioCajaDiaria, Calendar fechaCajaDiaria,
			List<LibroDiario> registroLibroDiario) {
		super();
		this.codigoCajaDiaria = codigoCajaDiaria;
		this.totalDineroSalarioCajaDiaria = totalDineroSalarioCajaDiaria;
		this.totalDineroActivoCajaDiaria = totalDineroActivoCajaDiaria;
		this.totalDineroDeudaCajaDiaria = totalDineroDeudaCajaDiaria;
		this.totalDineroPatrimonioCajaDiaria = totalDineroPatrimonioCajaDiaria;
		this.fechaCajaDiaria = fechaCajaDiaria;
		this.registroLibroDiario = registroLibroDiario;
	}


	//Constructor sin codigo por autogeneracion
	public CajaDiaria(int totalDineroSalarioCajaDiaria, int totalDineroActivoCajaDiaria, int totalDineroDeudaCajaDiaria,
			int totalDineroPatrimonioCajaDiaria, Calendar fechaCajaDiaria) {
		super();
		this.totalDineroSalarioCajaDiaria = totalDineroSalarioCajaDiaria;
		this.totalDineroActivoCajaDiaria = totalDineroActivoCajaDiaria;
		this.totalDineroDeudaCajaDiaria = totalDineroDeudaCajaDiaria;
		this.totalDineroPatrimonioCajaDiaria = totalDineroPatrimonioCajaDiaria;
		this.fechaCajaDiaria = fechaCajaDiaria;
	}



	/**
	 * Metodos propios de la clase CajaDiaria
	 */
	
	public double calcularTotalPatrimonio() {
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.DOWN);
		double totalPatriminio = 0.0;
		totalPatriminio = calcularTotalEntradas()-calcularSalidasPorPagoSalario();
		return Double.parseDouble(df.format(totalPatriminio).replace(",","."));
	}
	
	public double calcularTotalEntradas() {
		double totalEntradaEmpresa = calcularEntradasPorCitaMedica()+calcularEntradasPorCompra();
		return totalEntradaEmpresa;
	}
	
	public double calcularEntradasPorCitaMedica() {
		List<LibroDiario> registrosDiarios = getRegistroLibroDiario();
		double entradaPorCita = 0.0;
		
		for (LibroDiario registroDiario : registrosDiarios) {
			entradaPorCita = entradaPorCita + registroDiario.calcularTotalActivosCitas();
		}
		return entradaPorCita;
	}
	
	public double calcularEntradasPorCompra() {
		List<LibroDiario> registrosDiarios = getRegistroLibroDiario();
		double entradaPorCompra = 0.0;
		
		for (LibroDiario registroDiario : registrosDiarios) {
			entradaPorCompra = entradaPorCompra + registroDiario.calcularTotalActivosCompras();
		}
		return entradaPorCompra;
	}
	
	public double calcularSalidasPorPagoSalario() {
		List<LibroDiario> registrosDiarios = getRegistroLibroDiario();
		double salidaPorSalario = 0.0;
		
		for (LibroDiario registroDiario : registrosDiarios) {
			salidaPorSalario = salidaPorSalario + registroDiario.calcularTotalPasivos();
		}
		return salidaPorSalario;
	}
	
	
	/**
	 * Metodos Getters and Setters
	 */
	
	public int getCodigoCajaDiaria() {
		return codigoCajaDiaria;
	}



	public void setCodigoCajaDiaria(int codigoCajaDiaria) {
		this.codigoCajaDiaria = codigoCajaDiaria;
	}



	public int getTotalDineroSalarioCajaDiaria() {
		return totalDineroSalarioCajaDiaria;
	}



	public void setTotalDineroSalarioCajaDiaria(int totalDineroSalarioCajaDiaria) {
		this.totalDineroSalarioCajaDiaria = totalDineroSalarioCajaDiaria;
	}



	public int getTotalDineroActivoCajaDiaria() {
		return totalDineroActivoCajaDiaria;
	}



	public void setTotalDineroActivoCajaDiaria(int totalDineroActivoCajaDiaria) {
		this.totalDineroActivoCajaDiaria = totalDineroActivoCajaDiaria;
	}



	public int getTotalDineroDeudaCajaDiaria() {
		return totalDineroDeudaCajaDiaria;
	}



	public void setTotalDineroDeudaCajaDiaria(int totalDineroDeudaCajaDiaria) {
		this.totalDineroDeudaCajaDiaria = totalDineroDeudaCajaDiaria;
	}



	public int getTotalDineroPatrimonioCajaDiaria() {
		return totalDineroPatrimonioCajaDiaria;
	}



	public void setTotalDineroPatrimonioCajaDiaria(int totalDineroPatrimonioCajaDiaria) {
		this.totalDineroPatrimonioCajaDiaria = totalDineroPatrimonioCajaDiaria;
	}



	public Calendar getFechaCajaDiaria() {
		return fechaCajaDiaria;
	}



	public void setFechaCajaDiaria(Calendar fechaCajaDiaria) {
		this.fechaCajaDiaria = fechaCajaDiaria;
	}

	public List<LibroDiario> getRegistroLibroDiario() {
		return registroLibroDiario;
	}



	public void setRegistroLibroDiario(List<LibroDiario> registroLibroDiario) {
		this.registroLibroDiario = registroLibroDiario;
	}

	
	public void agregarLibroDiario(LibroDiario libroDiario) {
		this.registroLibroDiario.add(libroDiario);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoCajaDiaria;
		result = prime * result + ((fechaCajaDiaria == null) ? 0 : fechaCajaDiaria.hashCode());
		result = prime * result + ((registroLibroDiario == null) ? 0 : registroLibroDiario.hashCode());
		result = prime * result + totalDineroActivoCajaDiaria;
		result = prime * result + totalDineroDeudaCajaDiaria;
		result = prime * result + totalDineroPatrimonioCajaDiaria;
		result = prime * result + totalDineroSalarioCajaDiaria;
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
		CajaDiaria other = (CajaDiaria) obj;
		if (codigoCajaDiaria != other.codigoCajaDiaria)
			return false;
		if (fechaCajaDiaria == null) {
			if (other.fechaCajaDiaria != null)
				return false;
		} else if (!fechaCajaDiaria.equals(other.fechaCajaDiaria))
			return false;
		if (registroLibroDiario == null) {
			if (other.registroLibroDiario != null)
				return false;
		} else if (!registroLibroDiario.equals(other.registroLibroDiario))
			return false;
		if (totalDineroActivoCajaDiaria != other.totalDineroActivoCajaDiaria)
			return false;
		if (totalDineroDeudaCajaDiaria != other.totalDineroDeudaCajaDiaria)
			return false;
		if (totalDineroPatrimonioCajaDiaria != other.totalDineroPatrimonioCajaDiaria)
			return false;
		if (totalDineroSalarioCajaDiaria != other.totalDineroSalarioCajaDiaria)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "CajaDiaria [codigoCajaDiaria=" + codigoCajaDiaria + ", totalDineroSalarioCajaDiaria="
				+ totalDineroSalarioCajaDiaria + ", totalDineroActivoCajaDiaria=" + totalDineroActivoCajaDiaria
				+ ", totalDineroDeudaCajaDiaria=" + totalDineroDeudaCajaDiaria + ", totalDineroPatrimonioCajaDiaria="
				+ totalDineroPatrimonioCajaDiaria + ", fechaCajaDiaria=" + fechaCajaDiaria + ", registroLibroDiario="
				+ registroLibroDiario + "]";
	}


	
}
