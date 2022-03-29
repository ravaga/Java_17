var Persona = Java.type("com.curso.modelo.entidad.Persona");
var personas = Java.type("com.curso.modelo.entidad.Persona[]");

var crearPersonas = function(){
	
	//Esto parece una persona, pero no lo es!
	p = {
		'nombre'    : 'aaa',
		'direccion' : 'bbb',
		'telefono'  : 'ccc'
	};	
	
	var array = new personas(5);
	
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
	array[0] = p1;
	array[1] = p2;
	array[2] = p3;	
	//No podemos añadir algo que no sea una persona
	//array[3] = p;
	
	return array;
}























