/*En el mundo de las aves todas tienen un peso, existen algunas aves como el pinguino que no puede volar 
 * y otras como el aguila que vuela a 100 km/h
Escribir por la consola estándar los km/hora y el peso de las aves*/

public class Solucion {
	
	public static void main(String args[]) {
		printVoladoras(new Aguila(), System.out::println);
//		printVoladoras(new Pinguino(), System.out::println); // Da error pq un Pinguino no vuela
		
		printPeso(new Aguila(), System.out::println);
		printPeso(new Pinguino(), System.out::println);
	}
	
	static void printVoladoras(Vuelo vuelo, Writer writer) {
		writer.write("Vuelo a " + vuelo.getVelocidad());
	}
	
	static void printPeso(Peso	peso, Writer writer) {
		writer.write("Peso " + peso.getPeso());
	}
}
