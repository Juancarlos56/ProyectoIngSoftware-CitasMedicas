# ProyectoIngSoftware-CitasMedicas
## Instrucciones de Uso
### Requerimientos:
- Eclipse 2020-12
- JUnit 15
- JDK 15
- Base MySql
- Servidor Apache, desplegado en Tomcat
- Base de Datos con nombre citasMedicas
### Instrucciones:
1. Se debe modificar el archivo persistence.xml, con los datos correspondientes a la conexión a la base de datos con la que se este trabajando; campos de usuario y contraseña
2. Para la persistencia de las diferentes entidades es necesario correr, dentro del servidor Apache, la clase Creaciontablas dentro del páqueteCargaBasedeDatos
3. Para probar las diferentes pruebas unitarias se debe recurrir al paquete Test, archivos los cuales se los debe ejecutar como un JUnit Test
### Recomendaciones:
- Asegurarse que dentro de Proyect Faces del proyecto de eclipse conste la librería de JUnit
- Asegurarse de utilizar el JDK 15
- Asegurarse de la informacion ingresada en el archivo persistence.xml
