package com.curso.modelo;

public class Disco {

	private String titulo;

	public Disco() {
		super();
	}

	public Disco(String titulo) {
		super();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Disco [titulo=" + titulo + "]";
	}

}
