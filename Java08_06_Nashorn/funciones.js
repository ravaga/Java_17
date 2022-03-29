//En JS las funciones son OBJETOS
var calcular = function(n1, n2){	
	return n1+n2;
}

var formatear = function(s1, s2){
	return s1+"="+s2;
}

var funcion = function (persona){
	
	persona.nombre = persona.nombre.toUpperCase();
	print("JS:"+persona.nombre);	

	//No es necesario este return puesto que nos han pasado la persona por referencia
	return persona;
}








