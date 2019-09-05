import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

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
	public void agregarMedicina(Medicina nuevaMedicina, int i)
	{	
		listadoMedicinas.add(i, nuevaMedicina);	
	}
	
	/**
	 * @param Agrega una enfermedad en la lista del array de enfermedades 
	 * 
	 */
	public void agregarEnfermedad(Enfermedad nuevaEnfermedad, int i)
	{
		listadoEnfermedades.add(i,nuevaEnfermedad);
	}
	
	
	/**
	 * @param Actualiza una enfermedad, para agregar mas informacion, nuevos sintomas o el nombre de la enen la lista del array de enfermedades 
	 * 
	 */
	public void ActualizarEnfermedad(Enfermedad enfermedadActualizado, int i) {
		if(i<=listadoEnfermedades.size() && listadoEnfermedades.get(i) != null)
			listadoEnfermedades.add(i, enfermedadActualizado);
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
	private void llenarCatalogo() {
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
			System.out.println("Ocurrio un error al cargar los datos");
		}
	}
	 /**
	  * Este metodo permite ingresar el nombre de la enfermedad. 
	  */
	public List<Enfermedad> verEnfermedad(String nombre) {
		List<Enfermedad> enfermedadBusca = null;
		for (Enfermedad Enfermedad: listadoEnfermedades)
			if (Enfermedad.getNombre().equals(nombre)){
				enfermedadBusca: new Enfermedad(((Enfermedad) listadoEnfermedades).getNombre(), ((Enfermedad) listadoEnfermedades).isDolorCabeza(), ((Enfermedad) listadoEnfermedades).isDolorEstomago(), ((Enfermedad) listadoEnfermedades).isVomito(), 
						((Enfermedad) listadoEnfermedades).isDiarrea(), ((Enfermedad) listadoEnfermedades).isEstornudo(), ((Enfermedad) listadoEnfermedades).isTos(), ((Enfermedad) listadoEnfermedades).isDolorGeneral(), ((Enfermedad) listadoEnfermedades).isFaltaEnergia(),
						((Enfermedad) listadoEnfermedades).getNotasAdicionales());
				
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
	public String BuscarMed() {
		for (List<Medicina> x: listadoMedicinas) {
			if nombre.equals(x.getNombre){
				System.out.println(x)
			}
		}
	}
}
