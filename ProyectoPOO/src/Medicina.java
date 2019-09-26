/**
 * @author Grupo 2 POO Seccion 21
 * @date 05/09/2019
 * Segunda presentacion de proyecto
 */
public class Medicina {
	private String nombre;
	private double precio;
	private String ingestion;
	private String tiposMedicina;
	private String dosis;
	private String notasAdicionales;
	
	public Medicina() {
		nombre = "";
		precio = 0;
		ingestion = "";
		tiposMedicina = "";
		dosis = "";
		notasAdicionales = "";
	}
		
	public Medicina(String nombre, double precio, String ingestion, String tiposMedicina, String dosis, String notasAdicionales) {
		this.nombre = nombre;
		this.precio = precio;
		this.ingestion = ingestion;
		this.tiposMedicina = tiposMedicina;
		this.dosis = dosis;
		this.notasAdicionales = notasAdicionales;
	}

	//nombre
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// precio
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	//ingestion
	/**
	 * @return the ingestion
	 */
	public String getIngestion() {
		return ingestion;
	}

	/**
	 * @param ingestion the ingestion to set
	 */
	public void setIngestion(String ingestion) {
		this.ingestion = ingestion;
	}
	
	//tipo de medicina
	/**
	 * @return the tiposMedicina
	 */
	public String getTiposMedicina() {
		return tiposMedicina;
	}

	/**
	 * @param tiposMedicina the tiposMedicina to set
	 */
	public void setTiposMedicina(String tiposMedicina) {
		this.tiposMedicina = tiposMedicina;
	}

	//dosis
	/**
	 * @return the dosis
	 */
	public String getDosis() {
		return dosis;
	}

	/**
	 * @param dosis the dosis to set
	 */
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	//notas adicionales
	/**
	 * @return the notasAdicionales
	 */
	public String getNotasAdicionales() {
		return notasAdicionales;
	}

	/**
	 * @param notasAdicionales the notasAdicionales to set
	 */
	public void setNotasAdicionales(String notasAdicionales) {
		this.notasAdicionales = notasAdicionales;
	}

	//toString
	@Override
	public String toString() {
		return "Medicina [nombre=" + nombre + ", precio=" + precio + ", ingestion=" + ingestion + ", tiposMedicina="
				+ tiposMedicina + ", dosis=" + dosis + ", notasAdicionales=" + notasAdicionales + "]";
	}
	
	
}
