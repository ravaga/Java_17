package com.curso;

public class ArrayListChungoConGenerics<E> {

	private Object[] elementos;
	private int contador;

	public ArrayListChungoConGenerics() {
		super();
		elementos = new Object[20];
	}
	
	public ArrayListChungoConGenerics(int size) {
		super();
		elementos = new Object[size];
	}
	
	public void add(E elemento) {
		//Comprobar que hay sitio en el array...
		elementos[contador] = elemento;	
		contador++;
	}
	
	public E get(int posicion) {
		//Comprobar que hay sitio en el array...
		return (E) elementos[posicion];		
	}	
	
	public int size() {
		return contador;
	}
}
