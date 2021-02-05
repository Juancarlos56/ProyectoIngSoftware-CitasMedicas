<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.entidades.Medico"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Cita</title>
</head>
<body>
	<c:set var="p" scope="request" value="${medicos}" />	
	
	<% PrintWriter out2= response.getWriter();%>
	
	<% List<Medico> lista = (List<Medico>) request.getAttribute("medicos"); %>
	
	
	
	<form method="POST" action="/ProyectoIngSoftware-CitasMedicas/CrearCitaMedica">		
	
		<% out.println("<select name='medico'>"); 
		
		for(int i=0;i<lista.size();i++){
			out.println("<option value='i'>"+lista.get(i).getNombre()+"</option>");
		}
		
		
		out.println("</select>");
				%>				
		
		<input type="text" id="precioCita" name="precioCita">
		<input type="text" id="tipoCita" name="tipoCita">
		
		
		
		<input type="datetime-local" id="fecha" name="fecha">
		<button type="submit" value="Crear Cita"> Crear Cita</button>
		
    </form>
    
    
</body>
</html>