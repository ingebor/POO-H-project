
public class p {
	public static void main(String []args) {
		CatalogoSalud c = new CatalogoSalud();
		c.pruebaListas();
		
		System.out.println("Todo bien");
		
		c.acualizarMedicina("pepto", 2.5, "oral", "no", "1000 gramos", "no hay");
		c.pruebaListas();
	}
}
