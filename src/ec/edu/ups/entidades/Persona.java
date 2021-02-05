package ec.edu.ups.entidades;

import java.io.Serializable;

import java.util.Calendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@Table

//SINGLE_TABLE: para crear una sola tabla con identificadores unicos en una columna agregada esta contendra
// a las clases que hereden las cuales van a tener un identificador unico 
//@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
//@DiscriminatorColumn(name = "type")

//TABLE_PER_CLASS: Crea una tabla para cada de las tablas que hereden de esta clase, la entidad persona no va a tener registros 
//solo las clases que heredan contendran registros. 
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)

public class Persona implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_persona")
	private int idPersona;
	
	@Column(name = "persona_cedula", length = 255, nullable = false, unique = true) 
	private String cedula;
	
	@Column(name = "persona_nombre", length = 255, nullable = false) 
	private String nombre; 
	
	@Column(name = "persona_apellido", length = 255, nullable = false) 
	private String apellido;
	
	@Column(name = "persona_lugarNacimiento", length = 255, nullable = false) 
	private String lugarNacimiento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "persona_fechaNacimiento", length = 255, nullable = false) 
	private Calendar fechaDeNacimiento;
	
	@Column(name = "persona_nacionalidad", length = 255, nullable = false) 
	private String nacionalidad;
	
	@Column(name = "persona_sexo", length = 255, nullable = false) 
	private String sexo;
	
	@Column(name = "persona_email", length = 255, nullable = false, unique = true) 
	private String email;
	
	@Column(name = "persona_tipoUsuario", length = 255, nullable = false) 
	private String tipoUsuario;

	@Column(name = "persona_estado", length = 10, nullable = false) 
	private String estado;
	
	
	public Persona() {
		super();
	}


	public Persona(String cedula, String nombre, String apellido, String lugarNacimiento,
			Calendar fechaDeNacimiento, String nacionalidad, String sexo, String email, String tipoUsuario,
			String estado) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.lugarNacimiento = lugarNacimiento;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.sexo = sexo;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
		this.estado = estado;
	}


	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getLugarNacimiento() {
		return lugarNacimiento;
	}


	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}


	public Calendar getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}


	public void setFechaDeNacimiento(Calendar fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaDeNacimiento == null) ? 0 : fechaDeNacimiento.hashCode());
		result = prime * result + ((lugarNacimiento == null) ? 0 : lugarNacimiento.hashCode());
		result = prime * result + ((nacionalidad == null) ? 0 : nacionalidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
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
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaDeNacimiento == null) {
			if (other.fechaDeNacimiento != null)
				return false;
		} else if (!fechaDeNacimiento.equals(other.fechaDeNacimiento))
			return false;
		if (lugarNacimiento == null) {
			if (other.lugarNacimiento != null)
				return false;
		} else if (!lugarNacimiento.equals(other.lugarNacimiento))
			return false;
		if (nacionalidad == null) {
			if (other.nacionalidad != null)
				return false;
		} else if (!nacionalidad.equals(other.nacionalidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tipoUsuario == null) {
			if (other.tipoUsuario != null)
				return false;
		} else if (!tipoUsuario.equals(other.tipoUsuario))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido="
				+ apellido + ", lugarNacimiento=" + lugarNacimiento + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", nacionalidad=" + nacionalidad + ", sexo=" + sexo + ", email=" + email + ", tipoUsuario="
				+ tipoUsuario + ", estado=" + estado + "]";
	}
   
	
	
}
