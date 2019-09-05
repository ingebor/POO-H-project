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

public class CatalogoSalud {
	private List <Enfermedad> listadoEnfermedades;
	private List <Medicina> listadoMedicinas;
	
		
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
	 * @param Agrega una medicina en la lista del array de medicinas 
	 * 
	 */
	public void agregarMedicina(Enfermedad nombre, Enfermedad precio, Enfermedad ingestion, Enfermedad tipoMedicina, Enfermedad dosis, Enfermedad notasAdicionales, int i)
	{	
		listadoEnfermedades.add(i, nombre);
		listadoEnfermedades.add(i, precio);// 
		listadoEnfermedades.add(i, ingestion);
		listadoEnfermedades.add(i, tipoMedicina);
		listadoEnfermedades.add(i, notasAdicionales);
		listadoEnfermedades.add(i, dosis);
	
	}
	
	/**
	 * @param Agrega una enfermedad en la lista del array de enfermedades 
	 * 
	 */
	public void agregarEnfermedad(Enfermedad nombre, Enfermedad dolorCabeza, Enfermedad dolorEstomago, Enfermedad vomito, Enfermedad diarrea, Enfermedad estornudo, Enfermedad tos, Enfermedad dolorGeneral, Enfermedad faltaEnergia, int i)
	{
		listadoEnfermedades.add( nombre);
		listadoEnfermedades.add(i, dolorCabeza);
		listadoEnfermedades.add(i, dolorEstomago);
		listadoEnfermedades.add(i, vomito);
		listadoEnfermedades.add(i, diarrea);
		listadoEnfermedades.add(i,estornudo);
		listadoEnfermedades.add(i,tos);
		listadoEnfermedades.add(i,dolorGeneral);
		listadoEnfermedades.add(i, faltaEnergia);
	
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
	 * Este metodo llena tanto el listado de enfermedades como de medicinas al crear un catalogoSalud
	 */
	private void llenarCatalogo()  {
		Enfermedad enfermedad;
		Medicina medicina;
		
		try {
			BufferedReader brE = new BufferedReader(new FileReader("Enfermedades.csv"));
			BufferedReader brM = new BufferedReader(new FileReader("Medicinas.csv"));
			
			
			String lineE = brE.readLine();
			String lineM = brM.readLine();
			
			while (lineE != null) {
				String[] AtributosEnf = lineE.split(",");
				
				
				enfermedad = new Enfermedad(AtributosEnf[0],Boolean.parseBoolean(AtributosEnf[1]),Boolean.parseBoolean(AtributosEnf[2]),Boolean.parseBoolean(AtributosEnf[3])
						,Boolean.parseBoolean(AtributosEnf[4]),Boolean.parseBoolean(AtributosEnf[5]),Boolean.parseBoolean(AtributosEnf[6]),Boolean.parseBoolean(AtributosEnf[7])
						,Boolean.parseBoolean(AtributosEnf[8]),AtributosEnf[9]);
				
				listadoEnfermedades.add(enfermedad);

	            lineE = brE.readLine();
			}
			
			while (lineM != null) {
				String[] AtributosMed = lineM.split(",");
				
				medicina = new Medicina(AtributosMed[0],Double.parseDouble(AtributosMed[1]), AtributosMed[2], AtributosMed[3], AtributosMed[4],AtributosMed[5]);
				
				listadoMedicinas.add(medicina);
				
	            lineM = brM.readLine();
			}
			
			brE.close();
			brM.close();
			
			
		}catch(Exception e) {
			
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
		int indice = 0;
		for (Medicina buscandoMed: listadoMedicinas) {
			if (nombreMed.equals(buscandoMed.getNombre())){
				indice = listadoMedicinas.indexOf(buscandoMed);
			}
		}
		
		Medicina medMostrar = listadoMedicinas.get(indice);
		return medMostrar.toString();
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
		Medicina Nmedicina = new Medicina(nombre,precio,ingestion,tiposMedicina,dosis,notasAdicionales);
		int indice = 0;
		int i = 0;
		boolean bandera = false;
		
		for(Medicina medicina:listadoMedicinas) {
			if(nombre.equals(medicina.getNombre())) {
				indice = listadoMedicinas.indexOf(medicina);	
				bandera = true;
			}
			i++;
		}
		
		if (bandera == true) {
			listadoMedicinas.remove(indice);
			listadoMedicinas.add(indice,Nmedicina);
			
			llenarCsvMed();
			
			
		}
		else {
			
		}
		
		
		
	}
	
	/**
	 * Este metodo reescribe el csv
	 */
	private void llenarCsvMed() {
		
		try {
			FileWriter pencil = new FileWriter("Medicinas.csv");
			PrintWriter pw = new PrintWriter(pencil);
			String texto = "";
			
			for(Medicina Nmedicina: listadoMedicinas) {
				texto += Nmedicina.getNombre() + "," + String.valueOf(Nmedicina.getPrecio()) + "," + Nmedicina.getIngestion() + ","
					+ Nmedicina.getTiposMedicina() + "," + Nmedicina.getDosis() + "," + Nmedicina.getNotasAdicionales() + "\n";
			}
				
			pw.write(texto);
			pw.close();
				
		}catch (Exception e) {
			System.out.println("Ocurrio un error al escribir en el csv");
		}
		
	}
	
	
}
