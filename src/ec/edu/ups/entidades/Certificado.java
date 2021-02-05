package ec.edu.ups.entidades;

import java.io.Serializable;

import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Certificado
 *
 */
@Entity

public class Certificado implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCertificado")
	private int idCertificado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaEnvioDeCerficado")
	private Calendar fechaEnvioDeCerficado;
	
	@Column(name = "numeroDiasDeReposoParaPaciente")
	private int numeroDiasDeReposoParaPaciente;
	
	@Column(name = "descripcionParaCertificado")
	private String descripcionParaCertificado;
	
	@OneToOne
    @JoinColumn(name = "FK_Consulta_Certificado")
    private Consulta certificadoDeUnaConsulta;

	public Certificado() {
		super();
	}

	public Certificado(int idCertificado, Calendar fechaEnvioDeCerficado, int numeroDiasDeReposoParaPaciente,
			String descripcionParaCertificado, Consulta certificadoDeUnaConsulta) {
		super();
		this.idCertificado = idCertificado;
		this.fechaEnvioDeCerficado = fechaEnvioDeCerficado;
		this.numeroDiasDeReposoParaPaciente = numeroDiasDeReposoParaPaciente;
		this.descripcionParaCertificado = descripcionParaCertificado;
		this.certificadoDeUnaConsulta = certificadoDeUnaConsulta;
	}

	//Contructor sin codigo por autogeneracion
	public Certificado(Calendar fechaEnvioDeCerficado, int numeroDiasDeReposoParaPaciente,
			String descripcionParaCertificado, Consulta certificadoDeUnaConsulta) {
		super();
		this.fechaEnvioDeCerficado = fechaEnvioDeCerficado;
		this.numeroDiasDeReposoParaPaciente = numeroDiasDeReposoParaPaciente;
		this.descripcionParaCertificado = descripcionParaCertificado;
		this.certificadoDeUnaConsulta = certificadoDeUnaConsulta;
	}

	//Metodos propios de la clase Certificado
	
	public Calendar calcularFechaFinal() {
		Calendar fechaEnvio = getFechaEnvioDeCerficado();
		Calendar fechafinal = Calendar.getInstance(); 
		fechafinal.add(fechaEnvio.get(Calendar.DATE), getNumeroDiasDeReposoParaPaciente());
		return fechafinal;
	}
	
	
	//Metodos getters y setters
	public int getIdCertificado() {
		return idCertificado;
	}

	public void setIdCertificado(int idCertificado) {
		this.idCertificado = idCertificado;
	}

	public Calendar getFechaEnvioDeCerficado() {
		return fechaEnvioDeCerficado;
	}

	public void setFechaEnvioDeCerficado(Calendar fechaEnvioDeCerficado) {
		this.fechaEnvioDeCerficado = fechaEnvioDeCerficado;
	}

	public int getNumeroDiasDeReposoParaPaciente() {
		return numeroDiasDeReposoParaPaciente;
	}

	public void setNumeroDiasDeReposoParaPaciente(int numeroDiasDeReposoParaPaciente) {
		this.numeroDiasDeReposoParaPaciente = numeroDiasDeReposoParaPaciente;
	}

	public String getDescripcionParaCertificado() {
		return descripcionParaCertificado;
	}

	public void setDescripcionParaCertificado(String descripcionParaCertificado) {
		this.descripcionParaCertificado = descripcionParaCertificado;
	}

	public Consulta getCertificadoDeUnaConsulta() {
		return certificadoDeUnaConsulta;
	}

	public void setCertificadoDeUnaConsulta(Consulta certificadoDeUnaConsulta) {
		this.certificadoDeUnaConsulta = certificadoDeUnaConsulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certificadoDeUnaConsulta == null) ? 0 : certificadoDeUnaConsulta.hashCode());
		result = prime * result + ((descripcionParaCertificado == null) ? 0 : descripcionParaCertificado.hashCode());
		result = prime * result + ((fechaEnvioDeCerficado == null) ? 0 : fechaEnvioDeCerficado.hashCode());
		result = prime * result + idCertificado;
		result = prime * result + numeroDiasDeReposoParaPaciente;
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
		Certificado other = (Certificado) obj;
		if (certificadoDeUnaConsulta == null) {
			if (other.certificadoDeUnaConsulta != null)
				return false;
		} else if (!certificadoDeUnaConsulta.equals(other.certificadoDeUnaConsulta))
			return false;
		if (descripcionParaCertificado == null) {
			if (other.descripcionParaCertificado != null)
				return false;
		} else if (!descripcionParaCertificado.equals(other.descripcionParaCertificado))
			return false;
		if (fechaEnvioDeCerficado == null) {
			if (other.fechaEnvioDeCerficado != null)
				return false;
		} else if (!fechaEnvioDeCerficado.equals(other.fechaEnvioDeCerficado))
			return false;
		if (idCertificado != other.idCertificado)
			return false;
		if (numeroDiasDeReposoParaPaciente != other.numeroDiasDeReposoParaPaciente)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Certificado [idCertificado=" + idCertificado + ", fechaEnvioDeCerficado=" + fechaEnvioDeCerficado
				+ ", numeroDiasDeReposoParaPaciente=" + numeroDiasDeReposoParaPaciente + ", descripcionParaCertificado="
				+ descripcionParaCertificado + ", certificadoDeUnaConsulta=" + certificadoDeUnaConsulta + "]";
	}
	
	
	
	
   
}
