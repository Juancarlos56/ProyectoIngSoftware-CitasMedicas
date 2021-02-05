package ec.edu.ups.jpa;

import ec.edu.ups.DAO.ActivoDAO;
import ec.edu.ups.DAO.AgendaCitaMedicaDAO;
import ec.edu.ups.DAO.CajaDiariaDAO;
import ec.edu.ups.DAO.CertificadoDAO;
import ec.edu.ups.DAO.ConsultaDAO;
import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.EspecialidadDAO;
import ec.edu.ups.DAO.EstudioMedicoDAO;
import ec.edu.ups.DAO.FacturaCabeceraDAO;
import ec.edu.ups.DAO.FacturaCompraDAO;
import ec.edu.ups.DAO.FacturaDetalleDAO;
import ec.edu.ups.DAO.FacturaGeneralDAO;
import ec.edu.ups.DAO.FacturaSalarioDAO;
import ec.edu.ups.DAO.HistorialMedicoDAO;
import ec.edu.ups.DAO.HorarioMedicoDAO;
import ec.edu.ups.DAO.LibroDiarioDAO;
import ec.edu.ups.DAO.MedicoDAO;
import ec.edu.ups.DAO.OrdenMedicaDAO;
import ec.edu.ups.DAO.PacienteDAO;
import ec.edu.ups.DAO.PasivoDAO;
import ec.edu.ups.DAO.PersonaDAO;
import ec.edu.ups.DAO.SecretariaDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public ActivoDAO getActviosDAO() {
		// TODO Auto-generated method stub
		return new JPAActivoDAO();
	}

	@Override
	public AgendaCitaMedicaDAO getAgendaCitaMedicaDAO() {
		return new JPAAgendaCitaMedicaDAO();
	}

	@Override
	public CajaDiariaDAO getCajaDiariaDAO() {
		return new JPACajaDiariaDAO();
	}

	@Override
	public CertificadoDAO getCertificadoDAO() {
		return new JPACertificadoDAO();
	}

	@Override
	public ConsultaDAO getConsultaDAO() {
		return new JPAConsultaDAO();
	}

	@Override
	public EspecialidadDAO getEspecialidadDAO() {
		return new JPAEspecialidadDAO();
	}

	@Override
	public EstudioMedicoDAO getEstudioMedicoDAO() {
		return new JPAEstudioMedicoDAO();
	}

	@Override
	public FacturaCabeceraDAO getFacturaCabeceraDAO() {
		return new JPAFacturaCabeceraDAO();
	}

	@Override
	public FacturaCompraDAO getFacturaCompraDAO() {
		return new JPAFacturaCompraDAO();
	}

	@Override
	public FacturaDetalleDAO getFacturaDetalleDAO() {
		return new JPAFacturaDetalleDAO();
	}

	@Override
	public FacturaGeneralDAO getFacturaGeneralDAO() {
		return null;
	}

	@Override
	public FacturaSalarioDAO getFacturaSalarioDAO() {
		return new JPAFacturaSalario();
	}

	@Override
	public HistorialMedicoDAO getHistorialMedicoDAO() {
		return new JPAHistorialMedicoDAO();
	}

	@Override
	public HorarioMedicoDAO getHorarioMedicoDAO() {
		return new JPAHorarioMedicoDAO();
	}

	@Override
	public LibroDiarioDAO getLibroDiarioDAO() {
		return new JPALibroDiarioDAO();
	}

	@Override
	public MedicoDAO getMedicoDAO() {
		return new JPAMedicoDAO();
	}

	@Override
	public OrdenMedicaDAO getOrdenMedicaDAO() {
		return new JPAOrdenMedicaDAO();
	}

	@Override
	public PacienteDAO getPacienteDAO() {
		return new JPAPacienteDAO();
	}

	@Override
	public PasivoDAO getPasivoDAO() {
		return new JPAPasivoDAO();
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

	@Override
	public SecretariaDAO getSecretariaDAO() {
		return new JPASecretariaDAO();
	}

}
