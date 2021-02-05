package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: LibroDiario
 *
 */
@Entity

public class LibroDiario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "libroId")
	private int libroId;
	
	@Column(name = "totalLibroDiario")
	private double totalLibroDiario;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaLibroDiario")
	private Calendar fechaLibroDiario;
	
	
	@ManyToOne
	@JoinColumn(name = "FK_libroDiario_CajaDiaria")
	private CajaDiaria libroDiarioDeCajaDiaria;    
    
	
	@ManyToOne
	@JoinColumn(name = "FK_libroDiario_Secretaria")
	private Secretaria responsableLibroDiario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "activoDelibroDiario")
    private List<Activo> activosDeLibroDiario=new ArrayList<Activo>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasivoDelibroDiario")
	private List<Pasivo> pasivosDeLibroDiario = new ArrayList<Pasivo>(); 
	
	public LibroDiario() {
		super();
	}

	public LibroDiario(int libroId, float totalLibroDiario, Calendar fechaLibroDiario,
			CajaDiaria libroDiarioDeCajaDiaria, Secretaria responsable) {
		super();
		this.libroId = libroId;
		this.totalLibroDiario = totalLibroDiario;
		this.fechaLibroDiario = fechaLibroDiario;
		this.libroDiarioDeCajaDiaria = libroDiarioDeCajaDiaria;
		this.responsableLibroDiario = responsable;
	}

	//Contructor sin codigo por autogeneracion
	public LibroDiario(float totalLibroDiario, Calendar fechaLibroDiario, CajaDiaria libroDiarioDeCajaDiaria,
			Secretaria responsable) {
		super();
		this.totalLibroDiario = totalLibroDiario;
		this.fechaLibroDiario = fechaLibroDiario;
		this.libroDiarioDeCajaDiaria = libroDiarioDeCajaDiaria;
		this.responsableLibroDiario = responsable;
	}
	
	//Metodos propios de la clase LibroDiario
	
	
	public LibroDiario(Calendar fecha, Secretaria responsable) {
		this.fechaLibroDiario = fecha;
		this.responsableLibroDiario = responsable;
	}

	public double calcularTotal() {
		double totalPasivos = 0.0;
		double totalActivos = 0.0;
		double totalPatrimonio = 0.0;
		
		totalActivos = calcularTotalActivos();
		totalPasivos = calcularTotalPasivos();
		totalPatrimonio = totalActivos - totalPasivos;
		
		return totalPatrimonio;
	}
	
	public double calcularTotalPasivos() {
		List<Pasivo> pasivos = getPasivosDeLibroDiario();
		double totalPasivos = 0.0;
		for (Pasivo pasivo : pasivos) {
			totalPasivos = totalPasivos + pasivo.calcularValorPasivoSalarioDoctor();
		}
		
		return totalPasivos;
	}
	
	
	public double calcularTotalActivos() {
		double totalActivo = 0.0;
		totalActivo = totalActivo + calcularTotalActivosCitas() + calcularTotalActivosCompras();
		return totalActivo;
	}
	
	
	
	public double calcularTotalActivosCitas() {
		List<Activo> activos = getActivosDeLibroDiario();
		double totalActivoCitas = 0.0;
		
		for (Activo activo : activos) {
			totalActivoCitas = totalActivoCitas + activo.calcularValorActivoCitas();
		}
		
		return totalActivoCitas;
	}
	
	public double calcularTotalActivosCompras() {
		List<Activo> activos = getActivosDeLibroDiario();
		double totalActivoCompras = 0.0;
		
		for (Activo activo : activos) {
			totalActivoCompras = totalActivoCompras + activo.calcularValorActivoCompras();
		}
		
		return totalActivoCompras;
	}
	
	


	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public double getTotalLibroDiario() {
		return totalLibroDiario;
	}

	public void setTotalLibroDiario(double totalLibroDiario) {
		this.totalLibroDiario = totalLibroDiario;
	}

	public Calendar getFechaLibroDiario() {
		return fechaLibroDiario;
	}

	public void setFechaLibroDiario(Calendar fechaLibroDiario) {
		this.fechaLibroDiario = fechaLibroDiario;
	}

	public CajaDiaria getLibroDiarioDeCajaDiaria() {
		return libroDiarioDeCajaDiaria;
	}

	public void setLibroDiarioDeCajaDiaria(CajaDiaria libroDiarioDeCajaDiaria) {
		this.libroDiarioDeCajaDiaria = libroDiarioDeCajaDiaria;
	}

	public Secretaria getResponsableLibroDiario() {
		return responsableLibroDiario;
	}

	public void setResponsableLibroDiario(Secretaria responsableLibroDiario) {
		this.responsableLibroDiario = responsableLibroDiario;
	}

	public List<Activo> getActivosDeLibroDiario() {
		return activosDeLibroDiario;
	}

	public void setActivosDeLibroDiario(List<Activo> activosDeLibroDiario) {
		this.activosDeLibroDiario = activosDeLibroDiario;
	}
	
	public void agregarActivoALibroDiario(Activo activo) {
		this.activosDeLibroDiario.add(activo);
	}

	public List<Pasivo> getPasivosDeLibroDiario() {
		return pasivosDeLibroDiario;
	}

	public void setPasivosDeLibroDiario(List<Pasivo> pasivosDeLibroDiario) {
		this.pasivosDeLibroDiario = pasivosDeLibroDiario;
	}
	
	public void agregarPasivoDeLibroDiario(Pasivo pasivo) {
		this.pasivosDeLibroDiario.add(pasivo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activosDeLibroDiario == null) ? 0 : activosDeLibroDiario.hashCode());
		result = prime * result + ((fechaLibroDiario == null) ? 0 : fechaLibroDiario.hashCode());
		result = prime * result + ((libroDiarioDeCajaDiaria == null) ? 0 : libroDiarioDeCajaDiaria.hashCode());
		result = prime * result + libroId;
		result = prime * result + ((pasivosDeLibroDiario == null) ? 0 : pasivosDeLibroDiario.hashCode());
		result = prime * result + ((responsableLibroDiario == null) ? 0 : responsableLibroDiario.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalLibroDiario);
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
		LibroDiario other = (LibroDiario) obj;
		if (activosDeLibroDiario == null) {
			if (other.activosDeLibroDiario != null)
				return false;
		} else if (!activosDeLibroDiario.equals(other.activosDeLibroDiario))
			return false;
		if (fechaLibroDiario == null) {
			if (other.fechaLibroDiario != null)
				return false;
		} else if (!fechaLibroDiario.equals(other.fechaLibroDiario))
			return false;
		if (libroDiarioDeCajaDiaria == null) {
			if (other.libroDiarioDeCajaDiaria != null)
				return false;
		} else if (!libroDiarioDeCajaDiaria.equals(other.libroDiarioDeCajaDiaria))
			return false;
		if (libroId != other.libroId)
			return false;
		if (pasivosDeLibroDiario == null) {
			if (other.pasivosDeLibroDiario != null)
				return false;
		} else if (!pasivosDeLibroDiario.equals(other.pasivosDeLibroDiario))
			return false;
		if (responsableLibroDiario == null) {
			if (other.responsableLibroDiario != null)
				return false;
		} else if (!responsableLibroDiario.equals(other.responsableLibroDiario))
			return false;
		if (Double.doubleToLongBits(totalLibroDiario) != Double.doubleToLongBits(other.totalLibroDiario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LibroDiario [libroId=" + libroId + ", totalLibroDiario=" + totalLibroDiario + ", fechaLibroDiario="
				+ fechaLibroDiario + ", libroDiarioDeCajaDiaria=" + libroDiarioDeCajaDiaria
				+ ", responsableLibroDiario=" + responsableLibroDiario + ", activosDeLibroDiario="
				+ activosDeLibroDiario + ", pasivosDeLibroDiario=" + pasivosDeLibroDiario + "]";
	}

	

	

}
