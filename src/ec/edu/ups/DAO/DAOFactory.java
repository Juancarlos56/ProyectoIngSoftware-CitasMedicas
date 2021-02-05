package ec.edu.ups.DAO;

import ec.edu.ups.jpa.JPADAOFactory;

public abstract class DAOFactory {

	protected static DAOFactory factory = new JPADAOFactory();

	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract ActivoDAO getActviosDAO();
	
	public abstract AgendaCitaMedicaDAO getAgendaCitaMedicaDAO();
	
	public abstract CajaDiariaDAO getCajaDiariaDAO();
	
	public abstract CertificadoDAO getCertificadoDAO();
	
	public abstract ConsultaDAO getConsultaDAO();
	
	public abstract EspecialidadDAO getEspecialidadDAO();
	
	public abstract EstudioMedicoDAO getEstudioMedicoDAO();
	
	public abstract FacturaCabeceraDAO getFacturaCabeceraDAO();
	
	public abstract FacturaCompraDAO getFacturaCompraDAO();
	
	public abstract FacturaDetalleDAO getFacturaDetalleDAO();
	
	public abstract FacturaGeneralDAO getFacturaGeneralDAO();
	
	public abstract FacturaSalarioDAO getFacturaSalarioDAO();
	
	public abstract HistorialMedicoDAO getHistorialMedicoDAO();
	
	public abstract HorarioMedicoDAO getHorarioMedicoDAO();
	
	public abstract LibroDiarioDAO getLibroDiarioDAO();
	
	public abstract MedicoDAO getMedicoDAO();
	
	public abstract OrdenMedicaDAO getOrdenMedicaDAO();
	
	public abstract PacienteDAO getPacienteDAO();
	
	public abstract PasivoDAO getPasivoDAO();
	
	public abstract PersonaDAO getPersonaDAO();
	
	public abstract SecretariaDAO getSecretariaDAO();
	
	
	
}
