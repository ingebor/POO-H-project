import java.util.ArrayList;
public class CatalogoSalud {
	private ArrayList<Enfermedad>enfermedades;
	private ArrayList<Medicina>medicinas;
	
	/**
	 * @param Constructor de la clase CatalogoSalud
	 */
	public CatalogoSalud()
	{
		enfermedades = new ArrayList<Enfermedad>();
		medicinas = new ArrayList<Medicina>();
	}
	
	
	/**
	 * @param Agrega una medicina en la lista del array de medicinas 
	 * 
	 */
	public void agregarMedicina(Medicina nuevaMedicina, int i)
	{	
		medicinas.add(i, nuevaMedicina);	
	}
	
	/**
	 * @param Agrega una enfermedad en la lista del array de enfermedades 
	 * 
	 */
	public void agregarEnfermedad(Enfermedad nuevaEnfermedad, int i)
	{
		enfermedades.add(i,nuevaEnfermedad);
	}
	
	
	/**
	 * @param Actualiza una enfermedad, para agregar mas informacion, nuevos sintomas o el nombre de la enen la lista del array de enfermedades 
	 * 
	 */
	public void ActualizarEnfermedad(Enfermedad enfermedadActualizado, int i) {
		if(i<=enfermedades.size() && enfermedades.get(i) != null)
			enfermedades.add(i, enfermedadActualizado);
	}
	

	 
	
	
	
		
}
