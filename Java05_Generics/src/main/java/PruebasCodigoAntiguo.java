import java.util.ArrayList;
import java.util.List;


public class PruebasCodigoAntiguo {

	public static void main(String[] args) {
		
		//Cuando una clase que tiene generics se utiliza son sustituir los huecos
		//los huecos se tratan como Object:
		
		List lista = new ArrayList();
		lista.add("HOLA");
		lista.add(50); //ADMITE CUALQUIER OBJETO
		
		Veterinario v = new Veterinario();
		v.tratarAnimal(new Pajaro());
		v.tratarAnimal(new Gato());
		
		Veterinario<Perro> v2 = new Veterinario<Perro>();
		//v2.tratarAnimal(new Pajaro());
		//v2.tratarAnimal(new Gato());
		
		
		List<Perro> jauria = new ArrayList<Perro>();
		metodo(jauria);
		
		List lista2 = new ArrayList();
		metodo(lista2); //Cuidado, que deja 
		
		metodo2(lista2);
		metodo2(jauria);
		
	}
	
	public static void metodo(List<Perro> jauria){
		
	}
	
	public static void metodo2(List bichejos){
		
	}
	
}
