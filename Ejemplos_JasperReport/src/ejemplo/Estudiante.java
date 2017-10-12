package ejemplo;

/**
 * Ejemplos_JasperReport
 * @author jose - 12.10.2017 
 * @Title: Estudiante
 * @Description: description
 *
 * Changes History
 */
public class Estudiante {
	private String nombre;
	private String carnet;
	
	public Estudiante(String nombre) {
		this.nombre = nombre;
		this.carnet = "201445645";
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}