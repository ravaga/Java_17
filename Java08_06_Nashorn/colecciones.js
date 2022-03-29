var Persona = Java.type("com.curso.modelo.entidad.Persona");
var ArrayList = Java.type("java.util.ArrayList");

var crearPersonasArrayList = function(){
	
	//podemos ahorrarnos el java.type para java.util
	//var personas = new java.util.ArrayList();
	var personas = new ArrayList();
	p1 = new Persona();
	p1.nombre    = "n1";
	p1.direccion = "d1";
	p1.telefono  = "t1";
	p2 = new Persona();
	p2.nombre    = "n2";
	p2.direccion = "d2";
	p2.telefono  = "t2";
	p3 = new Persona();
	p3.nombre    = "n3";
	p3.direccion = "d3";
	p3.telefono  = "t3";
	
	personas.add(p1);
	personas.add(p2);
	personas.add(p3);	
	
	return personas;
}