
public class Pruebas {

	public static void main(String[] args) {
		
		int numero1 = 100000000;
		//Podemos utilizar guiones bajos en números grandes para evitar errores
		int arrea   = 100_000_000;
		
		double numero2 = 10_000.500_234;
		
		//Pero en realidad no comprueban nada...
		int numero3 = 1_0_0_0_0_0_0;
		
		System.out.println(numero1);
		System.out.println(arrea);
		System.out.println(numero2);
		System.out.println(numero3);
		
	}
	
}
