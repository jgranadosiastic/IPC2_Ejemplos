/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class java {

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
				   DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=ajedrez21Mysql");
			
			//Mostramos el nombre del esquema de base de datos, en este caso es mysql
			System.out.println("conectado:" + connection.getCatalog());
			//a partir de la coneccion creamos un objecto Statement para poder ejecutar codigo SQL en la DB
			Statement declaracion = connection.createStatement();
			
			//ejecutamos la consulta y guardamos los datos en un objeto ResultSet
			ResultSet resultado = declaracion.executeQuery("SELECT Db, User FROM db;");
			
			int numeroFila = 1;
			System.out.println("Datos:");
			//recorremos cada fila usando el metodo next del resultset.
			while (resultado.next()) {
				System.out.println("Fila " + numeroFila + "-" + "Db: " + resultado.getString("Db") + " | User: " + resultado.getString("User"));
				numeroFila++;
			}
			
			
		} catch (Exception e) {
			System.out.println("error");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(java.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

}
