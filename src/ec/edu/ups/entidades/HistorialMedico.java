package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HistoralMedico
 *
 */
@Entity

public class HistorialMedico implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHistorial")
	private int idHistorial;
	
	@Column(name = "anamnesisDeUnPaciente", length = 255, nullable = true)
	private String anamnesisDeUnPaciente;
	
	@Column(name = "examenFisicoDeUnPaciente", length = 255, nullable = true)
	private String examenFisicoDeUnPaciente;
	
	@Column(name = "examenSemiologicoDeUnPaciente", length = 255, nullable = true)
	private String examenSemiologicoDeUnPaciente;
	
	@Column(name = "diagnosticoPresuntivoDeUnPaciente", length = 255, nullable = true)
	private String diagnosticoPresuntivoDeUnPaciente;
	
	@Column(name = "metodosComplementariosDeUnPaciente", length = 255, nullable = true)
	private String metodosComplementariosDeUnPaciente;
	
	@Column(name = "evolucionDiariaDeUnPaciente", length = 255, nullable = true)
	private String evolucionDiariaDeUnPaciente;
	
	@Column(name = "epicrisisDeUnPaciente", length = 255, nullable = true)
	private String epicrisisDeUnPaciente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaHistoriaMedica")
	private Calendar fechaHistoriaMedica;
	
	@Column(name = "medicacionActualDeUnPaciente", length = 255, nullable = true)
	private String medicacionActualDeUnPaciente;
	
	@Column(name = "enfermedadesActualesDeUnPaciente", length = 255, nullable = true)
	private String enfermedadesActualesDeUnPaciente;
	
	@Column(name = "pesoDeUnPaciente", nullable = false)
	private float pesoDeUnPaciente;
	
	@Column(name = "IMCDeUnPaciente", nullable = false)
	private float IMCDeUnPaciente;
	
	
	@ManyToOne
	@JoinColumn(name = "FK_Paciente_Historial")
	private Paciente historialDelPaciente;


	public HistorialMedico() {
		super();
	}
	
	public HistorialMedico(String anamnesis, String examenFisicoDeUnPaciente, String examenSemiologicoDeUnPaciente,
			String diagnosticoPresuntivoDeUnPaciente, String metodosComplementariosDeUnPaciente,
			String evolucionDiariaDeUnPaciente, String epicrisisDeUnPaciente, Calendar fechaHistoriaMedica,
			String medicacionActualDeUnPaciente, String enfermedadesActualesDeUnPaciente, float pesoDeUnPaciente,
			float iMCDeUnPaciente, Paciente historialDelPaciente) {
		super();
		this.anamnesisDeUnPaciente = anamnesis;
		this.examenFisicoDeUnPaciente = examenFisicoDeUnPaciente;
		this.examenSemiologicoDeUnPaciente = examenSemiologicoDeUnPaciente;
		this.diagnosticoPresuntivoDeUnPaciente = diagnosticoPresuntivoDeUnPaciente;
		this.metodosComplementariosDeUnPaciente = metodosComplementariosDeUnPaciente;
		this.evolucionDiariaDeUnPaciente = evolucionDiariaDeUnPaciente;
		this.epicrisisDeUnPaciente = epicrisisDeUnPaciente;
		this.fechaHistoriaMedica = fechaHistoriaMedica;
		this.medicacionActualDeUnPaciente = medicacionActualDeUnPaciente;
		this.enfermedadesActualesDeUnPaciente = enfermedadesActualesDeUnPaciente;
		this.pesoDeUnPaciente = pesoDeUnPaciente;
		IMCDeUnPaciente = iMCDeUnPaciente;
		this.historialDelPaciente = historialDelPaciente;
	}

	public HistorialMedico(int idHistorial, String anamnesis, String examenFisicoDeUnPaciente,
			String examenSemiologicoDeUnPaciente, String diagnosticoPresuntivoDeUnPaciente,
			String metodosComplementariosDeUnPaciente, String evolucionDiariaDeUnPaciente, String epicrisisDeUnPaciente,
			Calendar fechaHistoriaMedica, String medicacionActualDeUnPaciente,
			String enfermedadesActualesDeUnPaciente, float pesoDeUnPaciente, float iMCDeUnPaciente,
			Paciente historialDelPaciente) {
		super();
		this.idHistorial = idHistorial;
		this.anamnesisDeUnPaciente = anamnesis;
		this.examenFisicoDeUnPaciente = examenFisicoDeUnPaciente;
		this.examenSemiologicoDeUnPaciente = examenSemiologicoDeUnPaciente;
		this.diagnosticoPresuntivoDeUnPaciente = diagnosticoPresuntivoDeUnPaciente;
		this.metodosComplementariosDeUnPaciente = metodosComplementariosDeUnPaciente;
		this.evolucionDiariaDeUnPaciente = evolucionDiariaDeUnPaciente;
		this.epicrisisDeUnPaciente = epicrisisDeUnPaciente;
		this.fechaHistoriaMedica = fechaHistoriaMedica;
		this.medicacionActualDeUnPaciente = medicacionActualDeUnPaciente;
		this.enfermedadesActualesDeUnPaciente = enfermedadesActualesDeUnPaciente;
		this.pesoDeUnPaciente = pesoDeUnPaciente;
		IMCDeUnPaciente = iMCDeUnPaciente;
		this.historialDelPaciente = historialDelPaciente;
	}

	//Metodos propios de la clase HistorialMedico
	
	
	
	//Metodos getters and setters
	
	public int getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}

	public String getAnamnesisDeUnPaciente() {
		return anamnesisDeUnPaciente;
	}

	public void setAnamnesisDeUnPaciente(String anamnesisDeUnPaciente) {
		this.anamnesisDeUnPaciente = anamnesisDeUnPaciente;
	}

	public String getExamenFisicoDeUnPaciente() {
		return examenFisicoDeUnPaciente;
	}

	public void setExamenFisicoDeUnPaciente(String examenFisicoDeUnPaciente) {
		this.examenFisicoDeUnPaciente = examenFisicoDeUnPaciente;
	}

	public String getExamenSemiologicoDeUnPaciente() {
		return examenSemiologicoDeUnPaciente;
	}

	public void setExamenSemiologicoDeUnPaciente(String examenSemiologicoDeUnPaciente) {
		this.examenSemiologicoDeUnPaciente = examenSemiologicoDeUnPaciente;
	}

	public String getDiagnosticoPresuntivoDeUnPaciente() {
		return diagnosticoPresuntivoDeUnPaciente;
	}

	public void setDiagnosticoPresuntivoDeUnPaciente(String diagnosticoPresuntivoDeUnPaciente) {
		this.diagnosticoPresuntivoDeUnPaciente = diagnosticoPresuntivoDeUnPaciente;
	}

	public String getMetodosComplementariosDeUnPaciente() {
		return metodosComplementariosDeUnPaciente;
	}

	public void setMetodosComplementariosDeUnPaciente(String metodosComplementariosDeUnPaciente) {
		this.metodosComplementariosDeUnPaciente = metodosComplementariosDeUnPaciente;
	}

	public String getEvolucionDiariaDeUnPaciente() {
		return evolucionDiariaDeUnPaciente;
	}

	public void setEvolucionDiariaDeUnPaciente(String evolucionDiariaDeUnPaciente) {
		this.evolucionDiariaDeUnPaciente = evolucionDiariaDeUnPaciente;
	}

	public String getEpicrisisDeUnPaciente() {
		return epicrisisDeUnPaciente;
	}

	public void setEpicrisisDeUnPaciente(String epicrisisDeUnPaciente) {
		this.epicrisisDeUnPaciente = epicrisisDeUnPaciente;
	}

	public Calendar getFechaHistoriaMedica() {
		return fechaHistoriaMedica;
	}

	public void setFechaHistoriaMedica(Calendar fechaHistoriaMedica) {
		this.fechaHistoriaMedica = fechaHistoriaMedica;
	}

	public String getMedicacionActualDeUnPaciente() {
		return medicacionActualDeUnPaciente;
	}

	public void setMedicacionActualDeUnPaciente(String medicacionActualDeUnPaciente) {
		this.medicacionActualDeUnPaciente = medicacionActualDeUnPaciente;
	}

	public String getEnfermedadesActualesDeUnPaciente() {
		return enfermedadesActualesDeUnPaciente;
	}

	public void setEnfermedadesActualesDeUnPaciente(String enfermedadesActualesDeUnPaciente) {
		this.enfermedadesActualesDeUnPaciente = enfermedadesActualesDeUnPaciente;
	}

	public float getPesoDeUnPaciente() {
		return pesoDeUnPaciente;
	}

	public void setPesoDeUnPaciente(float pesoDeUnPaciente) {
		this.pesoDeUnPaciente = pesoDeUnPaciente;
	}

	public float getIMCDeUnPaciente() {
		return IMCDeUnPaciente;
	}

	public void setIMCDeUnPaciente(float iMCDeUnPaciente) {
		IMCDeUnPaciente = iMCDeUnPaciente;
	}

	public Paciente getHistorialDelPaciente() {
		return historialDelPaciente;
	}

	public void setHistorialDelPaciente(Paciente historialDelPaciente) {
		this.historialDelPaciente = historialDelPaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(IMCDeUnPaciente);
		result = prime * result + ((anamnesisDeUnPaciente == null) ? 0 : anamnesisDeUnPaciente.hashCode());
		result = prime * result
				+ ((diagnosticoPresuntivoDeUnPaciente == null) ? 0 : diagnosticoPresuntivoDeUnPaciente.hashCode());
		result = prime * result
				+ ((enfermedadesActualesDeUnPaciente == null) ? 0 : enfermedadesActualesDeUnPaciente.hashCode());
		result = prime * result + ((epicrisisDeUnPaciente == null) ? 0 : epicrisisDeUnPaciente.hashCode());
		result = prime * result + ((evolucionDiariaDeUnPaciente == null) ? 0 : evolucionDiariaDeUnPaciente.hashCode());
		result = prime * result + ((examenFisicoDeUnPaciente == null) ? 0 : examenFisicoDeUnPaciente.hashCode());
		result = prime * result
				+ ((examenSemiologicoDeUnPaciente == null) ? 0 : examenSemiologicoDeUnPaciente.hashCode());
		result = prime * result + ((fechaHistoriaMedica == null) ? 0 : fechaHistoriaMedica.hashCode());
		result = prime * result + ((historialDelPaciente == null) ? 0 : historialDelPaciente.hashCode());
		result = prime * result + idHistorial;
		result = prime * result
				+ ((medicacionActualDeUnPaciente == null) ? 0 : medicacionActualDeUnPaciente.hashCode());
		result = prime * result
				+ ((metodosComplementariosDeUnPaciente == null) ? 0 : metodosComplementariosDeUnPaciente.hashCode());
		result = prime * result + Float.floatToIntBits(pesoDeUnPaciente);
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
		HistorialMedico other = (HistorialMedico) obj;
		if (Float.floatToIntBits(IMCDeUnPaciente) != Float.floatToIntBits(other.IMCDeUnPaciente))
			return false;
		if (anamnesisDeUnPaciente == null) {
			if (other.anamnesisDeUnPaciente != null)
				return false;
		} else if (!anamnesisDeUnPaciente.equals(other.anamnesisDeUnPaciente))
			return false;
		if (diagnosticoPresuntivoDeUnPaciente == null) {
			if (other.diagnosticoPresuntivoDeUnPaciente != null)
				return false;
		} else if (!diagnosticoPresuntivoDeUnPaciente.equals(other.diagnosticoPresuntivoDeUnPaciente))
			return false;
		if (enfermedadesActualesDeUnPaciente == null) {
			if (other.enfermedadesActualesDeUnPaciente != null)
				return false;
		} else if (!enfermedadesActualesDeUnPaciente.equals(other.enfermedadesActualesDeUnPaciente))
			return false;
		if (epicrisisDeUnPaciente == null) {
			if (other.epicrisisDeUnPaciente != null)
				return false;
		} else if (!epicrisisDeUnPaciente.equals(other.epicrisisDeUnPaciente))
			return false;
		if (evolucionDiariaDeUnPaciente == null) {
			if (other.evolucionDiariaDeUnPaciente != null)
				return false;
		} else if (!evolucionDiariaDeUnPaciente.equals(other.evolucionDiariaDeUnPaciente))
			return false;
		if (examenFisicoDeUnPaciente == null) {
			if (other.examenFisicoDeUnPaciente != null)
				return false;
		} else if (!examenFisicoDeUnPaciente.equals(other.examenFisicoDeUnPaciente))
			return false;
		if (examenSemiologicoDeUnPaciente == null) {
			if (other.examenSemiologicoDeUnPaciente != null)
				return false;
		} else if (!examenSemiologicoDeUnPaciente.equals(other.examenSemiologicoDeUnPaciente))
			return false;
		if (fechaHistoriaMedica == null) {
			if (other.fechaHistoriaMedica != null)
				return false;
		} else if (!fechaHistoriaMedica.equals(other.fechaHistoriaMedica))
			return false;
		if (historialDelPaciente == null) {
			if (other.historialDelPaciente != null)
				return false;
		} else if (!historialDelPaciente.equals(other.historialDelPaciente))
			return false;
		if (idHistorial != other.idHistorial)
			return false;
		if (medicacionActualDeUnPaciente == null) {
			if (other.medicacionActualDeUnPaciente != null)
				return false;
		} else if (!medicacionActualDeUnPaciente.equals(other.medicacionActualDeUnPaciente))
			return false;
		if (metodosComplementariosDeUnPaciente == null) {
			if (other.metodosComplementariosDeUnPaciente != null)
				return false;
		} else if (!metodosComplementariosDeUnPaciente.equals(other.metodosComplementariosDeUnPaciente))
			return false;
		if (Float.floatToIntBits(pesoDeUnPaciente) != Float.floatToIntBits(other.pesoDeUnPaciente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HistorialMedico [idHistorial=" + idHistorial + ", anamnesisDeUnPaciente=" + anamnesisDeUnPaciente
				+ ", examenFisicoDeUnPaciente=" + examenFisicoDeUnPaciente + ", examenSemiologicoDeUnPaciente="
				+ examenSemiologicoDeUnPaciente + ", diagnosticoPresuntivoDeUnPaciente="
				+ diagnosticoPresuntivoDeUnPaciente + ", metodosComplementariosDeUnPaciente="
				+ metodosComplementariosDeUnPaciente + ", evolucionDiariaDeUnPaciente=" + evolucionDiariaDeUnPaciente
				+ ", epicrisisDeUnPaciente=" + epicrisisDeUnPaciente + ", fechaHistoriaMedica=" + fechaHistoriaMedica
				+ ", medicacionActualDeUnPaciente=" + medicacionActualDeUnPaciente
				+ ", enfermedadesActualesDeUnPaciente=" + enfermedadesActualesDeUnPaciente + ", pesoDeUnPaciente="
				+ pesoDeUnPaciente + ", IMCDeUnPaciente=" + IMCDeUnPaciente + ", historialDelPaciente="
				+ historialDelPaciente + "]";
	}

	
	
	
		
}

