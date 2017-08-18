package main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose
 */
public class main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Connection connection = null;
		try {
			//Indicamos cual driver usar
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//abrimos una coneccion a la DB usando una url en la que indicamos el
			//nombre de la base da tos (schema) y como parametros mandamos el usuario y password (SUSTITUIR PASSWORD)
			connection = 
				   DriverManager.getConnection("jdbc:mysql://localhost?user=root&password=ajedrez21Mysql");
			
			OperadorEsquema operador = new OperadorEsquema(connection);
			
			operador.borrarEsquema();
			operador.crearEsquema();
			operador.seleccionarEsquema();
			operador.crearTablaEstudiante();
			
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace(System.out);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
	
}
