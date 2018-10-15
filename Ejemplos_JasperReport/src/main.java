
import ejemplo.AprobacionCurso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

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

	private static final String urlBasica = "jdbc:mysql://localhost/CONTROL_CURSOS";

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Connection connection = null;
		try {
			String user = "root";
			String password = "ajedrez21Mysql";
			// La url incluye el esquema a usar, en este caso 'mysql'
			String urlConnection = "jdbc:mysql://localhost:3306/CONTROL_CURSOS";
			
			//abrimos una coneccion a la DB usando una url, el usuario y password (SUSTITUIR PASSWORD)
			connection = 
				   DriverManager.getConnection(urlConnection, user, password);

			// descarga dentro del mismo proyecto
			JasperPrint jasperPrint = JasperFillManager.fillReport(
				   "resources/Estudiantes.jasper", null,
				   connection);
			JRPdfExporter exp = new JRPdfExporter();
			exp.setExporterInput(new SimpleExporterInput(jasperPrint));
			exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteEstudiantes.pdf"));
			SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
			exp.setConfiguration(conf);
			exp.exportReport();

			// se muestra en una ventana aparte para su descarga
			JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				   "resources/Estudiantes.jasper", null,
				   connection);
			JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
			jasperViewer.setVisible(true);

			
			// usando beans
			List<AprobacionCurso> listado = new ArrayList<>();
			listado.add(new AprobacionCurso("nombre test"));
			listado.add(new AprobacionCurso("nombre test 2"));
			JasperPrint jasperPrint2 = JasperFillManager.fillReport(
				   "resources/AprobacionCursos.jasper", null,
				   new JRBeanCollectionDataSource(listado));
			
			exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
			exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Aprobaciones.pdf"));
			exp.setConfiguration(conf);
			exp.exportReport();

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
