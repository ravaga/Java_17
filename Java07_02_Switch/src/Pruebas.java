import java.util.Scanner;


public class Pruebas {

	public static void main(String[] args) {
		
		int numero = 3;
		final int opcionDinamica = 500;
		switch(numero) {
			case 0 : // 
			case 1 : // 
			case 2 : // 
			case opcionDinamica : //
		}
				
		Scanner sc = new Scanner(System.in);
		System.out.println("Escoja una opcion (uno, dos, tres)");
		String opcion = sc.nextLine();

		final String xxx = "uno";
		
		//En java 7 se puede usar un String en un switch aparte de int (o byte) y char
		//Es case sensitive!
		switch(opcion){
		
			//case xxx : System.out.println("NO COMPILA");
			//		     break;
		
			case "uno"  : System.out.println("Opcion uno!");
			     		  break;
			case "dos"  : System.out.println("Opcion dos!");
						  break;
			case "tres" : System.out.println("Opcion tres!");
			              break;
			default : System.out.println("No es tan dificil...");
		}
		
		sc.close();
		
	}
	
}
