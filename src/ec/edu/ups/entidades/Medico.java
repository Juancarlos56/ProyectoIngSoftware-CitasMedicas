package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Medico
 *
 */
@Entity
//@DiscriminatorValue( value="Med" )
public class Medico extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;  
	
	//@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@Column(name = "id_medico")
	//private int idMedico;
	
	@Column(name = "userMedico")
	private String userMedico;
	
	@Column(name = "passwordMedico")
	private String passwordMedico;
	
	@Column(name = "urlFotoMedico")
	private String urlFotoMedico;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "estudioRealizadoPorMedico")
	private List<EstudioMedico> estudiosDeUnMedico = new ArrayList<EstudioMedico>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoConsulta")
	private List<Consulta> consultasDeUnMedico = new ArrayList<Consulta>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioDisponiblePorMedico")
	private List<HorarioMedico> horariosDeUnMedico = new ArrayList<HorarioMedico>();

	@OneToMany(mappedBy = "medicoParaCitaMedica", cascade = CascadeType.ALL)
	private List<AgendaCitaMedica> citasMedicasDeUnDoctor = new ArrayList<AgendaCitaMedica>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facturasSalarioDeMedico")
	private List<FacturaSalario> facturasSalarioDeUnDoctor = new ArrayList<FacturaSalario>();

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private List<FacturaCabecera> facturasCabeceraDeUnMedico=new ArrayList<FacturaCabecera>();
	
	public Medico() {
		super();
	}   
	

	public Medico(String cedula, String nombre, String apellido, String lugarNacimiento,
			Calendar fechaDeNacimiento, String nacionalidad, String sexo, String email, String tipoUsuario,
			String estado, String userMedico, String passwordMedico, String urlFotoMedico) {
		
		super(cedula, nombre, apellido, lugarNacimiento, fechaDeNacimiento, nacionalidad, sexo, email, tipoUsuario, estado);
		
		this.userMedico = userMedico;
		this.passwordMedico = passwordMedico;
		this.urlFotoMedico = urlFotoMedico;
	}



	public int getIdMedico() {
		return super.getIdPersona();
	}


	public void setIdMedico(int idMedico) {
		super.setIdPersona(idMedico);
	}


	public String getUserMedico() {
		return userMedico;
	}

	
	public void setUserMedico(String userMedico) {
		this.userMedico = userMedico;
	}

	
	public String getPasswordMedico() {
		return passwordMedico;
	}

	
	public void setPasswordMedico(String passwordMedico) {
		this.passwordMedico = passwordMedico;
	}

	
	public String getUrlFotoMedico() {
		return urlFotoMedico;
	}


	public void setUrlFotoMedico(String urlFotoMedico) {
		this.urlFotoMedico = urlFotoMedico;
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
		return getApellido();
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



	public List<EstudioMedico> getEstudiosDeUnMedico() {
		return estudiosDeUnMedico;
	}


	public void setEstudiosDeUnMedico(List<EstudioMedico> estudiosDeUnMedico) {
		this.estudiosDeUnMedico = estudiosDeUnMedico;
	}

	
	public void agregarEstudioMedico(EstudioMedico estudioMedico) {
		this.estudiosDeUnMedico.add(estudioMedico);
	}

	
	public List<Consulta> getConsultasDeUnMedico() {
		return consultasDeUnMedico;
	}

	
	public void setConsultasDeUnMedico(List<Consulta> consultasDeUnMedico) {
		this.consultasDeUnMedico = consultasDeUnMedico;
	}

	
	
	public void agregarConsultasAMedico(Consulta consultaMedico) {
		this.consultasDeUnMedico.add(consultaMedico);
	}
	

	public List<HorarioMedico> getHorariosDeUnMedico() {
		return horariosDeUnMedico;
	}

	
	public void setHorariosDeUnMedico(List<HorarioMedico> horariosDeUnMedico) {
		this.horariosDeUnMedico = horariosDeUnMedico;
	}

	
	public void agregarHorarioMedico(HorarioMedico horarioMedico) {
		this.horariosDeUnMedico.add(horarioMedico);
	}
	
	
	public List<AgendaCitaMedica> getCitasMedicasDeUnDoctor() {
		return citasMedicasDeUnDoctor;
	}



	public void setCitasMedicasDeUnDoctor(List<AgendaCitaMedica> citasMedicasDeUnDoctor) {
		this.citasMedicasDeUnDoctor = citasMedicasDeUnDoctor;
	}

	public void agregarCitaMedicaADoctor(AgendaCitaMedica citaMedica) {
		this.citasMedicasDeUnDoctor.add(citaMedica);
	}



	public List<FacturaSalario> getFacturasSalarioDeUnDoctor() {
		return facturasSalarioDeUnDoctor;
	}



	public void agregarFacturaSalarioADoctor(FacturaSalario facturaSalario) {
		this.facturasSalarioDeUnDoctor.add(facturaSalario);
	}

	
	public void setFacturasSalarioDeUnDoctor(List<FacturaSalario> facturasSalarioDeUnDoctor) {
		this.facturasSalarioDeUnDoctor = facturasSalarioDeUnDoctor;
	}

	
	public List<FacturaCabecera> getFacturasCabeceraDeUnMedico() {
		return facturasCabeceraDeUnMedico;
	}



	public void setFacturasCabeceraDeUnMedico(List<FacturaCabecera> facturasCabeceraDeUnMedico) {
		this.facturasCabeceraDeUnMedico = facturasCabeceraDeUnMedico;
	}


	public void agregarFacturaCabeceraAMedico(FacturaCabecera facturaCabecera) {
		this.facturasCabeceraDeUnMedico.add(facturaCabecera);
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((citasMedicasDeUnDoctor == null) ? 0 : citasMedicasDeUnDoctor.hashCode());
		result = prime * result + ((consultasDeUnMedico == null) ? 0 : consultasDeUnMedico.hashCode());
		result = prime * result + ((facturasSalarioDeUnDoctor == null) ? 0 : facturasSalarioDeUnDoctor.hashCode());
		result = prime * result + ((passwordMedico == null) ? 0 : passwordMedico.hashCode());
		result = prime * result + ((urlFotoMedico == null) ? 0 : urlFotoMedico.hashCode());
		result = prime * result + ((userMedico == null) ? 0 : userMedico.hashCode());
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
		Medico other = (Medico) obj;
		if (citasMedicasDeUnDoctor == null) {
			if (other.citasMedicasDeUnDoctor != null)
				return false;
		} else if (!citasMedicasDeUnDoctor.equals(other.citasMedicasDeUnDoctor))
			return false;
		if (consultasDeUnMedico == null) {
			if (other.consultasDeUnMedico != null)
				return false;
		} else if (!consultasDeUnMedico.equals(other.consultasDeUnMedico))
			return false;
		if (facturasSalarioDeUnDoctor == null) {
			if (other.facturasSalarioDeUnDoctor != null)
				return false;
		} else if (!facturasSalarioDeUnDoctor.equals(other.facturasSalarioDeUnDoctor))
			return false;
		if (passwordMedico == null) {
			if (other.passwordMedico != null)
				return false;
		} else if (!passwordMedico.equals(other.passwordMedico))
			return false;
		if (urlFotoMedico == null) {
			if (other.urlFotoMedico != null)
				return false;
		} else if (!urlFotoMedico.equals(other.urlFotoMedico))
			return false;
		if (userMedico == null) {
			if (other.userMedico != null)
				return false;
		} else if (!userMedico.equals(other.userMedico))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Medico [userMedico=" + userMedico + ", passwordMedico=" + passwordMedico + ", urlFotoMedico="
				+ urlFotoMedico + ", consultasDeUnMedico=" + consultasDeUnMedico + ", citasMedicasDeUnDoctor="
				+ citasMedicasDeUnDoctor + ", facturasSalarioDeUnDoctor=" + facturasSalarioDeUnDoctor +
				", facturasCabeceraDoctor=" + facturasCabeceraDeUnMedico +"]";
	}
	
	
	
	

}
