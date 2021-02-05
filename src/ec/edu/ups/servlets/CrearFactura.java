package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.entidades.AgendaCitaMedica;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Paciente;

@WebServlet("/CrearFactura")
public class CrearFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CrearFactura() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("");
		int idCliente = 0;
		int idCita = 0;
		String tablaDatos="";
		System.out.println("codigoCita: "+request.getParameter("codigoCita"));
		System.out.println("codigoCliente: "+request.getParameter("codigoCliente"));
		try {
			idCliente =  Integer.parseInt(request.getParameter("codigoCliente"));
			idCita =  Integer.parseInt(request.getParameter("codigoCita"));
		} catch (Exception e) {
			System.out.println("Mal formato de codigos");
		}
		
		Paciente paciente = DAOFactory.getFactory().getPacienteDAO().read(idCliente);
		AgendaCitaMedica cita = DAOFactory.getFactory().getAgendaCitaMedicaDAO().read(idCita);
		
		if (paciente != null && cita != null) {
			
			if (cita.getEstadoDeAgendaCitaMedica().equals("Sin Pagar")) {
				FacturaDetalle detalle = new FacturaDetalle(1, cita.getPrecioDeAgendaCitaMedica(), "Factura por: "+cita.getTipoCitaDeAgendaCitaMedica());
				detalle.setCitasDeFacturaDetalle(cita);
				DAOFactory.getFactory().getFacturaDetalleDAO().create(detalle);
				
		
				cita.setEstadoDeAgendaCitaMedica("Por Confirmar");
				DAOFactory.getFactory().getAgendaCitaMedicaDAO().update(cita);
				
				
				out.println("La factura a sido pagada satisfactoriamente");
			}

		}else {
			out.println("No existe ese usuario ni cita");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
