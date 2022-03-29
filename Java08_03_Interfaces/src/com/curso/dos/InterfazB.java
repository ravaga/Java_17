package com.curso.dos;

public interface InterfazB {

	default void metodo(){
		System.out.println("METODO EN INTERFAZ_B");
	}
	
	static void metodoEstatico() {
		System.out.println("METODO ESTÁTICO EN INTERFAZ_B");
	}	
	
}

