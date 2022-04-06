package com;

public class Pruebas {

	public static void main(String[] args) {
		
		
		System.out.println("============================");
		String txt4 = "111\n222\n333\n444\n555\n666";
		txt4.lines().forEach(txt -> System.out.println(txt));
		
		System.out.println("============================");
		String txt1 = "";
		String txt2 = "   ";
		validar(txt1);
		validar(txt2);
		
		System.out.println("============================");
        String s1 = "\t abc \n";
        String s2 = s1.trim();
        String s3 = s1.strip();
        
        System.out.println(":"+s2+":");
        System.out.println(":"+s3+":");
        System.out.println(s2.equals(s3));
        
        Character c = '\u2000'; //Caracter equivalente al espacio
        String s4 = c + "hola" + c;
        String s5 = s4.trim();
        String s6 = s4.strip();
		System.out.println(":"+s5+":");
		System.out.println(":"+s6+":");
		
		//stripLeading()
		//stripTailing()
		
		System.out.println("============================");
		String str1 = "va ja";
		String str2 = str1.repeat(6);
		System.out.println(str2);
		
	}
	
	public static void validar(String txt) {
		
		//if(txt.trim().length()==0) {
		//	System.out.println("Cadena vacía");
		//}
		
		if(txt.isEmpty()) {
			System.out.println("Java 10: cadena de longitud 0");
		}

		if(txt.isBlank()) {
			System.out.println("Java 10: cadena vacía");
		}
		
	}
	
}
