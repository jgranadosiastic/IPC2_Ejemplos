package ejemplo;



/**
 * Ejemplo_SQL_JDBC
 * @author jose - 12.10.2017 
 * @Title: AprobacionCurso
 * @Description: description
 *
 * Changes History
 */
public class AprobacionCurso {
	
	private Estudiante estudiante;
	private Integer anio;
	private Integer semestre;
	
	public AprobacionCurso(String nombre) {
		this.estudiante = new Estudiante(nombre);
		this.anio = 2015;
		this.semestre = 1;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	
	
	

}