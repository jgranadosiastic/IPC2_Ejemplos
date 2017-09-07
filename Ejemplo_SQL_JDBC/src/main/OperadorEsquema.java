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

    public void crearTablaCurso() throws SQLException {
        Statement creaTablaCurso = coneccion.createStatement();
        creaTablaCurso.executeUpdate("CREATE TABLE CURSO (\n"
                + "  Codigo VARCHAR(8) NOT NULL,\n"
                + "  Nombre VARCHAR(45) NOT NULL,\n"
                + "  Creditos INT NOT NULL,\n"
                + "  CONSTRAINT PK_CURSO PRIMARY KEY(Codigo)\n"
                + ");");
    }

    public void crearTablaAsignacion() throws SQLException {
        Statement creaTablaAsignacion = coneccion.createStatement();
        creaTablaAsignacion.executeUpdate("CREATE TABLE ASIGNACION (\n"
                + "  Carnet_Estudiante VARCHAR(10) NOT NULL,\n"
                + "  Codigo_Curso VARCHAR(8) NOT NULL,\n"
                + "  Fecha DATE NOT NULL,\n"
                + "  Aprobado TINYINT(1) NULL,\n"
                + "CONSTRAINT PK_ASIGNACION PRIMARY KEY (Carnet_Estudiante,    Codigo_Curso),\n"
                + "CONSTRAINT FK_ESTUDIANTE_IN_CARNET_ESTUDIANTE\n"
                + "FOREIGN KEY (Carnet_Estudiante) REFERENCES ESTUDIANTE(Carnet),\n"
                + "CONSTRAINT FK_CURSO_IN_CODIGO_CURSO\n"
                + "    FOREIGN KEY (Codigo_Curso) REFERENCES CURSO(Codigo)\n"
                + ")");
    }
    
    public void insertarEstudiantes() throws SQLException {
        Statement estudiante1 = coneccion.createStatement();
        estudiante1.executeUpdate("INSERT INTO ESTUDIANTE (Carnet, Nombre, Apellidos, Fecha_Nacimiento) VALUES ('200413171', 'Pedro', 'Gonzalez', '2000-05-28')");
        estudiante1.executeUpdate("INSERT INTO ESTUDIANTE (Carnet, Nombre, Apellidos, Fecha_Nacimiento) VALUES ('200356321', 'Juan', 'Perez', '1999-07-20')");
    }

}
