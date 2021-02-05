package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Activo
 *
 */
@Entity

public class Activo implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activoId")
	private int activoId;
	
	@Column(name = "valorActivoCompras", nullable = true)
	private double valorActivoCompras;
	
	@Column(name = "valorActivoCitas", nullable = true)
	private double valorActivoCitas;
	
	//Fijo o circulante
	@Column(name = "tipoActivo", length = 11, nullable = false)
	private String tipoActivo;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "activoCompra")
    private List<FacturaCompra> activosCompraEmpresa=new ArrayList<FacturaCompra>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "activoCobroCitaMedica")
    private List<FacturaCabecera> activosCobrosCitaMedica=new ArrayList<FacturaCabecera>();
	
	@ManyToOne
	@JoinColumn(name = "FK_libroDiario_Activo")
	private LibroDiario activoDelibroDiario; 
	
	public Activo() {
		super();
	}
	

	public Activo(int activoId, float valorActivoCompras, float valorActivoCitas, String tipoActivo,
			LibroDiario activoDelibroDiario) {
		super();
		this.activoId = activoId;
		this.valorActivoCompras = valorActivoCompras;
		this.valorActivoCitas = valorActivoCitas;
		this.tipoActivo = tipoActivo;
		this.activoDelibroDiario = activoDelibroDiario;
	}


	public Activo(float valorActivoCompras, float valorActivoCitas, String tipoActivo,
			LibroDiario activoDelibroDiario) {
		super();
		this.valorActivoCompras = valorActivoCompras;
		this.valorActivoCitas = valorActivoCitas;
		this.tipoActivo = tipoActivo;
		this.activoDelibroDiario = activoDelibroDiario;
	}
	public Activo(float valorActivoCompras, float valorActivoCitas, String tipoActivo) {
		super();
		this.valorActivoCompras = valorActivoCompras;
		this.valorActivoCitas = valorActivoCitas;
		this.tipoActivo = tipoActivo;		
	}

	//Metodos propios de la clase Activo
	
	public double calcularValorActivoCitas() {
		double valorCitas = 0.0; 
		List<FacturaCabecera> facturasCitas = getActivosCobrosCitaMedica();
		for (FacturaCabecera facturaCabecera : facturasCitas) {
			valorCitas = valorCitas +facturaCabecera.getTotal();
		}
		return valorCitas;
	}
	
	
	public double calcularValorActivoCompras() {
		double valorCompras = 0.0; 
		List<FacturaCompra> facturasCompras = getActivosCompraEmpresa();
		for (FacturaCompra facturaCompra : facturasCompras) {
			valorCompras = valorCompras + facturaCompra.getTotal();
		}
		return valorCompras;
	}
	
	//Metodos getters y setters
	public int getActivoId() {
		return activoId;
	}

	public void setActivoId(int activoId) {
		this.activoId = activoId;
	}

	

	public double getValorActivoCompras() {
		return valorActivoCompras;
	}


	public void setValorActivoCompras(double valorActivoCompras) {
		this.valorActivoCompras = valorActivoCompras;
	}


	public double getValorActivoCitas() {
		return valorActivoCitas;
	}


	public void setValorActivoCitas(double d) {
		this.valorActivoCitas = d;
	}


	public String getTipoActivo() {
		return tipoActivo;
	}

	public void setTipoActivo(String tipoActivo) {
		this.tipoActivo = tipoActivo;
	}

	public List<FacturaCompra> getActivosCompraEmpresa() {
		return activosCompraEmpresa;
	}

	public void setActivosCompraEmpresa(List<FacturaCompra> activosCompraEmpresa) {
		this.activosCompraEmpresa = activosCompraEmpresa;
	}
	
	public void agregarActivoCompraEmpresa(FacturaCompra activoCompraEmpresa) {
		this.activosCompraEmpresa.add(activoCompraEmpresa);
	}

	public List<FacturaCabecera> getActivosCobrosCitaMedica() {
		return activosCobrosCitaMedica;
	}

	public void setActivosCobrosCitaMedica(List<FacturaCabecera> activosCobrosCitaMedica) {
		this.activosCobrosCitaMedica = activosCobrosCitaMedica;
	}
	
	public void agregarActivoCobroCitaMedica(FacturaCabecera activoCobro) {
		this.activosCobrosCitaMedica.add(activoCobro);
	}

	public LibroDiario getActivoDelibroDiario() {
		return activoDelibroDiario;
	}

	public void setActivoDelibroDiario(LibroDiario activoDelibroDiario) {
		this.activoDelibroDiario = activoDelibroDiario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activoDelibroDiario == null) ? 0 : activoDelibroDiario.hashCode());
		result = prime * result + activoId;
		result = prime * result + ((activosCobrosCitaMedica == null) ? 0 : activosCobrosCitaMedica.hashCode());
		result = prime * result + ((activosCompraEmpresa == null) ? 0 : activosCompraEmpresa.hashCode());
		result = prime * result + ((tipoActivo == null) ? 0 : tipoActivo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorActivoCitas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorActivoCompras);
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
		Activo other = (Activo) obj;
		if (activoDelibroDiario == null) {
			if (other.activoDelibroDiario != null)
				return false;
		} else if (!activoDelibroDiario.equals(other.activoDelibroDiario))
			return false;
		if (activoId != other.activoId)
			return false;
		if (activosCobrosCitaMedica == null) {
			if (other.activosCobrosCitaMedica != null)
				return false;
		} else if (!activosCobrosCitaMedica.equals(other.activosCobrosCitaMedica))
			return false;
		if (activosCompraEmpresa == null) {
			if (other.activosCompraEmpresa != null)
				return false;
		} else if (!activosCompraEmpresa.equals(other.activosCompraEmpresa))
			return false;
		if (tipoActivo == null) {
			if (other.tipoActivo != null)
				return false;
		} else if (!tipoActivo.equals(other.tipoActivo))
			return false;
		if (Double.doubleToLongBits(valorActivoCitas) != Double.doubleToLongBits(other.valorActivoCitas))
			return false;
		if (Double.doubleToLongBits(valorActivoCompras) != Double.doubleToLongBits(other.valorActivoCompras))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Activo [activoId=" + activoId + ", valorActivoCompras=" + valorActivoCompras + ", valorActivoCitas="
				+ valorActivoCitas + ", tipoActivo=" + tipoActivo + ", activosCompraEmpresa=" + activosCompraEmpresa
				+ ", activosCobrosCitaMedica=" + activosCobrosCitaMedica + ", activoDelibroDiario="
				+ activoDelibroDiario + "]";
	}

	
	
	
   
}
