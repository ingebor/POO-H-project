/**
 * @author Grupo 6 POO Seccion 21
 * @date 05/09/2019
 * Segunda presentacion de proyecto
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.Statement;

//a
public class CatalogoSalud {
	private List <Enfermedad> listadoEnfermedades;
	private List <Medicina> listadoMedicinas;
	private List <Doctor> listadoDoctores;
	
	private Statement stQuery;
    private  ResultSet rsRecords;
    private ConeccionBD BD;
    
    //Al hacer push o commit, dejen estas solo en comillas
    //h
    private String usuario = "";
    private String basededatos = "bdpoo";
    private String contrasena = "";

    //haaaaa

    
	/**
	 * Constructor sin parametros de catalogoSalud
	 */
	public CatalogoSalud()
	{

		listadoEnfermedades = new ArrayList<Enfermedad>();
		listadoMedicinas = new ArrayList<Medicina>();
		listadoDoctores = new ArrayList<Doctor>();
		BD = new ConeccionBD("jdbc:mysql://localhost/"+basededatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , usuario, contrasena );
		BD.getNewConnection();
		
		llenarCatalogo();
	}
	
	/**
	 * Agrega una medicina a la base de datoss
	 * @param nombre el nombre de la medicina
	 * @param precio el precio de la medicina
	 * @param ingestion el modo de ingestion de la medicina
	 * @param tipoMedicina el tipo de medicina
	 * @param dosis la dosis de la medicina
	 * @param notasAdicionales las notas Adicionales que se puedan ajuntar acerca de la medicina
	 * @param nombreEnf la enfermedad que la medicina alivia
	 */
	public int agregarMedicina(String nombre, String precio, String ingestion, String tipoMedicina, String dosis, String notasAdicionales, String nombreEnf){	
		int mensaje = 0;
		try {
			boolean seguir = true;
			int indice = 0;
			for(Medicina medicina: listadoMedicinas) {
				if(medicina.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					seguir = false;
					indice = listadoMedicinas.indexOf(medicina);
				}
			}
			
			if(seguir) {
			String queryInsert = "INSERT INTO medicinas (Nombre, Precio, Ingestion, Tipo, Dosis, NotasAdicionales, Enfermedad) "
	                + "VALUES ('" + nombre.toLowerCase() + "', '" + precio + "', '" + ingestion + "', '" + tipoMedicina + "', '" + dosis + "', '" + notasAdicionales + "', '" + nombreEnf + "') ";
			
	        manejarBD(queryInsert);
	        listadoMedicinas.add(new Medicina(nombre, Double.parseDouble(precio), ingestion, tipoMedicina, dosis, notasAdicionales, nombreEnf));
	        mensaje = 1;
			}
			else {
				mensaje = 0;
			}
		}catch(Exception e) {
			mensaje = 0;
		}
		
		return mensaje;
	}
	
	/**
	 * Agrega una enfermedad a la base de datos
	 * @param nombre el nombre de la enfermedad
	 * @param dolorCabeza si dolor de cabeza es un sintoma de la enfermedad
	 * @param dolorEstomago si dolor de estomago es un sintoma de la enfermedad
	 * @param vomito si vomito es un sintoma de la enfermedad
	 * @param diarrea si diarrea es un sintoma de la enfermedad
	 * @param estornudo si estornudar es un sintoma de la enfermedad
	 * @param tos si la tos es un sintoma de la enfermedad
	 * @param dolorGeneral si el dolor general es un sintoma de la enfermedad
	 * @param faltaEnergia si la falta de energia es un sintoma de la enfermedad
	 * @param notasAdicionales Son anotacioness extra acerca de la enfermedad
	 * @param nombreMed Nombre de la medicina que alivia a la enfermedad
	 * 
	 */
	public int agregarEnfermedad(String nombre, String dolorCabeza, String dolorEstomago, String vomito, String diarrea,
			String estornudo, String tos, String dolorGeneral, String faltaEnergia, String notasAdicionales, String nombreMed){
		int mensaje = 0;
		try {
			boolean seguir = true;
			int indice = 0;
			
			for(Enfermedad enfermedad: listadoEnfermedades) {
				if(enfermedad.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					seguir = false;
					indice = listadoEnfermedades.indexOf(enfermedad);
				}
			}
			
			if(seguir) {
		String queryInsert = "INSERT INTO enfermedades (Nombre, DolorCabeza, DolorEstomago, Vomito, Diarrea, Estornudo, Tos, DolorGeneral, FaltaEnergia, NotasAdicionales, Medicina) "
                + "VALUES ('" + nombre.toLowerCase() + "', '" + dolorCabeza + "', '" + dolorEstomago + "', '" + vomito + "', '" + diarrea + "', '" + estornudo + "', '" + tos + "', '" + dolorGeneral + 
                "', '" + faltaEnergia + "', '" + notasAdicionales + "', '" + nombreMed + "') ";
		
		listadoEnfermedades.add(new Enfermedad(nombre, Boolean.parseBoolean(dolorCabeza), Boolean.parseBoolean(dolorEstomago), Boolean.parseBoolean(vomito),
				Boolean.parseBoolean(diarrea), Boolean.parseBoolean(estornudo), Boolean.parseBoolean(tos), Boolean.parseBoolean(dolorGeneral), Boolean.parseBoolean(faltaEnergia),
				notasAdicionales, nombreMed));
        manejarBD(queryInsert);
        mensaje = 1;
			}
			else {
				mensaje = 0;
			}
		}
		catch(Exception e) {
			mensaje = 0;
			
		}
		return mensaje;
	}
	
	/**
	 * Este metodo llena los listados de enfermedades, doctores y de medicinas del catalogo
	 */
	private void llenarCatalogo()  {
		
		try {
          
            
            
            String query = "SELECT * FROM enfermedades ORDER BY Nombre ASC";
          
            stQuery = BD.getCurrentConnection().createStatement();
            rsRecords = stQuery.executeQuery(query);
            
            listadoEnfermedades.clear();
            
            while(rsRecords.next()){
            	listadoEnfermedades.add(new Enfermedad(rsRecords.getString("enfermedades.Nombre"),Boolean.parseBoolean(rsRecords.getString("enfermedades.DolorCabeza")), 
            			Boolean.parseBoolean(rsRecords.getString("enfermedades.DolorEstomago")), Boolean.parseBoolean(rsRecords.getString("enfermedades.Vomito")), 
            			Boolean.parseBoolean(rsRecords.getString("enfermedades.Diarrea")), Boolean.parseBoolean(rsRecords.getString("enfermedades.Estornudo")), 
            			Boolean.parseBoolean(rsRecords.getString("Enfermedades.Tos")), Boolean.parseBoolean(rsRecords.getString("enfermedades.DolorGeneral")), 
            			Boolean.parseBoolean(rsRecords.getString("Enfermedades.faltaEnergia")),rsRecords.getString("enfermedades.NotasAdicionales"), 
            			rsRecords.getString("enfermedades.Medicina")));
                
            }

        }catch (Exception e0) {
            System.out.println("error show rows");
            e0.printStackTrace();
        }  
		
		try {
            
            String query = "SELECT * FROM medicinas ORDER BY Nombre ASC";
          
            stQuery = BD.getCurrentConnection().createStatement();
            rsRecords = stQuery.executeQuery(query);
            
            listadoMedicinas.clear();
            while(rsRecords.next()){
            	listadoMedicinas.add(new Medicina(rsRecords.getString("medicinas.Nombre"),rsRecords.getDouble("medicinas.Precio"), rsRecords.getString("medicinas.Ingestion")
            			,rsRecords.getString("medicinas.Tipo"),rsRecords.getString("medicinas.Dosis"),rsRecords.getString("medicinas.NotasAdicionales")
            			,rsRecords.getString("medicinas.Enfermedad")));
            }

            
            String querydDoc = "SELECT * FROM usuario";
            stQuery = BD.getCurrentConnection().createStatement();
            rsRecords = stQuery.executeQuery(querydDoc);
            
            listadoDoctores.clear();
            while(rsRecords.next()) {
            	listadoDoctores.add(new Doctor(rsRecords.getString("usuario.NombreUsuario"), rsRecords.getString("usuario.Contrasenia")));
            }
            
        }catch (Exception e0) {
            System.out.println("error show rows");
            e0.printStackTrace();
        }
	}
	
	 
	/**
	 * @param nombreEnfermedad
	 * @return cadena de atributos
	 * Este metodo permite ingresar el nombre de la enfermedad y devuelve los atributos de dicha enfermedad con el toString de Enfermedad
	 */
	public String verEnfermedad(String nombreEnfermedad){
		String mensaje = "";
		for (int i = 0; i < listadoEnfermedades.size(); i++) {
			try 
			{
				if(listadoEnfermedades.get(i).getNombre().toLowerCase().equals(nombreEnfermedad.toLowerCase()))
				{
					
					mensaje = listadoEnfermedades.get(i).toString();
				}
			
			}
			catch(Exception e)
			{
				mensaje = "Lo sentimos, no se ha encontrado la enfermedad";
			}
			
		}
		if(mensaje.equals("")) {
			mensaje = "Lo sentimos, no se ha encontrado la enfermedad";
		}
		return mensaje;	
	}
	
	
	/**
	 * Este metodo permite ingresar el nombre de la medicina y devuelve los atributos de dicha medicina con el toString de medicina
	 * @param nombreMedicina El nombre de la medicina que se desea consultar
	 * @return cadena de atributos de la medicina
	 */
	public String VerMedicina(String nombreMedicina) {
		String mensaje = "";
		for (int i = 0; i < listadoMedicinas.size(); i++) {
			try 
			{
				if(listadoMedicinas.get(i).getNombre().toLowerCase().equals(nombreMedicina.toLowerCase()))
				{
					mensaje = listadoMedicinas.get(i).toString();
				}
				
			}
			catch(Exception e)
			{
				mensaje = "Lo sentimos, no se ha encontrado el medicamento.";
			}
			
		}
		if(mensaje.equals("")) {
			mensaje = "Lo sentimos, no se ha encontrado el medicamento";
		}
		return mensaje;
	}
	
	
	
	/**
	 * Este metodo actualiza un de las medicinas de la base de datos y tambien el listado de Medicinas
	 * @param nombre el nombre de la medicina que sera actualizada
	 * @param precio el nuevo valor de precio
	 * @param ingestion el nuevo valor de ingestion
	 * @param tiposMedicina el nuevo valor de tipo de medicina
	 * @param dosis el nuevo valor de dosis
	 * @param notasAdicionales las nuevas notas adicionales
	 * @return Una cadena donde indica si la operacion fue exitosa o no
	 */
	public String acualizarMedicina(String nombre,double precio, String ingestion, String tiposMedicina, String dosis, String notasAdicionales, String enfermedad) {
		String mensaje = "";
		try {
			boolean bandera = false;
			int indice = 0;
			
			for(Medicina medicina: listadoMedicinas) {
				if(medicina.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					bandera = true;
					indice = listadoMedicinas.indexOf(medicina);
				}
			}
			
			if(bandera) {
				String query = "UPDATE medicinas  SET Precio ='" + precio + "', Ingestion ='" + ingestion + "', Tipo = '" + tiposMedicina + "', Dosis = '" + 
					dosis + "', NotasAdicionales = '" + notasAdicionales + "', Enfermedad ='" + enfermedad + "' WHERE  Nombre ='" + nombre + "';";
			
				manejarBD(query);
				
				listadoMedicinas.set(indice, new Medicina(nombre,precio,ingestion,tiposMedicina,dosis,notasAdicionales,enfermedad));
				mensaje = "Se ha realizado la actualización exitosamente.";
			}
			else {
				mensaje = "Ninguna medcina coincide con el nombre ingresado. No se\npuede realizar la actualizacion. Intente de nuevo por favor.";
			}
		}
		catch(Exception e0) {
			mensaje = "Ocurrió un error durante el manejo de la base de datos, puede \n que haya ingresado mal un dato. En el precio solo ingrese numeros y decimales.\n"
					+ "No deje espacios en blanco. Intente de nuevo por favor.";
		}
		return mensaje;
	}
	

	/**
	 * Busca una medicina en listadoMedicnas
	 * @param nombre el nombre de la medicina que se quiere encontrar
	 * @return Regresa la medicina que el usuario desea buscar de la lista de medicinas.
	 */
	public Medicina buscarMed(String nombre) {
		Medicina buscada = new Medicina();
		boolean bandera = true;
		
		int indice = 0;
		while(bandera && indice < listadoMedicinas.size()) {
		 	if(listadoMedicinas.get(indice).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				buscada = listadoMedicinas.get(indice);
				bandera = false;
			}
			indice++;
		}
		
		return buscada;
	}

	
	/**
	 * En base a los sintomas ingresados por el usuario, el metodo determina las posibles enfermedades que padece con una probabilidad incluida
	 * @param dolorCabeza si el usuario tiene dolor de cabeza o no
	 * @param dolorEstomago si el usuario tiene dolor de estomago o no
	 * @param vomito si el usuario tiene vomitos o no
	 * @param diarrea si el usuario tiene diarrea o no
	 * @param estornudo si el usuario tiene estornudos o no
	 * @param tos si el usuario tiene tos o no
	 * @param dolorGeneral si el usuario tiene dolor general o no
	 * @param faltaEnergia si el usuario tiene falta de energia o no
	 * @return mensaje de probabilidad de enfermedades
	 */
	public String buscarEnfermedad(boolean dolorCabeza, boolean dolorEstomago, boolean vomito, boolean diarrea,
			boolean estornudo, boolean tos, boolean dolorGeneral, boolean faltaEnergia) {
		
		String mensaje = "Puede tener:";
		for (Enfermedad enfermedad : listadoEnfermedades) {
			double contador = 0;
			
			if(enfermedad.isDolorCabeza()== dolorCabeza)
			{
				contador++;
			}
			if(enfermedad.isDolorEstomago()== dolorEstomago)
			{
				contador++;
			}
			if(enfermedad.isVomito()== vomito)
			{
				contador++;
			}
			if(enfermedad.isDiarrea() == diarrea)
			{
				contador++;
			}
			if(enfermedad.isEstornudo() == estornudo)
			{
				contador++;
			}
			if(enfermedad.isTos() == tos)
			{
				contador++;
			}
			if(enfermedad.isDolorGeneral() == dolorGeneral)
			{
				contador++;
			}
			if(enfermedad.isFaltaEnergia() == faltaEnergia)
			{
				contador++;
			}
			if(contador >= 4)
			{
				mensaje += "\n" + enfermedad.getNombre() + " con una probabilidad del " + String.valueOf(((contador/8)*100)-1)+"%";
			}
		}
		
		if(mensaje.equals("Puede tener:")) {
			mensaje = "No se ha encontrado ninguna enfermedad con este patrón de síntomas en la base de datos.";
		}
		return mensaje;
	}
	
	
	/**
	 * Permite Insertar, borrar o actualizar una tupla en una tabla de la base de datos
	 * @param query El query con las instrucciones para el manejo de la base de datos
	 */
	private void manejarBD(String query){
        try{   
            Statement stQuery = BD.getCurrentConnection().createStatement();

            String queryManejo = query;
            stQuery.executeUpdate(queryManejo);
               
        }
        catch(Exception e0){
        	e0.printStackTrace();
        }
	}
	
	/**
	 * Toma el nombre de una enfermedad y borra la tupla de la base de datos que tenga este nombre. Tambien la borra del listado de enfermedades
	 * @param nombreEnf
	 * @return Indica si se borro la enfermedad exitosamente en la base de datos
	 */
	public String borrarEnfermedad(String nombreEnf){
		String mensaje = "";
		int index = 0;
		
		boolean bandera = false;
		for(Enfermedad enfermedad: listadoEnfermedades) {
			if(enfermedad.getNombre().toLowerCase().equals(nombreEnf.toLowerCase())){
				bandera = true;
				index = listadoEnfermedades.indexOf(enfermedad);
			}
		}
		
		if(bandera) {
			String queryDelete = "DELETE FROM enfermedades WHERE Nombre = '" + nombreEnf + "'";
			manejarBD(queryDelete);
			listadoEnfermedades.remove(index);
			mensaje = "Se ha eliminado la enfermedad exitosamente";
		}
		else {
			mensaje = "Ningún nombre ha coincidido con el ingresado.\nIntente de nuevo por favor.";
		}
		
		return mensaje;
	}
	
	
		/**
		 * Toma el nombre de la medicina y borra la tupla de la base de datos que tenga este nombre y también la borra del listado de medicina
		 * @param nombreMed El nombre de la medicina que se va a borrar
		 * @return Indica si se borro la medicina exitosamente en la base de datos
		 */
		public String borrarMedicina(String nombreMed){
			String mensaje = "";
			int index = 0;
			
			boolean bandera = false;
			for(Medicina medicina: listadoMedicinas) {
				if(medicina.getNombre().equals(nombreMed.toLowerCase())) {
					bandera = true;
					index = listadoMedicinas.indexOf(medicina);
				}
			}
			if(bandera) {
				String queryDelete = "DELETE FROM medicinas WHERE Nombre = '" + nombreMed + "'";
				manejarBD(queryDelete);
				listadoMedicinas.remove(index);
				mensaje = "Se ha eliminado el medicamento exitosamente";
			}
			else {
				mensaje = "Ningún nombre ha coincidido con el ingresado.\nIntente de nuevo por favor.";
			}
			
			return mensaje;
	}
		
		/**
		 * Este metodo actualiza una enfermedad de la base de datos y en el listado de enfermedades
		 * @param nombre el nombre de la enfermedad para actualizar
		 * @param dolorCabeza el nuevo valor de dolorCabeza
		 * @param dolorEstomago el nuevo valor de dolorEstomago
		 * @param vomito el nuevo valor de vomito
		 * @param diarrea el nuevo valor de diarrea
		 * @param estornudo el nuevo valor de estornudo
		 * @param tos el nuevo valor de tos
		 * @param dolorGeneral el nuevo valor de dolorGeneral
		 * @param faltaEnergia el nuevo valor de faltaEnergia
		 * @param notasAdicionales Las nuevas notasAdicionales
		 * @return Indica si la enfermedad se actualizo exitosamente en la base de datos
		 */
		public String actualizarEnfermedad(String nombre,boolean dolorCabeza, boolean dolorEstomago, boolean vomito, boolean diarrea, boolean estornudo, boolean tos, boolean dolorGeneral, boolean faltaEnergia, String notasAdicionales,String medicina) {
			String notificacion = "";
			try {
				boolean seguir = false;
				int indice = 0;
				
				for(Enfermedad enfermedad: listadoEnfermedades) {
					if(enfermedad.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
						seguir = true;
						indice = listadoEnfermedades.indexOf(enfermedad);
					}
				}
				
				if(seguir) {
					String query = "UPDATE enfermedades  SET DolorCabeza ='" + String.valueOf(dolorCabeza) + "', DolorEstomago ='" + String.valueOf(dolorEstomago) + "', Vomito = '" + String.valueOf(vomito)  + "', Diarrea = '" + 
						String.valueOf(diarrea) + "', Estornudo = '" + String.valueOf(estornudo) + "', Tos ='" + String.valueOf(tos) + "', DolorGeneral ='" + String.valueOf(dolorGeneral) + "', FaltaEnergia ='" + String.valueOf(faltaEnergia) +  "', NotasAdicionales ='" + notasAdicionales + "', Medicina ='" + medicina + "' WHERE  Nombre ='" + nombre + "';";
				
					manejarBD(query);
					
					listadoEnfermedades.set(indice, new Enfermedad(nombre, dolorCabeza ,dolorEstomago , vomito, diarrea,estornudo, tos, dolorGeneral, faltaEnergia, notasAdicionales, medicina));
					notificacion = "La actualizacion se ha completado";
				}
				else {
					notificacion = "El nombre no coincide con niguna enfermedad actual, ingrese de nuevo por favor.";
				}
			}
			catch(Exception e0) {
				notificacion = "Ocurrió un error durante el manejo de la base de datos, puede \n que haya ingresado mal un dato. En el precio solo ingrese numeros y decimales.\n"
						+ "No deje espacios en blanco. Intente de nuevo, por favor.";
			}
			return notificacion;
		}
		
		/**
		 * Este metodo permite buscar la enfermedad una enfermedad que el usuario desea y con eso obtenemos su informacion
		 * @param nombre el nombre de la enfermedad buscada
		 * @return regresa el nombre de la enfermedad y sus atributos de la lista
		 */
		public Enfermedad buscarEnfermedadA(String nombre) {
			Enfermedad NombreBusc = new Enfermedad();
			boolean seguir = true;
			
			int indice = 0;
			while(seguir && indice < listadoEnfermedades.size()) {
				if(listadoEnfermedades.get(indice).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					NombreBusc = listadoEnfermedades.get(indice);
					seguir = false;
				}
				indice++;
			}
			System.out.println(indice);
			return NombreBusc;
		}
		
		/**
		 * Agrega un nuevo doctor a la base de datos, para que este pueda entrar a la interfaz de doctor del programa
		 * @param nombreUsuario el nombre de Ususario del doctor
		 * @param contrasena la contrasenia del doctor
		 * @return Un mensaje que indica el resultado de la operacion
		 */
		public String agregarDoctor(String nombreUsuario, String contrasena) {
			String mensaje = "";
			boolean mismoUsuario = false;
			int i = 0;
			for(Doctor doctor: listadoDoctores) {
				if(doctor.getNombreUsuario().equals(nombreUsuario)) {
					mismoUsuario = true;
				}
			}
			
			if(mismoUsuario) {
				mensaje = "El nombre de usuario ingresado ya existe, ingrese otro nombre por favor.";
			}else {
				String queryInsert = "INSERT INTO usuario (NombreUsuario, Contrasenia) VALUES ('" + nombreUsuario + "', '" + contrasena + "')";
				manejarBD(queryInsert);
				listadoDoctores.add(new Doctor(nombreUsuario, contrasena));
				
				mensaje = "Nuevo Doctor agregado";
			}
			
			return mensaje;
		}
		
		/**
		 * Borra a un doctor de la base de datos en la tabla usuario
		 * @param nombreUsuario el nombre de Usuario del doctor que se va a borrar
		 * @return Un mensaje que indica el resultado de la operación
		 */
		public String borrarDoctor(String nombreUsuario) {
			String mensaje = "";
			boolean banderaBorrar = false;
			int indice = 0;
			int i = 0;
			
			while(!banderaBorrar && i < listadoDoctores.size() && listadoDoctores.size() != 0) {
				if(listadoDoctores.get(i).getNombreUsuario().equals(nombreUsuario)) {
					banderaBorrar = true;
					indice = i;
				}
				i++;
			}
			
			if(banderaBorrar) {
				String queryDelete = "DELETE FROM usuario WHERE NombreUsuario = '" + nombreUsuario + "'";
				manejarBD(queryDelete);
				listadoDoctores.remove(indice);
				mensaje = "Se ha eliminado al doctor exitosamente";
				
			}else {
				mensaje = "No existe ningún doctor con ese nombre de usuario\n o bien, no hay doctores en la base de datos.";
			}
			
			return mensaje;
		}
		
		/**
		 * Acceso al listado de doctores
		 * @return listadoDoctores el listado de Doctores
		 */
		public List<Doctor> getListadoDoctores(){
			return listadoDoctores;
		}
}

 