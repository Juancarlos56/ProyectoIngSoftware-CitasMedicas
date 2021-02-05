package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.entidades.AgendaCitaMedica;
import ec.edu.ups.entidades.Paciente;

/**
 * Servlet implementation class BuscarClienteCedula
 */
@WebServlet("/BuscarClienteCedula")
public class BuscarClienteCedula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarClienteCedula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String cedula =  request.getParameter("cedula");
		String tablaDatos="";
		
		Paciente paciente = DAOFactory.getFactory().getPacienteDAO().encontrarPacientePorCedula(cedula);
		List<AgendaCitaMedica> citas = paciente.getCitasDeUnPaciente();
		
		String tablaIndex = "<table class='tg' id='tablaBuscar' style='width:95%'>"+
				"<tr>"+
					"<th class='tg-46ru'>Nombre</th>"+
					"<th class='tg-46ru'>Apellido</th>"+
					"<th class='tg-46ru'>Cedula</th>"+
					"<th class='tg-46ru'>Lugar de Nacimiento</th>"+
					"<th class='tg-46ru'>Fecha de Nacimiento</th>"+
					"<th class='tg-46ru'>Email</th>"+
					"<th class='tg-46ru'>Seleccionar</th>"+
				"</tr>";
		if(paciente !=null){
			
			
			if (citas != null && citas.size() > 0) {
				
				tablaIndex = "<table class='tg' id='tablaBuscar' style='width:95%'>"+
						"<tr>"+
							"<th class='tg-46ru'>Nombre</th>"+
							"<th class='tg-46ru'>Apellido</th>"+
							"<th class='tg-46ru'>Cedula</th>"+
							"<th class='tg-46ru'>Lugar de Nacimiento</th>"+
							"<th class='tg-46ru'>Fecha de Nacimiento</th>"+
							"<th class='tg-46ru'>Email</th>"+
							"<th class='tg-46ru'>Estado</th>"+
							"<th class='tg-46ru'>Precio</th>"+
							"<th class='tg-46ru'>Tipo de Cita</th>"+
							"<th class='tg-46ru'>Fecha de Agendacion</th>"+
							
							"<th class='tg-46ru'>Seleccionar</th>"+
						"</tr>";
				
				
				for (AgendaCitaMedica cita : citas) {
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String fechaNac = sdf.format(paciente.getFechaDeNacimiento().getTime());
					String fechaRese = sdf.format(cita.getFechaActualDeAgendaCitaMedica().getTime());
					
					tablaDatos = tablaDatos + "<tr>"+
							"<td>"+paciente.getNombre()+"</td>"+
							"<td>"+paciente.getApellido()+"</td>"+
							"<td>"+paciente.getCedula()+"</td>"+
							"<td>"+paciente.getLugarNacimiento()+"</td>"+
							"<td>"+fechaNac+"</td>"+
							"<td>"+paciente.getEmail()+"</td>"+
							"<td>"+cita.getEstadoDeAgendaCitaMedica()+"</td>"+
							"<td>"+cita.getPrecioDeAgendaCitaMedica()+"</td>"+
							"<td>"+cita.getTipoCitaDeAgendaCitaMedica()+"</td>"+
							"<td>"+fechaRese+"</td>"+
							
							"<td><input type='button' id='pedidoSeleccionado' name='pedidoSeleccionado' value='Seleccionar' onclick=\"mostrarCliente("+paciente.getIdPaciente()
								+", \'"+paciente.getNombre()+"\' , \'"+paciente.getApellido()+"\' , \'"+paciente.getCedula()+"\' , \'"+paciente.getLugarNacimiento()
								+"\' , \'"+paciente.getEmail()+"\',\'"+ paciente.getNacionalidad() +"\',"+cita.getIdAgendaCitaMedica()+", "+cita.getPrecioDeAgendaCitaMedica()
								+",\'"+cita.getTipoCitaDeAgendaCitaMedica()+"\')\"></td>"+
							"</tr>";
				}
			}else {
				tablaDatos = tablaDatos + "<tr>"+
						"<td>"+paciente.getNombre()+"</td>"+
						"<td>"+paciente.getApellido()+"</td>"+
						"<td>"+paciente.getCedula()+"</td>"+
						"<td>"+paciente.getLugarNacimiento()+"</td>"+
						"<td>"+paciente.getFechaDeNacimiento().getTime()+"</td>"+
						"<td>"+paciente.getEmail()+"</td>"+
						"<td><input type='button' id='pedidoSeleccionado' name='pedidoSeleccionado' value='Seleccionar' onclick=\"mostrarCliente("+paciente.getIdPaciente()
							+", \'"+paciente.getNombre()+"\' , \'"+paciente.getApellido()+"\' , \'"+paciente.getCedula()+"\' , \'"+paciente.getLugarNacimiento()
							+"\' , \'"+paciente.getEmail()+"\',\'"+ paciente.getNacionalidad() +"\')\"></td>"+
						"</tr>";
			}
			
			
			tablaDatos = tablaDatos + "</table> ";
		}
		tablaIndex = tablaIndex + tablaDatos;
		out.println(tablaIndex);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
