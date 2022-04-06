import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;


public class Pruebas {

	public static void main(String[] args) {
		
		//Hasta java6 ciertos recursos ajenos a la JVM hay que cerrarlos
		//en un finally para estar seguros de liberarlos 		
			
		
		FileWriter fw = null;		
		try {
			fw = new FileWriter("texto.txt");
			fw.write("Datos de vital importancia\n");
			
			//Esto está fatal
			//fw.close();			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
		
		
		//En java 7 hay un nuevo bloque try en cuya declaracion podemos
		//reservar recursos que implementen la nueva interfaz 'Closeable'
		//Cuando se abandona el try automanticamente se llama a 'close'
		//Limitación: No podemos declarar las variables antes del try
		//No sirve para conexiones al directorio JNDI
		try (
			ClaseAutoCerrable obj = new ClaseAutoCerrable();
			FileWriter        fw2 = new FileWriter("texto2.txt");
			BufferedWriter    bw  = new BufferedWriter(fw2);
		){
			bw.write("Toma ya!\n");
		} catch(IOException e){
			e.printStackTrace();
		} 
		
		//Limitación: No podemos declarar las variables antes del try
		//Si lo necesitamos de verdad podemos hacer esto...
		ClaseAutoCerrable obj = new ClaseAutoCerrable();
		try ( ClaseAutoCerrable obj2 = obj ){
			obj2.saludar();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
		
	}
	
}


class ClaseAutoCerrable implements Closeable{

	public void saludar() {
		System.out.println("Hola");
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("Cerrando la clase auto cerrable");
	}
	
}






