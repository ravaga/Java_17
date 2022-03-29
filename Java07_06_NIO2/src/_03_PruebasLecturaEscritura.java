import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class _03_PruebasLecturaEscritura {

	public static void main(String[] args) {
	
		try {
			Path p1 = Paths.get("texto1.txt");
			
			//Lectura de todo el contenido, bytes (cuidado con el tamaño)
			byte[] contenido = Files.readAllBytes(p1);

			//Lectura de todo el contenido, por lineas, texto			
			Charset c = Charset.forName("iso-8859-1");
			List<String> lineas = Files.readAllLines(p1, Charset.defaultCharset());
			System.out.println("=================================================");
			for(String linea: lineas){
				System.out.println(linea);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			
			Path p2 = Paths.get("texto2.txt"); //No existe
			Files.createFile(p2);
			
			List<String> lineas = new ArrayList<>();
			lineas.add("aaaaaaaaa");
			lineas.add("bbbbbbbbb");
			lineas.add("ccccccccc");
			lineas.add("ddddddddd");
			
			Files.write(p2, lineas,  Charset.defaultCharset());
			
			
		} catch (IOException e) {
			//e.printStackTrace();
		} 
		
		//Con buffer
		try {
			Path p3 = Paths.get("texto2.txt");
			BufferedReader br = Files.newBufferedReader(p3, Charset.defaultCharset());
			
			System.out.println("=================================================");
			while(br.ready()){
				System.out.println(br.readLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Se pueden seguir usando las clases de java.io, sobre todo Scanner
		//y PrintWritter
	}
	
}










