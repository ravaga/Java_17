package com.curso;

public class ArrayListChungo {

	private Object[] elementos;
	private int contador;

	public ArrayListChungo() {
		super();
		elementos = new Object[20];
	}
	
	public ArrayListChungo(int size) {
		super();
		elementos = new Object[size];
	}
	
	public void add(Object elemento) {
		//Comprobar que hay sitio en el array...
		elementos[contador] = elemento;	
		contador++;
	}
	
	public Object get(int posicion) {
		//Comprobar que hay sitio en el array...
		return elementos[posicion];		
	}	
	
	public int size() {
		return contador;
	}
}
