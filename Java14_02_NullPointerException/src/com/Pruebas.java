package com;

public class Pruebas {
	
	public static void main(String[] args) throws Exception {

		String txt1 = "";
		String txt2 = null;
		String txt3 = "";
		
		//Ahora NullPointer exception dice en la traza cuál variable es nula 
		String txt4 = txt1.toUpperCase()+"-"+txt2.toUpperCase()+"-"+txt3.toUpperCase();
		
	}

}
