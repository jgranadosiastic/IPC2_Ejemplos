package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejemplo_JDBC
 *
 * @author jose - 18.08.2017
 * @Title: OperadorEsquema
 * @Description: description
 *
 * Changes History
 */
public class OperadorEsquema {

	private Connection coneccion;

	public OperadorEsquema(Connection coneccion) {
		this.coneccion = coneccion;
	}

	public void borrarEsquema() throws SQLException {
		Statement borraEsquema = coneccion.createStatement();
		borraEsquema.executeUpdate("DROP SCHEMA CONTROL_CURSOS");
	}

	public void crearEsquema() throws SQLException {
		Statement creaEsquema = coneccion.createStatement();
		creaEsquema.executeUpdate("CREATE SCHEMA CONTROL_CURSOS");
	}
	
	public void seleccionarEsquema() throws SQLException {
		Statement creaEsquema = coneccion.createStatement();
		creaEsquema.executeUpdate("USE CONTROL_CURSOS");
	}

	public void crearTablaEstudiante() throws SQLException {
		Statement creaTablaEstudiante = coneccion.createStatement();
		creaTablaEstudiante.executeUpdate("CREATE TABLE ESTUDIANTE (\n"
			   + "  Carnet VARCHAR(10) NOT NULL,\n"
			   + "  Nombre VARCHAR(25) NOT NULL,\n"
			   + "  Apellidos VARCHAR(25) NOT NULL,\n"
			   + "  Fecha_Nacimiento DATE,\n"
			   + "  CONSTRAINT PK_ESTUDIANTE PRIMARY KEY(Carnet)\n"
			   + ");");
	}

}
