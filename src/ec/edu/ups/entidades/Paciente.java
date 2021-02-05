package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Paciente
 *
 */
@Entity
//@DiscriminatorValue( value="Pac" )
public class Paciente extends Persona implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@Column(name = "id_paciente")
	//private int idPaciente;
	
	@Column(name = "tipoSangrePaciente", nullable = true)
	private String tipoSangre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "historialDelPaciente")
	private List<HistorialMedico> historialesDePaciente = new ArrayList<HistorialMedico>();

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteCitaMedica")
    private List<AgendaCitaMedica> citasDeUnPaciente=new ArrayList<AgendaCitaMedica>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteConsulta")
    private List<Consulta> consultasDeUnPaciente=new ArrayList<Consulta>();
	
	public Paciente() {
		super();
	}
	
	

	public Paciente(String cedula, String nombre, String apellido, String lugarNacimiento,
			Calendar fechaDeNacimiento, String nacionalidad, String sexo, String email, String tipoUsuario,
			String estado, String tipoSangre) {
		super(cedula, nombre, apellido, lugarNacimiento, fechaDeNacimiento, nacionalidad, sexo, email, tipoUsuario, estado);
		this.tipoSangre = tipoSangre;
		
		//this.setCedula(cedula);
		
		//this.idPaciente = idPaciente;
	}
	

	
	public int getIdPaciente() {
		return super.getIdPersona();
	}



	public void setIdPaciente(int idPaciente) {
		super.setIdPersona(idPaciente);
	}



	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}



	public List<HistorialMedico> getHistorialesDePaciente() {
		return historialesDePaciente;
	}



	public void setHistorialesDePaciente(List<HistorialMedico> historialesDePaciente) {
		this.historialesDePaciente = historialesDePaciente;
	}

	
	public void agregarHistorialDePaciente(HistorialMedico historialDePaciente) {
		this.historialesDePaciente.add(historialDePaciente);
	}


	public List<AgendaCitaMedica> getCitasDeUnPaciente() {
		return citasDeUnPaciente;
	}


	public void setCitasDeUnPaciente(List<AgendaCitaMedica> citasDeUnPaciente) {
		this.citasDeUnPaciente = citasDeUnPaciente;
	}


	public void agregarCitaPaciente(AgendaCitaMedica citaPaciente) {
		this.citasDeUnPaciente.add(citaPaciente);
	}
	
	public List<Consulta> getConsultasDeUnPaciente() {
		return consultasDeUnPaciente;
	}



	public void setConsultasDeUnPaciente(List<Consulta> consultasDeUnPaciente) {
		this.consultasDeUnPaciente = consultasDeUnPaciente;
	}

	public void agregarConsultaDeUnPaciente(Consulta consultaPaciente) {
		this.consultasDeUnPaciente.add(consultaPaciente);
	}
	
	
	public String getCedula() {
		return super.getCedula();
	}


	public void setCedula(String cedula) {
		super.setCedula(cedula);
	}


	public String getNombre() {
		return super.getNombre();
	}


	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}


	public String getApellido() {
		return super.getApellido();
	}


	public void setApellido(String apellido) {
		super.setApellido(apellido);
	}


	public String getLugarNacimiento() {
		return super.getLugarNacimiento();
	}


	public void setLugarNacimiento(String lugarNacimiento) {
		super.setLugarNacimiento(lugarNacimiento);
	}


	public Calendar getFechaDeNacimiento() {
		return super.getFechaDeNacimiento();
	}


	public void setFechaDeNacimiento(Calendar fechaDeNacimiento) {
		super.setFechaDeNacimiento(fechaDeNacimiento);
	}


	public String getNacionalidad() {
		return super.getNacionalidad();
	}


	public void setNacionalidad(String nacionalidad) {
		super.setNacionalidad(nacionalidad);
	}


	public String getSexo() {
		return super.getSexo();
	}


	public void setSexo(String sexo) {
		super.setSexo(sexo);
	}


	public String getEmail() {
		return super.getEmail();
	}


	public void setEmail(String email) {
		super.setEmail(email);
	}


	public String getTipoUsuario() {
		return super.getTipoUsuario();
	}


	public void setTipoUsuario(String tipoUsuario) {
		super.setTipoUsuario(tipoUsuario);
	}


	public String getEstado() {
		return super.getEstado();
	}


	public void setEstado(String estado) {
		super.setEstado(estado);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((citasDeUnPaciente == null) ? 0 : citasDeUnPaciente.hashCode());
		result = prime * result + ((consultasDeUnPaciente == null) ? 0 : consultasDeUnPaciente.hashCode());
		result = prime * result + ((historialesDePaciente == null) ? 0 : historialesDePaciente.hashCode());
		result = prime * result + ((tipoSangre == null) ? 0 : tipoSangre.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (citasDeUnPaciente == null) {
			if (other.citasDeUnPaciente != null)
				return false;
		} else if (!citasDeUnPaciente.equals(other.citasDeUnPaciente))
			return false;
		if (consultasDeUnPaciente == null) {
			if (other.consultasDeUnPaciente != null)
				return false;
		} else if (!consultasDeUnPaciente.equals(other.consultasDeUnPaciente))
			return false;
		if (historialesDePaciente == null) {
			if (other.historialesDePaciente != null)
				return false;
		} else if (!historialesDePaciente.equals(other.historialesDePaciente))
			return false;
		if (tipoSangre == null) {
			if (other.tipoSangre != null)
				return false;
		} else if (!tipoSangre.equals(other.tipoSangre))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Paciente [tipoSangre=" + tipoSangre + ", historialesDePaciente=" + historialesDePaciente
				+ ", citasDeUnPaciente=" + citasDeUnPaciente + ", consultasDeUnPaciente=" + consultasDeUnPaciente + "]";
	}

	
	

}
