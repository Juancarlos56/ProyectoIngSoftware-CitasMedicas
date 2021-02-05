<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="../../../templates/javascript/facturaCabeceraJS.js" type="text/javascript"></script>
</head>
<body>
		<% 
	 	//Usuario usuario = (Usuario)request.getAttribute("usuario");
	 	//Empresa empresa = usuario.getEmpresa();
	 	%>

		<article class="Buscar Cliente">
           
            <label for="busqueda" class="Subtitulos" style="font-size: 15px; text-align: left; width: 10%;">Buscar por:</label>
            <select name="busqueda" id="busquedaSel" onclick="return opcionBusqueda(value)">
                <option value="Cedula" id="buscarCedula"  >Cédula</option>
                <option value="Nombre" id="buscarNombre"  >Nombre</option>
            </select>
            
            <!--AJAX-->
            <form id="Formulario01" onsubmit="return buscarPorCedula()" style="display: inline;">
                <input type="text" id="cedula" name="cedula" value="" placeholder="Ingrese Cedula" >
                <input type="button" id="buscarCed" name="buscarCed" value="Buscar" onclick="buscarPorCedula()">
            </form>

            <form id="Formulario02" onsubmit="return buscarPorCorreo()" style="display: none;">
                
                <input type="text" id="nombreClienteBuscar" name="nombreClienteBuscar" value="" placeholder="Ingrese Nombre" >
                <input type="button" id="buscar" name="buscar" value="Buscar" onclick="buscarPorNombre()">
            </form>
            
            <div class="separador"> </div>
            <div id="informacion"><b>Datos de la persona</b></div>
			
			<!-- Formulario para cliente -->
		
            <input class="sepBot" type="text" id="codigoCliente" name="nombreProducto" value="" style="display: none;" />
            <br>
	        <label for="nombreClienteLabel" id="nomPro" style="margin-right: 50px;" >Nombre:</label>
            <input class="sepBot" type="text" id="nombreCliente" name="nombreCliente" value="" readonly />
            <br>
            
	        <label for="apellidoClienteLabel" id="apellido" style="margin-right: 50px;" >Apellido:</label>
            <input class="sepBot" type="text" id="apellidoCliente" name="apellidoCliente" value="" readonly />
            <br>
	       	
       		<label for="cedulaClienteLabel" id="cedula" style="margin-right: 50px;" >Cedula:</label>
            <input class="sepBot" type="text" id="cedulaCliente" name="cedulaCliente" value="" readonly />
            <br>
            
            <label for="lugarNacimientoLabel" id="lugar" style="margin-right: 50px;" > Lugar de Nacimiento:  </label>
            <input class="sepBot" type="text" id="lugarNacimiento" name="lugarNacimiento" value="" readonly/>
            <br>
            
            
            <label for="emailClienteLabel" id="totalped" style="margin-right: 50px;" >Email:   </label>
            <input class="sepBot" type="email" id="emailCliente" name="emailCliente" value="" readonly/>
            <br>
			
			
			<label for="nacionlidadClienteLabel" id="totalped" style="margin-right: 50px;" >Nacionalidad:   </label>
            <input class="sepBot" type="text" id="nacionlidadCliente" name="nacionlidadCliente" value="" readonly/>
            <br>
			
        </article>
        
        
        
       
	
 	<form action="" class="nuevaCompra" id="formularioRealizarPedido" method="POST" >
			
	</form>
</body>
</html>