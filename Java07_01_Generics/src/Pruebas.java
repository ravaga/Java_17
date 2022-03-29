import java.util.ArrayList;
import java.util.List;


public class Pruebas {
	
	public static void main(String[] args) {
		
		//Hasta java6
		List<String> listaJ5 = new ArrayList<String>();

		//En java 7 podemos ahorrarnos el tipo en el segundo término de la asignación
		List<String> listaJ7 = new ArrayList<>();
		
		
		ArrayListChungo<String> palabras = new ArrayListChungo<>();
		palabras.add("Hola");
		palabras.add("que");
		palabras.add("tal");
		System.out.println(palabras.get(0));
		System.out.println(palabras.get(1));
		System.out.println(palabras.get(2));

		//Compatibilidad hacia delante. 
		//Si no se indica el tipo se usa Object (y da warning)
		ArrayListChungo otro = new ArrayListChungo();
		otro.add("AAA");
		
		Veterinario vete = new Veterinario();
		List<Perro> perros = new ArrayList<>();	
		perros.add(new Perro());
		perros.add(new Perro());
		perros.add(new Perro());
		
		vete.curar(perros);
		
		List<Gato> gatos = new ArrayList<>();	
		gatos.add(new Gato());
		gatos.add(new Gato());
		gatos.add(new Gato());		
		
		vete.curar(gatos);
	}	

}

class Animal { }

class Perro extends Animal { }

class Gato extends Animal {	}

class Veterinario {
	
	public void curar(Animal a) {
		
	}
	
	//Este método no admite una lista de perros o una lista de gatos (List<Perro> o List<Gato>)
	/*
	public void curar(List<Animal> animales) {
		
	}
	*/
	
	//Si declaramos el tipo de la lista (o cualquier otro parametro genérico) con la ?
	//se inferirá el tipo en el momento en el que se invoque
	public void curar(List<? extends Animal> animales) {
		
	}

}















