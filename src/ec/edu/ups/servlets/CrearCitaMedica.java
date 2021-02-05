package ec.edu.ups.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.AgendaCitaMedicaDAO;
import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.MedicoDAO;
import ec.edu.ups.DAO.PacienteDAO;
import ec.edu.ups.DAO.SecretariaDAO;
import ec.edu.ups.entidades.AgendaCitaMedica;
import ec.edu.ups.entidades.Medico;
import ec.edu.ups.entidades.Paciente;
import ec.edu.ups.entidades.Secretaria;

/**
 * Servlet implementation class CrearCitaMedica
 */
@WebServlet("/CrearCitaMedica")
public class CrearCitaMedica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCitaMedica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		System.out.println(request.getParameter("fecha"));
		Date date = null;
		try {
			date = sdf.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			System.out.println("No se cambio la fecha");
		}
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(date);
		
		
		SecretariaDAO secretariaDAO = DAOFactory.getFactory().getSecretariaDAO();
		//Secretaria secretaria = secretariaDAO.findAll().get(Integer.parseInt(request.getParameter("secretaria")));
		Secretaria secretaria = secretariaDAO.findAll().get(0);
		
		
		MedicoDAO medicoDAO = DAOFactory.getFactory().getMedicoDAO();
		//Medico medico = medicoDAO.findAll().get(Integer.parseInt(request.getParameter("medico")));
		Medico medico = medicoDAO.findAll().get(0);
		
		
		PacienteDAO pacienteDAO = DAOFactory.getFactory().getPacienteDAO();
		//Paciente paciente = pacienteDAO.findAll().get(Integer.parseInt(request.getParameter("paciente")));
		Paciente paciente = pacienteDAO.findAll().get(0);
		
		AgendaCitaMedica cita= new AgendaCitaMedica(Calendar.getInstance(), fecha, request.getParameter("tipo"), request.getParameter("estado"), (float)40.25, secretaria, medico, paciente);
		AgendaCitaMedicaDAO agendaDAO=DAOFactory.getFactory().getAgendaCitaMedicaDAO();
		agendaDAO.create(cita);
		doGet(request, response);
	}

}
