

import java.util.ArrayList;
import java.util.List;

import com.curso.ArrayListChungo;
import com.curso.ArrayListChungoConGenerics;

public class Pruebas {

	public static void main(String[] args) {
	
		ArrayListChungo palabras = new ArrayListChungo();
		
		palabras.add("Siete");
		palabras.add("caballos");
		palabras.add("vienen");
		palabras.add("de");
		palabras.add("Bonanza");
		
		for(int a=0; a<palabras.size(); a++) {
			//El cast es necesario
			String palabra = (String) palabras.get(a);
			System.out.println(palabra);
		}
		
		ArrayListChungoConGenerics<String> palabras2 = new ArrayListChungoConGenerics<String>();
		
		palabras2.add("Siete");
		palabras2.add("caballos");
		palabras2.add("vienen");
		palabras2.add("de");
		palabras2.add("Bonanza");
		//palabras2.add(new Integer(1000));
		
		for(int a=0; a<palabras2.size(); a++) {
			String palabra = palabras2.get(a);
			System.out.println(palabra);
		}		
		
	}
	
}
