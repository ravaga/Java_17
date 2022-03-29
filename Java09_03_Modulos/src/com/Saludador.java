package com;

import com.curso.Util;

public class Saludador {

	public String saludar(String nombre) {
		System.out.println("Llamando a Util.metodo desde Saludador");
		Util u = new Util();
		u.metodo();
		return "Hola "+nombre;
	}
	
}
