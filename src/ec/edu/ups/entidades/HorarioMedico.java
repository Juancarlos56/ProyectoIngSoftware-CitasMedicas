package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Horario_Medico
 *
 */
@Entity

public class HorarioMedico implements Serializable {

	 
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_horarioMedico")
	private int id_horarioMedico;
	
	@Column(name = "diaHorarioMedico")
	private int diaHorarioMedico;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horaInicioHorarioMedico")
	private Calendar horaInicioHorarioMedico;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horaFinHorarioMedico")
	private Calendar horaFinHorarioMedico;
	
	@Column(name = "estadoHorarioMedico")
	private String estadoHorarioMedico;
	
	@ManyToOne 
	@JoinColumn (name = "FK_Horario_Medico")
	private Medico horarioDisponiblePorMedico;
	

	
	public HorarioMedico() {
		super();
	}   

	
	
	
	public HorarioMedico(int id_horarioMedico, int diaHorarioMedico,
			Calendar horaInicioHorarioMedico, Calendar horaFinHorarioMedico,
			String estadoHorarioMedico, Medico horarioDisponiblePorMedico) {
		super();
		this.id_horarioMedico = id_horarioMedico;
		this.diaHorarioMedico = diaHorarioMedico;
		this.horaInicioHorarioMedico = horaInicioHorarioMedico;
		this.horaFinHorarioMedico = horaFinHorarioMedico;
		this.estadoHorarioMedico = estadoHorarioMedico;
		this.horarioDisponiblePorMedico = horarioDisponiblePorMedico;
	}

	
	

	public HorarioMedico(int diaHorarioMedico, Calendar horaInicioHorarioMedico, Calendar horaFinHorarioMedico,
			String estadoHorarioMedico, Medico horarioDisponiblePorMedico) {
		super();
		this.diaHorarioMedico = diaHorarioMedico;
		this.horaInicioHorarioMedico = horaInicioHorarioMedico;
		this.horaFinHorarioMedico = horaFinHorarioMedico;
		this.estadoHorarioMedico = estadoHorarioMedico;
		this.horarioDisponiblePorMedico = horarioDisponiblePorMedico;
	}



	//Metodos propios de la clase HorarioMedico

	public HorarioMedico obtenerHorarioPorDia(String dia) {
		switch (dia) {
		case "Lunes": {
			
		}
		case "Martes": {
			
		
		}
		case "Miercoles": {
			
			
		}
		case "Jueves": {
			
			
		}
		case "Viernes": {
			
			
		}
		case "Sabado": {
			
			
		}
		case "Domingo": {
			
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + dia);
		}
	}

	
	//Metodos getters and setters
	
	public int getId_horarioMedico() {
		return id_horarioMedico;
	}

	public void setId_horarioMedico(int id_horarioMedico) {
		this.id_horarioMedico = id_horarioMedico;
	}

	public int getDiaHorarioMedico() {
		return diaHorarioMedico;
	}

	public void setDiaHorarioMedico(int diaHorarioMedico) {
		this.diaHorarioMedico = diaHorarioMedico;
	}

	public Calendar getHoraInicioHorarioMedico() {
		return horaInicioHorarioMedico;
	}

	public void setHoraInicioHorarioMedico(Calendar horaInicioHorarioMedico) {
		this.horaInicioHorarioMedico = horaInicioHorarioMedico;
	}

	public Calendar getHoraFinHorarioMedico() {
		return horaFinHorarioMedico;
	}

	public void setHoraFinHorarioMedico(Calendar horaFinHorarioMedico) {
		this.horaFinHorarioMedico = horaFinHorarioMedico;
	}

	public String getEstadoHorarioMedico() {
		return estadoHorarioMedico;
	}

	public void setEstadoHorarioMedico(String estadoHorarioMedico) {
		this.estadoHorarioMedico = estadoHorarioMedico;
	}

	public Medico getHorarioDisponiblePorMedico() {
		return horarioDisponiblePorMedico;
	}

	public void setHorarioDisponiblePorMedico(Medico horarioDisponiblePorMedico) {
		this.horarioDisponiblePorMedico = horarioDisponiblePorMedico;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoHorarioMedico == null) ? 0 : estadoHorarioMedico.hashCode());
		result = prime * result + ((horaFinHorarioMedico == null) ? 0 : horaFinHorarioMedico.hashCode());
		result = prime * result + ((horaInicioHorarioMedico == null) ? 0 : horaInicioHorarioMedico.hashCode());
		result = prime * result + ((horarioDisponiblePorMedico == null) ? 0 : horarioDisponiblePorMedico.hashCode());
		result = prime * result + id_horarioMedico;
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
		HorarioMedico other = (HorarioMedico) obj;
		if (estadoHorarioMedico == null) {
			if (other.estadoHorarioMedico != null)
				return false;
		} else if (!estadoHorarioMedico.equals(other.estadoHorarioMedico))
			return false;
		if (horaFinHorarioMedico == null) {
			if (other.horaFinHorarioMedico != null)
				return false;
		} else if (!horaFinHorarioMedico.equals(other.horaFinHorarioMedico))
			return false;
		if (horaInicioHorarioMedico == null) {
			if (other.horaInicioHorarioMedico != null)
				return false;
		} else if (!horaInicioHorarioMedico.equals(other.horaInicioHorarioMedico))
			return false;
		if (horarioDisponiblePorMedico == null) {
			if (other.horarioDisponiblePorMedico != null)
				return false;
		} else if (!horarioDisponiblePorMedico.equals(other.horarioDisponiblePorMedico))
			return false;
		if (id_horarioMedico != other.id_horarioMedico)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Horario_Medico [id_horarioMedico=" + id_horarioMedico + ", diaHorarioMedico=" + diaHorarioMedico
				+ ", horaInicioHorarioMedico=" + horaInicioHorarioMedico + ", horaFinHorarioMedico="
				+ horaFinHorarioMedico + ", estadoHorarioMedico=" + estadoHorarioMedico
				+ ", horarioDisponiblePorMedico=" + horarioDisponiblePorMedico + "]";
	}
	
	
	
	
   
}
