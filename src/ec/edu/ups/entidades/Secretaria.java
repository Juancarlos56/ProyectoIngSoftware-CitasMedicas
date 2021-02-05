package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Secretaria
 *
 */
@Entity
//@DiscriminatorValue("S")
public class Secretaria extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;  
	
	//@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@Column(name = "id_secretaria")
	//private int idSecretaria;
	
	@Column(name = "userSecretaria")
	private String userSecretaria;
	
	@Column(name = "passwordSecretaria")
	private String passwordSecretaria;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "responsableLibroDiario")
	private List<LibroDiario> responsableLibroDiario = new ArrayList<LibroDiario>();
	
	@OneToMany( mappedBy = "secretariaAgendaCita")
	private List<AgendaCitaMedica> secretariaAgendaCita = new ArrayList<AgendaCitaMedica>();
	
	
	public Secretaria() {
		super();
	}  
	
	
	public Secretaria(String cedula, String nombre, String apellido, String lugarNacimiento,
			Calendar fechaDeNacimiento, String nacionalidad, String sexo, String email, String tipoUsuario,
			String estado, String userSecretaria, String passwordSecretaria) {
		super(cedula, nombre, apellido, lugarNacimiento, fechaDeNacimiento, nacionalidad, sexo, email, tipoUsuario,
				estado);
		//this.idSecretaria = idSecretaria;
		this.userSecretaria = userSecretaria;
		this.passwordSecretaria = passwordSecretaria;
		
	}
	
	public String getUserSecretaria() {
		return userSecretaria;
	}



	public void setUserSecretaria(String userSecretaria) {
		this.userSecretaria = userSecretaria;
	}



	public String getPasswordSecretaria() {
		return passwordSecretaria;
	}



	public void setPasswordSecretaria(String passwordSecretaria) {
		this.passwordSecretaria = passwordSecretaria;
	}



	public List<LibroDiario> getResponsableLibroDiario() {
		return responsableLibroDiario;
	}



	public void setResponsableLibroDiario(List<LibroDiario> responsableLibroDiario) {
		this.responsableLibroDiario = responsableLibroDiario;
	}



	public List<AgendaCitaMedica> getSecretariaAgendaCita() {
		return secretariaAgendaCita;
	}



	public void setSecretariaAgendaCita(List<AgendaCitaMedica> secretariaAgendaCita) {
		this.secretariaAgendaCita = secretariaAgendaCita;
	}

	
	
	public int getIdSecretaria() {
		return super.getIdPersona();
	}


	public void setIdSecretaria(int idSecretaria) {
		super.setIdPersona(idSecretaria);
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

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((passwordSecretaria == null) ? 0 : passwordSecretaria.hashCode());
		result = prime * result + ((responsableLibroDiario == null) ? 0 : responsableLibroDiario.hashCode());
		result = prime * result + ((secretariaAgendaCita == null) ? 0 : secretariaAgendaCita.hashCode());
		result = prime * result + ((userSecretaria == null) ? 0 : userSecretaria.hashCode());
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
		Secretaria other = (Secretaria) obj;
		if (passwordSecretaria == null) {
			if (other.passwordSecretaria != null)
				return false;
		} else if (!passwordSecretaria.equals(other.passwordSecretaria))
			return false;
		if (responsableLibroDiario == null) {
			if (other.responsableLibroDiario != null)
				return false;
		} else if (!responsableLibroDiario.equals(other.responsableLibroDiario))
			return false;
		if (secretariaAgendaCita == null) {
			if (other.secretariaAgendaCita != null)
				return false;
		} else if (!secretariaAgendaCita.equals(other.secretariaAgendaCita))
			return false;
		if (userSecretaria == null) {
			if (other.userSecretaria != null)
				return false;
		} else if (!userSecretaria.equals(other.userSecretaria))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Secretaria [userSecretaria=" + userSecretaria + ", passwordSecretaria=" + passwordSecretaria
				+ ", responsableLibroDiario=" + responsableLibroDiario + ", secretariaAgendaCita="
				+ secretariaAgendaCita + "]";
	}

	
}
