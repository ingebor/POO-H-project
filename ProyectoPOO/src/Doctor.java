/**
 * @author Grupo 6 POO
 * @date 03/011/2019
 * Modelar a un usuario doctor para el programa
 */
public class Doctor {
	private String nombreUsuario;
	private String contrasena;
	
	/**
	 * Constructor sin parametros de doctor
	 */
	public Doctor() {
		nombreUsuario = "";
		contrasena = "";
	}

	/**
	 * Constructor con parametros de doctor
	 * @param nombreUsuario el nombre de usuario del doctor
	 * @param contrasena la contrasena del doctor
	 */
	public Doctor(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	/**
	 * Acceso nombreUsuario
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Cambia el valor de nombreUsuario
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Acceso a contrasena
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Cambia el valor de contrasena
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
	@Override
	public String toString() {
		return "Doctor [nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + "]";
	}
}
