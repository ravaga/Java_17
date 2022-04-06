package com;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Pruebas {

	public static void main(String[] args) {
		
		System.out.println("============================");
		
		//Disponemos de expresiones lambda desde Java 8		
		BiConsumer<String, String> ejemplo1 = (s1, s2) -> System.out.println(s1+"-"+s2);
		ejemplo1.accept("Hola","Raffaella");
		
		//Disponemos de variables definidas con 'var' desde Java 10		
		var txt1 = "Uno";
		var txt2 = "Dos";
		
		//Ahora en Java 11 se puede utilizar var en los parámetros de las expresiones lambda
		BiConsumer<String, String> ejemplo2 = (var s1, var s2) -> System.out.println(s1+":"+s2);
		ejemplo2.accept("Hola","Radiola");
		
		//La utilidad de esto es...ninguna, pero al menos es consecuente con la adición de var en Java 10
		
		//No puede mezclarse con tipos
		//BiConsumer<String, String> ejemplo3 = (String s1, var s2) -> System.out.println(s1+":"+s2);
		
		//Tiene que colocarse en todos los parámetros
		//BiConsumer<String, String> ejemplo4 = (s1, var s2) -> System.out.println(s1+":"+s2);

		//No permite eliminar los parentesis
		Consumer<String> ejemplo5 = (var s) -> System.out.println(s);
		
	}
	
}
