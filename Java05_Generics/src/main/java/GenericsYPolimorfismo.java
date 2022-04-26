import java.util.ArrayList;
import java.util.List;


public class GenericsYPolimorfismo {

	public static void main(String[] args) {
		
		Animal a = new Perro();
		
		//Esto no lo permiten. No estamos hablando de que los perros
		//son animales, sino de que en una lista se admiten solo perros
		//List<Animal> aa = new ArrayList<Perro>();
		
		//Los dos lados de la asignacion tienen que ser iguales		
		
	}
	
	
	
}
