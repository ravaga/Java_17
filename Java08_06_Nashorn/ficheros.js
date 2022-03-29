//Podemos utilizar prácticamente cualquier clase del api de Java
var FileWriter = Java.type("java.io.FileWriter");

function escribir(){
	
	var writer = new FileWriter("datos.txt");
	writer.write("HOLA RADIOLA\n");
	writer.write("HOLA RAFAELA");
	writer.close();	
	
}


