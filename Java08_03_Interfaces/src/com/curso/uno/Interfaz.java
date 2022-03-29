package com.curso.uno;

public interface Interfaz {

	public static final int DATO = 20;
	
	public abstract void metodo();
	
	//Métodos default
	default void saludar(){
		System.out.println("hola"); //Anatema!
		//throw new RuntimeException("Esto no está implementado todavía");
	}
	
	/////////////////////////////////////////////
	
	//Métodos estáticos
	//Siempre con su implementacion
	public static void metodoEstatico(){
		System.out.println("Método estático");
	}	
	
}

