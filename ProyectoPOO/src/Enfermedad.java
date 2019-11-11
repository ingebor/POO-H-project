/**
 * @author Grupo 6 POO Seccion 21
 * @date 05/09/2019
 * Segunda presentacion de proyecto
 */
public class Enfermedad {
	private String nombre;
	private boolean dolorCabeza;
	private boolean dolorEstomago;
	private boolean vomito;
	private boolean diarrea;
	private boolean estornudo;
	private boolean tos;
	private boolean dolorGeneral;
	private boolean faltaEnergia;
	private String notasAdicionales;
	private String nombreMed;
	/**
	 * Constructor sin parametros de la clase CatalogoSalud
	 */
	public Enfermedad() {
		nombre = "";
		dolorCabeza = false;
		dolorEstomago = false;
		vomito = false;
		diarrea = false;
		estornudo = false;
		tos = false;
		dolorGeneral = false;
		faltaEnergia = false;
		notasAdicionales = "";
		nombreMed = "";
	}
		public Enfermedad(String nombre, boolean dolorCabeza, boolean dolorEstomago, boolean vomito, boolean diarrea, boolean estornudo, boolean tos, boolean dolorGeneral, boolean faltaEnergia, String notasAdicionales, String nombreMed) {
			this.nombre = nombre;
			this.dolorCabeza = dolorCabeza;
			this.dolorEstomago = dolorEstomago;
			this.vomito = vomito;
			this.diarrea = diarrea;
			this.estornudo = estornudo;
			this.tos = tos;
			this.dolorGeneral = dolorGeneral;
			this.faltaEnergia = faltaEnergia;
			this.notasAdicionales = notasAdicionales;
			this.nombreMed = nombreMed;
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
		
		//dolor de cabeza
		/**
		 * @return the dolorCabeza
		 */
		public boolean isDolorCabeza() {
			return dolorCabeza;
		}
		/**
		 * @param dolorCabeza the dolorCabeza to set
		 */
		public void setDolorCabeza(boolean dolorCabeza) {
			this.dolorCabeza = dolorCabeza;
		}
		
		//dolor de estomago
		/**
		 * @return the dolorEstomago
		 */
		public boolean isDolorEstomago() {
			return dolorEstomago;
		}
		/**
		 * @param dolorEstomago the dolorEstomago to set
		 */
		public void setDolorEstomago(boolean dolorEstomago) {
			this.dolorEstomago = dolorEstomago;
		}
		
		//vomito
		/**
		 * @return the vomito
		 */
		public boolean isVomito() {
			return vomito;
		}
		/**
		 * @param vomito the vomito to set
		 */
		public void setVomito(boolean vomito) {
			this.vomito = vomito;
		}
		
		//diarrea
		/**
		 * @return the diarrea
		 */
		public boolean isDiarrea() {
			return diarrea;
		}
		/**
		 * @param diarrea the diarrea to set
		 */
		public void setDiarrea(boolean diarrea) {
			this.diarrea = diarrea;
		}
		
		//Estornudo
		/**
		 * @return the estornudo
		 */
		public boolean isEstornudo() {
			return estornudo;
		}
		/**
		 * @param estornudo the estornudo to set
		 */
		public void setEstornudo(boolean estornudo) {
			this.estornudo = estornudo;
		}
		
		//Tos
		/**
		 * @return the tos
		 */
		public boolean isTos() {
			return tos;
		}
		/**
		 * @param tos the tos to set
		 */
		public void setTos(boolean tos) {
			this.tos = tos;
		}
		
		//Dolor general
		/**
		 * @return the dolorGeneral
		 */
		public boolean isDolorGeneral() {
			return dolorGeneral;
		}
		/**
		 * @param dolorGeneral the dolorGeneral to set
		 */
		public void setDolorGeneral(boolean dolorGeneral) {
			this.dolorGeneral = dolorGeneral;
		}
		
		//Falta de energias
		/**
		 * @return the faltaEnergia
		 */
		public boolean isFaltaEnergia() {
			return faltaEnergia;
		}
		/**
		 * @param faltaEnergia the faltaEnergia to set
		 */
		public void setFaltaEnergia(boolean faltaEnergia) {
			this.faltaEnergia = faltaEnergia;
		}
		
		//Notas adicionales
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
		
		//Enfermedad relacionada
		/**
		 * @return the notasAdicionales
		 */
		public String getNombreMed() {
			return nombreMed;
		}
		/**
		 * @param nombreMed the nombreMed to set
		 */
		public void setNombreMed(String nombreMed) {
			this.nombreMed = nombreMed;
		}
		
		//metodo toString
		@Override
		public String toString() {
			String rDolorCabeza = "";
			if(this.dolorCabeza) {
				rDolorCabeza = "Si";
			}else {
				rDolorCabeza = "No";
			}
			String rDolorEstomago = "";
			if(this.dolorEstomago) {
				rDolorEstomago = "si";
			}else {
				rDolorEstomago = "no";
			}
			String rVomito = "";
			if(this.vomito) {
				rVomito = "si";
			}else {
				rVomito = "no";
			}
			String rDiarrea = "";
			if(this.diarrea) {
				rDiarrea = "si";
			}else {
				rDiarrea = "no";
			}
			String rEstornudo = "";
			if(this.estornudo) {
				rEstornudo = "si";
			}else {
				rEstornudo = "no";
			}
			String rTos = "";
			if(this.tos) {
				rTos = "si";
			}else {
				rTos = "no";
			}
			String rDolorGeneral = "";
			if(this.dolorGeneral) {
				rDolorGeneral = "si";
			}else {
				rDolorGeneral = "no";
			}
			String rFaltaEnergia = "";
			if(this.faltaEnergia) {
				rFaltaEnergia = "si";
			}else {
				rFaltaEnergia = "no";
			}

			
			return "Nombre: " + nombre + "\nDolor de cabeza: " + rDolorCabeza + "\nDolor de Estomago: " + rDolorEstomago + "\nVomito: " + rVomito + "\nDiarrea: " + rDiarrea 
					+ "\nEstornudos: " + rEstornudo + "\nTos: " + rTos + "\nDolor General: " + rDolorGeneral + "\nFalta de Energia: " + rFaltaEnergia + "\nNotas Adicionales: " + 
					notasAdicionales + "\nNombre Medicina: " +nombreMed;
		}
		
		
		
	
}
