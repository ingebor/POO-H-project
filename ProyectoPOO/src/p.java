
public class p {
	public static void main(String []args) {
		CatalogoSalud c = new CatalogoSalud();
		System.out.println(c.verEnfermedad("Gripe"));
		System.out.println(c.VerMedicina("Pepto"));
		System.out.println(c.buscarEnfermedad(true, true, true, true, true, true, true, true));
		c.acualizarMedicina("Pepto", 12.9, "oral", "pastilla", "10", "Prueba de actualizacion", "Diarrea");
	}
	//Esto es una prueba
	
}
