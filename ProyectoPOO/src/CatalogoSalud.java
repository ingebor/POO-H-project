/**
 * @author Grupo 2 POO Seccion 21
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

public class CatalogoSalud {
	private List <Enfermedad> listadoEnfermedades;
	private List <Medicina> listadoMedicinas;
	
	private Statement stQuery;
    private  ResultSet rsRecords;
    
    private String usuario = "root";
    private String basededatos = "bdpoo";
    private String contrasena = "lol123";
    
	/**
	 * @param Constructor de la clase CatalogoSalud
	 */
	public CatalogoSalud()
	{

		listadoEnfermedades = new ArrayList<Enfermedad>();
		listadoMedicinas = new ArrayList<Medicina>();
		llenarCatalogo();
		//System.out.println(listadoEnfermedades.get(0).toString());
	}
	
	/**
	 * @param nombre
	 * @param precio
	 * @param ingestion
	 * @param tipoMedicina
	 * @param dosis
	 * @param notasAdicionales
	 * @param nombreEnf
	 * Agrega una enfermedad a la base de datos
	 */
	public String agregarMedicina(String nombre, String precio, String ingestion, String tipoMedicina, String dosis, String notasAdicionales, String nombreEnf){	
		String mensaje = "";
		try {
			String queryInsert = "INSERT INTO medicinas (Nombre, Precio, Ingestion, Tipo, Dosis, NotasAdicionales, Enfermedad) "
	                + "VALUES ('" + nombre.toLowerCase() + "', '" + precio + "', '" + ingestion + "', '" + tipoMedicina + "', '" + dosis + "', '" + notasAdicionales + "', '" + nombreEnf + "') ";
			
	        manejarBD(queryInsert);
	        mensaje = "Se ingreso adecuadamente la medicina";
		}catch(Exception e) {
			mensaje = "Existe una medicina de mismo nombre dentro de la base de datos";
		}
		
		return mensaje;
	}
	
	/**
	 * @param nombre
	 * @param dolorCabeza
	 * @param dolorEstomago
	 * @param vomito
	 * @param diarrea
	 * @param estornudo
	 * @param tos
	 * @param dolorGeneral
	 * @param faltaEnergia
	 * @param notasAdicionales
	 * @param nombreMed
	 * Agrega una medicina a la base de datos
	 */
	public void agregarEnfermedad(String nombre, String dolorCabeza, String dolorEstomago, String vomito, String diarrea,
			String estornudo, String tos, String dolorGeneral, String faltaEnergia, String notasAdicionales, String nombreMed){
		String queryInsert = "INSERT INTO enfermedades (Nombre, DolorCabeza, DolorEstomago, Vomito, Diarrea, Estornudo, Tos, DolorGeneral, FaltaEnergia, NotasAdicionales, Medicina) "
                + "VALUES ('" + nombre.toLowerCase() + "', '" + dolorCabeza + "', '" + dolorEstomago + "', '" + vomito + "', '" + diarrea + "', '" + estornudo + "', '" + tos + "', '" + dolorGeneral + 
                "', '" + faltaEnergia + "', '" + notasAdicionales + "', '" + nombreMed + "') ";
		
        manejarBD(queryInsert);
	}
	
	
	/**
	 * Metodo para probar que las listas de objetos se hayan llenado correctamente
	 */
	public void pruebaListas() {
		for(Enfermedad enfermedad:listadoEnfermedades) {
			System.out.println(enfermedad.getNombre());
		}
		
		for(Medicina medicina:listadoMedicinas) {
			System.out.println(medicina.getNombre());
		}
	}
	
	
	/**
	 * Este metodo llena tanto el listado de enfermedades como el de medicinas al crear un catalogoSalud
	 */
	private void llenarCatalogo()  {
		try {
            ConeccionBD BD = null;
            
            BD = new ConeccionBD("jdbc:mysql://localhost:3306/" + basededatos, "root", contrasena);
            BD.getNewConnection();
            
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
            for(Enfermedad a:listadoEnfermedades) {
            	System.out.println(a.getNombre());
            }
        }catch (Exception e0) {
            System.out.println("error show rows");
            e0.printStackTrace();
        }  
		
		try {
            ConeccionBD BD = null;
            
            BD = new ConeccionBD("jdbc:mysql://localhost:3306/" + basededatos, "root", contrasena);
            BD.getNewConnection();
            
            String query = "SELECT * FROM medicinas ORDER BY Nombre ASC";
          
            stQuery = BD.getCurrentConnection().createStatement();
            rsRecords = stQuery.executeQuery(query);
            
            listadoMedicinas.clear();
            while(rsRecords.next()){
            	listadoMedicinas.add(new Medicina(rsRecords.getString("medicinas.Nombre"),rsRecords.getDouble("medicinas.Precio"), rsRecords.getString("medicinas.Ingestion")
            			,rsRecords.getString("medicinas.Tipo"),rsRecords.getString("medicinas.Dosis"),rsRecords.getString("medicinas.NotasAdicionales")
            			,rsRecords.getString("medicinas.Enfermedad")));
            }
            for(Medicina a:listadoMedicinas) {
            	System.out.println(a.getNombre());
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
		//int index = 0;
		for (int i = 0; i < listadoEnfermedades.size(); i++) {
			try 
			{
				if(listadoEnfermedades.get(i).getNombre().equals(nombreEnfermedad))
				{
					
					mensaje = listadoEnfermedades.get(i).toString();
					//index = listadoMedicinas.indexOf(medicina);
					//mensaje = listadoMedicinas.get(index).toString();
				}
				
			}
			catch(Exception e)
			{
				mensaje = "Lo sentimos pero no se encontro la enfermedad";
			}
			
		}
		
		
			
		return mensaje;	
	}
	
	
	/**
	 * @param nombreMedicina
	 * @return cadena de atributos
	 * Este metodo permite ingresar el nombre de la medicina y devuelve los atributos de dicha medicina con el toString de medicina
	 */
	public String VerMedicina(String nombreMedicina) {
		String mensaje = "";
		//int index = 0;
		for (int i = 0; i < listadoMedicinas.size(); i++) {
			try 
			{
				if(listadoMedicinas.get(i).getNombre().equals(nombreMedicina))
				{
					
					mensaje = listadoMedicinas.get(i).toString();
					//index = listadoMedicinas.indexOf(medicina);
					//mensaje = listadoMedicinas.get(index).toString();
				}
				
			}
			catch(Exception e)
			{
				mensaje = "Lo sentimos pero no se encontro el medicamento.";
			}
			
		}
		//for (Medicina medicina : listadoMedicinas) {

		//}
		
		return mensaje;
	}
	
	
	
	/**
	 * @param nombre
	 * @param precio
	 * @param ingestion
	 * @param tiposMedicina
	 * @param dosis
	 * @param notasAdicionales
	 * Este metodo actualiza un de las medicinas de la base de datos y tambien el listado de Medicinas
	 */
	public String acualizarMedicina(String nombre,double precio, String ingestion, String tiposMedicina, String dosis, String notasAdicionales, String enfermedad) {
		String mensaje = "";
		try {
			boolean bandera = false;
			int indice = 0;
			
			for(Medicina medicina: listadoMedicinas) {
				if(medicina.getNombre().equals(nombre)) {
					bandera = true;
					indice = listadoMedicinas.indexOf(medicina);
				}
			}
			
			if(bandera) {
				String query = "UPDATE medicinas  SET Precio ='" + precio + "', Ingestion ='" + ingestion + "', Tipo = '" + tiposMedicina + "', Dosis = '" + 
					dosis + "', NotasAdicionales = '" + notasAdicionales + "', Enfermedad ='" + enfermedad + "' WHERE  Nombre ='" + nombre + "';";
			
				manejarBD(query);
				
				listadoMedicinas.add(indice, new Medicina(nombre,precio,ingestion,tiposMedicina,dosis,notasAdicionales,enfermedad));
				mensaje = "Actualizacion exitosa";
			}
			else {
				mensaje = "Ninguna medcina coincide con el nombre ingresado. No se\npuede realizar la actualizacion. Intente de nuevo";
			}
		}
		catch(Exception e0) {
			mensaje = "Ocurrio un error durante el manejo de la base de datos, puede \n que haya ingresado mal un dato. En el precio solo ingrese numeros y decimales.\n"
					+ "No deje espacios en blanco. Intente de nuevo";
		}
		return mensaje;
	}
	

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
	 * @param dolorCabeza
	 * @param dolorEstomago
	 * @param vomito
	 * @param diarrea
	 * @param estornudo
	 * @param tos
	 * @param dolorGeneral
	 * @param faltaEnergia
	 * @return mensaje de probabilidad de enfermedades
	 * En base a los s[intomas ingresados por el usuario, el metodo determina las posibles enfermedades que padece con una probabilidad incluida
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
			mensaje = "No se ha encontrado ninguna enfermedad con este patron de sintomas.";
		}
		return mensaje;
	}
	
	
	/**
	 * @param query El query con las instrucciones para el maejo de la base de datos
	 * Permite Insertar, borrar o actualizar una tupla en una tabla de la base de datos
	 */
	private void manejarBD(String query){
        ConeccionBD BD = null;
        try{
            BD = new ConeccionBD("jdbc:mysql://localhost:3306/" + basededatos, "root", contrasena);
            BD.getNewConnection();

            Statement stQuery = BD.getCurrentConnection().createStatement();

            String queryManejo = query;
            stQuery.executeUpdate(queryManejo);
               
        }
        catch(Exception e0){
        	e0.printStackTrace();
        }
	}
	
	/**
	 * @param nombreEnf
	 * Toma el nombre de una enfermedad y borra la tupla de la base de datos que tenga este nombre
	 */
	public String borrarEnfermedad(String nombreEnf){
		String mensaje = "";
		
		boolean bandera = false;
		for(Enfermedad enfermedad: listadoEnfermedades) {
			if(enfermedad.getNombre().equals(nombreEnf.toLowerCase())){
				bandera = true;
			}
		}
		
		if(bandera) {
			String queryDelete = "DELETE FROM enfermedades WHERE Nombre = '" + nombreEnf + "'";
			manejarBD(queryDelete);
			mensaje = "Borrado exitoso";
		}
		else {
			mensaje = "Ningun nombre coincidio con el ingresado.\nIntente de nuevo";
		}
		
		return mensaje;
	}
	
	
		/**
		 * @param nombreMed
		 * Toma el nombre de la medicinay borra la tupla de la base de datos que tenga este nombre
		 */
		public String borrarMedicina(String nombreMed){
			String mensaje = "";
			
			boolean bandera = false;
			for(Medicina medicina: listadoMedicinas) {
				if(medicina.getNombre().equals(nombreMed.toLowerCase())) {
					bandera = true;
				}
			}
			if(bandera) {
				String queryDelete = "DELETE FROM medicinas WHERE Nombre = '" + nombreMed + "'";
				manejarBD(queryDelete);
				mensaje = "Borrado exitoso";
			}
			else {
				mensaje = "Ningun nombre coincidio con el ingresado.\nIntente de nuevo";
			}
			
			return mensaje;
	}
		
		/**
		 * @param nombre
		 * @param dolorCabeza
		 * @param dolorEstomago
		 * @param vomito
		 * @param diarrea
		 * @param estornudo
		 * @param tos
		 * @param dolorGeneral
		 * @param faltaEnergia
		 * @param notasAdicionales
		 * Este metodo actualiza una enfermedad de la base de datos
		 */
		public String acualizarEnfermedad(String nombre,boolean dolorCabeza, boolean dolorEstomago, boolean vomito, boolean diarrea, boolean estornudo, boolean tos, boolean dolorGeneral, boolean faltaEnergia, String notasAdicionales,String medicina) {
			String notificacion = "";
			try {
				boolean seguir = false;
				int indice = 0;
				
				for(Enfermedad enfermedad: listadoEnfermedades) {
					if(enfermedad.getNombre().equals(nombre)) {
						seguir = true;
						indice = listadoEnfermedades.indexOf(enfermedad);
					}
				}
				
				if(seguir) {
					String query = "UPDATE enfermedades  SET DolorCabeza ='" + dolorCabeza + "', DolorEstomago ='" + dolorEstomago + "', Vomito = '" + vomito  + "', Diarrea = '" + 
						diarrea + "', Estornudo = '" + estornudo + "', Tos ='" + tos + "', DolorGeneral ='" + dolorGeneral + "', FaltaEnergia ='" + faltaEnergia +  "', NotasAdicionales ='" + notasAdicionales + "', Medicina ='" + medicina + "' WHERE  Nombre ='" + nombre + "';";
				
					manejarBD(query);
					
					listadoEnfermedades.add(indice, new Enfermedad(nombre, dolorCabeza ,dolorEstomago , vomito, diarrea,estornudo, tos, dolorGeneral, faltaEnergia, notasAdicionales, medicina));
					notificacion = "La actualizacion se ha completado";
				}
				else {
					notificacion = "El nombre no coincide con niguna enfermedad actual, ingrese de nuevo.";
				}
			}
			catch(Exception e0) {
				notificacion = "Ocurrio un error durante el manejo de la base de datos, puede \n que haya ingresado mal un dato. En el precio solo ingrese numeros y decimales.\n"
						+ "No deje espacios en blanco. Intente de nuevo";
			}
			return notificacion;
		}
		//
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
			
			return NombreBusc;
		}
}

 