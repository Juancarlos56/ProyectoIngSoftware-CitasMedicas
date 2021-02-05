package ec.edu.ups.entidades;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Consulta
 *
 */
@Entity

public class Consulta implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idConsulta")
	private int idConsulta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaActualDeLaConsulta")
	private Calendar fechaActualDeLaConsulta;
	
	@Column(name = "sintomasDelPaciente", length = 255, nullable = false)
	private String sintomasDelPaciente;
	
	@Column(name = "diagnosticoDeLaConsulta", length = 255, nullable = false)
	private String diagnosticoDeLaConsulta;
	
	@Column(name = "observacionesDeLaConsulta", length = 255, nullable = false)
	private String observacionesDeLaConsulta;
	
	@Column(name = "medicinasParaElPaciente", length = 255, nullable = false)
	private String medicinasParaElPaciente;
	
	@Column(name = "dosisParaUnPaciente", length = 255, nullable = false)
	private String dosis;
	
	
	@ManyToOne
	@JoinColumn(name = "FK_Paciente_Consulta")
	private Paciente pacienteConsulta;
	
	@ManyToOne
	@JoinColumn(name = "FK_Medico_Consulta")
	private Medico medicoConsulta;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "certificadoDeUnaConsulta")
	private Certificado certificadoMedicoParaConsulta;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenesMedicasDeUnaConsulta")
	private List<OrdenMedica> ordenesMedicasDeConsulta = new ArrayList<OrdenMedica>();
	
	
	public Consulta() {
		super();
	}

	
	
	public Consulta(int idConsulta, Calendar fechaActualDeLaConsulta, String sintomasDelPaciente,
			String diagnosticoDeLaConsulta, String observacionesDeLaConsulta, String medicinasParaElPaciente,
			String dosis, Paciente pacienteConsulta, Medico medicoConsulta, Certificado certificadoMedicoParaConsulta,
			List<OrdenMedica> ordenesMedicasDeConsulta) {
		super();
		this.idConsulta = idConsulta;
		this.fechaActualDeLaConsulta = fechaActualDeLaConsulta;
		this.sintomasDelPaciente = sintomasDelPaciente;
		this.diagnosticoDeLaConsulta = diagnosticoDeLaConsulta;
		this.observacionesDeLaConsulta = observacionesDeLaConsulta;
		this.medicinasParaElPaciente = medicinasParaElPaciente;
		this.dosis = dosis;
		this.pacienteConsulta = pacienteConsulta;
		this.medicoConsulta = medicoConsulta;
		this.certificadoMedicoParaConsulta = certificadoMedicoParaConsulta;
		this.ordenesMedicasDeConsulta = ordenesMedicasDeConsulta;
	}



	//Contructor sin codigo por autogeneracion
	public Consulta(Calendar fechaActualDeLaConsulta, String sintomasDelPaciente,
			String diagnosticoDeLaConsulta, String observacionesDeLaConsulta, String medicinasParaElPaciente,
			String dosis, Paciente pacienteConsulta, Medico medicoConsulta, Certificado certificadoMedicoParaConsulta) {
		super();
		
		this.fechaActualDeLaConsulta = fechaActualDeLaConsulta;
		this.sintomasDelPaciente = sintomasDelPaciente;
		this.diagnosticoDeLaConsulta = diagnosticoDeLaConsulta;
		this.observacionesDeLaConsulta = observacionesDeLaConsulta;
		this.medicinasParaElPaciente = medicinasParaElPaciente;
		this.dosis = dosis;
		this.pacienteConsulta = pacienteConsulta;
		this.medicoConsulta = medicoConsulta;
		this.certificadoMedicoParaConsulta = certificadoMedicoParaConsulta;
	}
	public Consulta(Calendar fechaActualDeLaConsulta, String sintomasDelPaciente,
			String diagnosticoDeLaConsulta, String observacionesDeLaConsulta, String medicinasParaElPaciente,
			String dosis, Paciente pacienteConsulta, Medico medicoConsulta) {
		super();
		
		this.fechaActualDeLaConsulta = fechaActualDeLaConsulta;
		this.sintomasDelPaciente = sintomasDelPaciente;
		this.diagnosticoDeLaConsulta = diagnosticoDeLaConsulta;
		this.observacionesDeLaConsulta = observacionesDeLaConsulta;
		this.medicinasParaElPaciente = medicinasParaElPaciente;
		this.dosis = dosis;
		this.pacienteConsulta = pacienteConsulta;
		this.medicoConsulta = medicoConsulta;		
	}


	public int getIdConsulta() {
		return idConsulta;
	}


	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}


	public Calendar getFechaActualDeLaConsulta() {
		return fechaActualDeLaConsulta;
	}


	public void setFechaActualDeLaConsulta(Calendar fechaActualDeLaConsulta) {
		this.fechaActualDeLaConsulta = fechaActualDeLaConsulta;
	}


	public String getSintomasDelPaciente() {
		return sintomasDelPaciente;
	}


	public void setSintomasDelPaciente(String sintomasDelPaciente) {
		this.sintomasDelPaciente = sintomasDelPaciente;
	}


	public String getDiagnosticoDeLaConsulta() {
		return diagnosticoDeLaConsulta;
	}


	public void setDiagnosticoDeLaConsulta(String diagnosticoDeLaConsulta) {
		this.diagnosticoDeLaConsulta = diagnosticoDeLaConsulta;
	}


	public String getObservacionesDeLaConsulta() {
		return observacionesDeLaConsulta;
	}


	public void setObservacionesDeLaConsulta(String observacionesDeLaConsulta) {
		this.observacionesDeLaConsulta = observacionesDeLaConsulta;
	}


	public String getMedicinasParaElPaciente() {
		return medicinasParaElPaciente;
	}


	public void setMedicinasParaElPaciente(String medicinasParaElPaciente) {
		this.medicinasParaElPaciente = medicinasParaElPaciente;
	}


	public String getDosis() {
		return dosis;
	}


	public void setDosis(String dosis) {
		this.dosis = dosis;
	}


	public Paciente getPacienteConsulta() {
		return pacienteConsulta;
	}


	public void setPacienteConsulta(Paciente pacienteConsulta) {
		this.pacienteConsulta = pacienteConsulta;
	}


	public Medico getMedicoConsulta() {
		return medicoConsulta;
	}


	public void setMedicoConsulta(Medico medicoConsulta) {
		this.medicoConsulta = medicoConsulta;
	}


	public Certificado getCertificadoMedicoParaConsulta() {
		return certificadoMedicoParaConsulta;
	}


	public void setCertificadoMedicoParaConsulta(Certificado certificadoMedicoParaConsulta) {
		this.certificadoMedicoParaConsulta = certificadoMedicoParaConsulta;
	}


	public List<OrdenMedica> getOrdenesMedicasDeConsulta() {
		return ordenesMedicasDeConsulta;
	}


	public void setOrdenesMedicasDeConsulta(List<OrdenMedica> ordenesMedicasDeConsulta) {
		this.ordenesMedicasDeConsulta = ordenesMedicasDeConsulta;
	}
	
	public void agregarOrdenMedica(OrdenMedica ordenMedica) {
		this.ordenesMedicasDeConsulta.add(ordenMedica);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((certificadoMedicoParaConsulta == null) ? 0 : certificadoMedicoParaConsulta.hashCode());
		result = prime * result + ((diagnosticoDeLaConsulta == null) ? 0 : diagnosticoDeLaConsulta.hashCode());
		result = prime * result + ((dosis == null) ? 0 : dosis.hashCode());
		result = prime * result + ((fechaActualDeLaConsulta == null) ? 0 : fechaActualDeLaConsulta.hashCode());
		result = prime * result + idConsulta;
		result = prime * result + ((medicinasParaElPaciente == null) ? 0 : medicinasParaElPaciente.hashCode());
		result = prime * result + ((observacionesDeLaConsulta == null) ? 0 : observacionesDeLaConsulta.hashCode());
		result = prime * result + ((ordenesMedicasDeConsulta == null) ? 0 : ordenesMedicasDeConsulta.hashCode());
		result = prime * result + ((pacienteConsulta == null) ? 0 : pacienteConsulta.hashCode());
		result = prime * result + ((sintomasDelPaciente == null) ? 0 : sintomasDelPaciente.hashCode());
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
		Consulta other = (Consulta) obj;
		if (certificadoMedicoParaConsulta == null) {
			if (other.certificadoMedicoParaConsulta != null)
				return false;
		} else if (!certificadoMedicoParaConsulta.equals(other.certificadoMedicoParaConsulta))
			return false;
		if (diagnosticoDeLaConsulta == null) {
			if (other.diagnosticoDeLaConsulta != null)
				return false;
		} else if (!diagnosticoDeLaConsulta.equals(other.diagnosticoDeLaConsulta))
			return false;
		if (dosis == null) {
			if (other.dosis != null)
				return false;
		} else if (!dosis.equals(other.dosis))
			return false;
		if (fechaActualDeLaConsulta == null) {
			if (other.fechaActualDeLaConsulta != null)
				return false;
		} else if (!fechaActualDeLaConsulta.equals(other.fechaActualDeLaConsulta))
			return false;
		if (idConsulta != other.idConsulta)
			return false;
		if (medicinasParaElPaciente == null) {
			if (other.medicinasParaElPaciente != null)
				return false;
		} else if (!medicinasParaElPaciente.equals(other.medicinasParaElPaciente))
			return false;
		if (observacionesDeLaConsulta == null) {
			if (other.observacionesDeLaConsulta != null)
				return false;
		} else if (!observacionesDeLaConsulta.equals(other.observacionesDeLaConsulta))
			return false;
		if (ordenesMedicasDeConsulta == null) {
			if (other.ordenesMedicasDeConsulta != null)
				return false;
		} else if (!ordenesMedicasDeConsulta.equals(other.ordenesMedicasDeConsulta))
			return false;
		if (pacienteConsulta == null) {
			if (other.pacienteConsulta != null)
				return false;
		} else if (!pacienteConsulta.equals(other.pacienteConsulta))
			return false;
		if (sintomasDelPaciente == null) {
			if (other.sintomasDelPaciente != null)
				return false;
		} else if (!sintomasDelPaciente.equals(other.sintomasDelPaciente))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Consulta [idConsulta=" + idConsulta + ", fechaActualDeLaConsulta=" + fechaActualDeLaConsulta
				+ ", sintomasDelPaciente=" + sintomasDelPaciente + ", diagnosticoDeLaConsulta="
				+ diagnosticoDeLaConsulta + ", observacionesDeLaConsulta=" + observacionesDeLaConsulta
				+ ", medicinasParaElPaciente=" + medicinasParaElPaciente + ", dosis=" + dosis + ", pacienteConsulta="
				+ pacienteConsulta + ", certificadoMedicoParaConsulta=" + certificadoMedicoParaConsulta
				+ ", ordenesMedicasDeConsulta=" + ordenesMedicasDeConsulta + "]";
	}

	

}
