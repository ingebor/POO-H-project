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
	
	public Statement stQuery;
    public ResultSet rsRecords;
    
    public String basededatos = "bdpoo";
    public String contrasena = "infobi17";
    
	/**
	 * @param Constructor de la clase CatalogoSalud
	 */
	public CatalogoSalud()
	{

		listadoEnfermedades = new ArrayList<Enfermedad>();
		listadoMedicinas = new ArrayList<Medicina>();
		llenarCatalogo();
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
	public void agregarMedicina(String nombre, String precio, String ingestion, String tipoMedicina, String dosis, String notasAdicionales, String nombreEnf)
	{	
		String queryInsert = "INSERT INTO medicinas (Nombre, Precio, Ingestion, Tipo, Dosis, NotasAdicionales, Enfermedad) "
                + "VALUES ('" + nombre + "', '" + precio + "', '" + ingestion + "', '" + tipoMedicina + "', '" + dosis + "', '" + notasAdicionales + "', '" + nombreEnf + "') ";
		
        manejarBD(queryInsert);
	
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
			String estornudo, String tos, String dolorGeneral, String faltaEnergia, String notasAdicionales, String nombreMed)
	{
		String queryInsert = "INSERT INTO enfermedades (Nombre, DolorCabeza, DolorEstomago, Vomito, Diarrea, Estornudo, Tos, DolorGeneral, FaltaEnergia, NotasAdicionales, Medicina) "
                + "VALUES ('" + nombre + "', '" + dolorCabeza + "', '" + dolorEstomago + "', '" + vomito + "', '" + diarrea + "', '" + estornudo + "', '" + tos + "', '" + dolorGeneral + 
                "', '" + faltaEnergia + "', '" + notasAdicionales + "', '" + nombreMed + "') ";
		
        manejarBD(queryInsert);
	}
	
	
	/**
	 * @param Actualiza una enfermedad, para agregar mas informacion, nuevos sintomas o el nombre de la enen la lista del array de enfermedades 
	 * 
	 */
	public void ActualizarEnfermedad(String nombre, boolean dolorCabeza, boolean dolorEstomago, boolean vomito, boolean diarrea, boolean estornudo, boolean tos, boolean dolorGeneral, boolean faltaEnergia) {	
		int i = 0;
		for(int j = 0; j < listadoEnfermedades.size(); j++)
		{
			if (nombre.equals(listadoEnfermedades.get(i).getNombre()))
			{
				listadoEnfermedades.get(i).setNombre(nombre);
				listadoEnfermedades.get(i).setDolorCabeza(dolorCabeza);				
				listadoEnfermedades.get(i).setDolorEstomago(dolorEstomago);
				listadoEnfermedades.get(i).setVomito(vomito);
				listadoEnfermedades.get(i).setDiarrea(diarrea);
				listadoEnfermedades.get(i).setEstornudo(estornudo);
				listadoEnfermedades.get(i).setTos(tos);
				listadoEnfermedades.get(i).setDolorGeneral(dolorGeneral);
				listadoEnfermedades.get(i).setFaltaEnergia(faltaEnergia);
				// Necesito saber si no se usan todos los parametros.
			}
			else
				i++;
		}
	
	}
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
            
            listadoEnfermedades.clear();
            
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
	  * Este metodo permite ingresar el nombre de la enfermedad. 
	  */
	public List<Enfermedad> verEnfermedad(String nombre) {
		List<Enfermedad> enfermedadBusca = null;
		for (Enfermedad Enfermedad: listadoEnfermedades)
			if (Enfermedad.getNombre().equals(nombre)){
			enfermedadBusca.add(Enfermedad);
				
				enfermedadBusca = (List<Enfermedad>) Enfermedad;
			}
			if(enfermedadBusca != null) {
				if(((Enfermedad) listadoEnfermedades).getNombre().contentEquals(nombre)) {
					enfermedadBusca = listadoEnfermedades;
				}
			}
			return enfermedadBusca;
		}
	/**
	 * Este metodo permite buscar la medicina 
	 */
	
	public String BuscarMed(String nombreMed) {
		
		
		return "";
	}
	
	
	
	/**
	 * @param nombre
	 * @param precio
	 * @param ingestion
	 * @param tiposMedicina
	 * @param dosis
	 * @param notasAdicionales
	 * Este metodo actualiza un de las medicinas del csv
	 */
	public void acualizarMedicina(String nombre,double precio, String ingestion, String tiposMedicina, String dosis, String notasAdicionales) {
		
	}
	
	
	
	/*
	
	
	private void insert(String query){
	        ConeccionBD BD = null;
	        try
	        {
	            BD = new ConeccionBD("jdbc:mysql://localhost:3306/" + basededatos, "root", contrasena);
	            BD.getNewConnection();

	            Statement stQueryInsert = BD.getCurrentConnection().createStatement();

	            String queryInsert = query;
	            stQueryInsert.executeUpdate(queryInsert);
	               
	        }
	        catch(Exception e0)
	        {
	        	e0.printStackTrace();
	        }
	}
	 
	
	private void delete(String query){
	        ConeccionBD BD = null;
	        try
	        {
	            BD = new ConeccionBD("jdbc:mysql://localhost:3306/" + basededatos, "root", contrasena);
	            BD.getNewConnection();

	            Statement stQueryDelete = BD.getCurrentConnection().createStatement();

	            String queryDelete = query;
	            stQueryDelete.executeUpdate(queryDelete);
	        }
	        catch(Exception e0)
	        {
	            e0.printStackTrace();
	        }
	}
	 
	private void modificar(String query){
	        ConeccionBD BD = null;
	        try
	        {
	            BD = new ConeccionBD("jdbc:mysql://localhost:3306/" + basededatos, "root", contrasena);
	            BD.getNewConnection();

	            Statement stQueryUpdate = BD.getCurrentConnection().createStatement();

	            String queryUpdate  = query;
	            stQueryUpdate.executeUpdate(queryUpdate);
	        }
	        catch(Exception e0)
	        {
	            e0.printStackTrace();
	       }
	 }
	*/
	
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
}
 