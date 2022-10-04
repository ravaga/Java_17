package com.curso.dos;

//No podemos implementar dos interfaces que tengan un método default llamado igual
public class ClaseQueImplementaDosInterfaces implements InterfazA, InterfazB {
	
	//Si sucede tal cosa sobreescribimos el método y no utilizamos ninguno de los métodos default
	@Override
	public void metodo(){
//		InterfazA.super.metodo();
		System.out.println("Implementacion de método en la clase");
	}
	
	//No hay problema con los metodos estáticos porque en java 8 si queremos acceder a un método estático
	//debemos usar el nombre de la interfaz
	
}













