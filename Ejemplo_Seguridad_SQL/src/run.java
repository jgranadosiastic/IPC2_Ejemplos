
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
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
public class run {
	
	private static final String urlBasica = "jdbc:mysql://localhost/CONTROL_CURSOS";

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Connection connection = null;
		try {
			//Indicamos cual driver usar
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//IMPORTANTE
			//AHORA MEJOR USAMOS PROPERTIES PARA SER MAS CONFIGURABLE LA CONECCION
			//Y MAS LEIBLE
			//abrimos una coneccion a la DB usando una url en la que indicamos el
			//nombre de la base da tos (schema) y como parametros mandamos el usuario y password (SUSTITUIR PASSWORD)
			/*connection = 
				   DriverManager.getConnection("jdbc:mysql://localhost?user=root&password=ajedrez21Mysql");*/
			
			String usuario = "root";
			String password = "ajedrez21Mysql";
			Properties propiedades = new Properties();
			propiedades.setProperty("user", usuario);
			propiedades.setProperty("password", password);
			
			connection = DriverManager.getConnection(urlBasica, propiedades);
			
			//a partir de la coneccion creamos un objecto Statement para poder ejecutar codigo SQL en la DB
			Statement declaracion = connection.createStatement();
			
			//ejecutamos la consulta y guardamos los datos en un objeto ResultSet
			ResultSet resultado = declaracion.executeQuery("SELECT Carnet, Nombre FROM ESTUDIANTE;");
			
			int numeroFila = 1;
			System.out.println("Datos:");
			//recorremos cada fila usando el metodo next del resultset.
			while (resultado.next()) {
				System.out.println("Fila " + numeroFila + "-" + "Carnet: " + resultado.getString("Carnet") + " | Nombre: " + resultado.getString("Nombre"));
				numeroFila++;
			}
			
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace(System.out);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(run.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
	
}
