/**
 * 
 */


function opcionBusqueda(valor) {
    if (valor == "Cedula") {
            document.getElementById("Formulario01").style.display = "inline";
            document.getElementById("Formulario02").style.display = "none";
    }

    if (valor == "Nombre") {
        document.getElementById("Formulario01").style.display = "none";
        document.getElementById("Formulario02").style.display = "inline";
    }
}


function buscarPorCedula() {
    var cedula = document.getElementById("cedula").value;
    if (cedula == "") {
        document.getElementById("informacion").innerHTML = "";
    } else {
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue");
                document.getElementById("informacion").innerHTML = this.responseText;
            }
        };
        xmlhttp.open("GET", "/ProyectoIngSoftware-CitasMedicas/BuscarClienteCedula?cedula=" + cedula, true);
        xmlhttp.send();
    }
    return false;
}



function buscarPorNombre() {
    var nombre = document.getElementById("Nombre").value;
    if (nombre == "") {
        document.getElementById("informacion").innerHTML = "";
    } else {
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue");
                document.getElementById("informacion").innerHTML = this.responseText;
            }
        };
        xmlhttp.open("GET", "/ProyectoIngSoftware-CitasMedicas/BuscarClienteNombre?nombre=" + nombre, true);
        xmlhttp.send();
    }
    return false;
}

function mostrarCliente5(idCliente,nombreCliente){

	console.log("sii entra");
	document.getElementById("codigoCliente").value = idCliente;
	document.getElementById("nombreCliente").value = nombreCliente;
}

function mostrarCliente(idCliente, nombreCliente, apellidoCliente, cedulaCliente, lugarNacimiento, email, nacionalidad, idCita, precio, tipoCita){

	console.log("sii entra");
	document.getElementById("codigoCliente").value = idCliente;
	document.getElementById("nombreCliente").value = nombreCliente;
	document.getElementById("apellidoCliente").value = apellidoCliente;
	document.getElementById("cedulaCliente").value = cedulaCliente;
	document.getElementById("lugarNacimiento").value = lugarNacimiento;	
	document.getElementById("emailCliente").value = email;
	document.getElementById("nacionlidadCliente").value = nacionalidad;
	document.getElementById("codigoCita").value = idCita;
	document.getElementById("precioCita").value = precio;
	document.getElementById("tipoCita").value = tipoCita;
	
}



function agregarFacturaDetalle() {
	console.log("Si entra");
    var codigoCliente = document.getElementById("codigoCliente").value;
    var codigoCita = document.getElementById("codigoCita").value;
    
    if (codigoCita == "") {
        document.getElementById("informacionPago").innerHTML = "";
    } else {
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue");
                document.getElementById("informacionPago").innerHTML = this.responseText;
            }
        };
        xmlhttp.open("GET", "/ProyectoIngSoftware-CitasMedicas/CrearFactura?codigoCliente=" + codigoCliente+"&codigoCita="+codigoCita, true);
        xmlhttp.send();
    }
    return false;
}
