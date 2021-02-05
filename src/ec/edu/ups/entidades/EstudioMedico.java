package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EstudioMedico
 *
 */
@Entity

public class EstudioMedico implements Serializable {

	private static final long serialVersionUID = 1L;

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudioMedico")
	private int id_estudioMedico;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaTituloMedico")
	private Calendar  fechaTituloMedico;
	
	@ManyToOne
	@JoinColumn (name = "FK_Estudio_Medico") 
	private Medico estudioRealizadoPorMedico;
	
	@ManyToOne
	@JoinColumn (name = "FK_EstudioMed_Especialidad")
	private Especialidad especialidadDeEstudio;
	

	public EstudioMedico() {
		super();
	} 
	

	public EstudioMedico(int id_estudioMedico, Calendar fechaTituloMedico, Medico estudioRealizadoPorMedico,
			Especialidad especialidadDeEstudio) {
		super();
		this.id_estudioMedico = id_estudioMedico;
		this.fechaTituloMedico = fechaTituloMedico;
		this.estudioRealizadoPorMedico = estudioRealizadoPorMedico;
		this.especialidadDeEstudio = especialidadDeEstudio;
	}



	public EstudioMedico(Calendar fechaTituloMedico, Medico estudioRealizadoPorMedico,
			Especialidad especialidadDeEstudio) {
		super();
		this.fechaTituloMedico = fechaTituloMedico;
		this.estudioRealizadoPorMedico = estudioRealizadoPorMedico;
		this.especialidadDeEstudio = especialidadDeEstudio;
	}


	public int obtenerAniosExperiencia() {

		Calendar fechaTituloDelDoctor = getFechaTituloMedico();
		int anioTitulo = fechaTituloDelDoctor.get(Calendar.YEAR);
		
		Calendar fecha = new GregorianCalendar();
		int anioActual = fecha.get(Calendar.YEAR); 
		
		int aniosExperiencia = anioActual - anioTitulo;
		
		return aniosExperiencia;
	}


	public int getId_estudioMedico() {
		return id_estudioMedico;
	}


	public void setId_estudioMedico(int id_estudioMedico) {
		this.id_estudioMedico = id_estudioMedico;
	}



	public Calendar getFechaTituloMedico() {
		return fechaTituloMedico;
	}


	public void setFechaTituloMedico(Calendar fechaTituloMedico) {
		this.fechaTituloMedico = fechaTituloMedico;
	}


	public Medico getEstudioRealizadoPorMedico() {
		return estudioRealizadoPorMedico;
	}


	public void setEstudioRealizadoPorMedico(Medico estudioRealizadoPorMedico) {
		this.estudioRealizadoPorMedico = estudioRealizadoPorMedico;
	}


	public Especialidad getEspecialidadDeEstudio() {
		return especialidadDeEstudio;
	}


	public void setEspecialidadDeEstudio(Especialidad especialidadDeEstudio) {
		this.especialidadDeEstudio = especialidadDeEstudio;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especialidadDeEstudio == null) ? 0 : especialidadDeEstudio.hashCode());
		result = prime * result + ((estudioRealizadoPorMedico == null) ? 0 : estudioRealizadoPorMedico.hashCode());
		result = prime * result + ((fechaTituloMedico == null) ? 0 : fechaTituloMedico.hashCode());
		result = prime * result + id_estudioMedico;
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
		EstudioMedico other = (EstudioMedico) obj;
		if (especialidadDeEstudio == null) {
			if (other.especialidadDeEstudio != null)
				return false;
		} else if (!especialidadDeEstudio.equals(other.especialidadDeEstudio))
			return false;
		if (estudioRealizadoPorMedico == null) {
			if (other.estudioRealizadoPorMedico != null)
				return false;
		} else if (!estudioRealizadoPorMedico.equals(other.estudioRealizadoPorMedico))
			return false;
		if (fechaTituloMedico == null) {
			if (other.fechaTituloMedico != null)
				return false;
		} else if (!fechaTituloMedico.equals(other.fechaTituloMedico))
			return false;
		if (id_estudioMedico != other.id_estudioMedico)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "EstudioMedico [id_estudioMedico=" + id_estudioMedico + ", fechaTituloMedico=" + fechaTituloMedico
				+ ", estudioRealizadoPorMedico=" + estudioRealizadoPorMedico + ", especialidadDeEstudio="
				+ especialidadDeEstudio + "]";
	}

   
}
