package persistencia;

import java.util.List;

import modelo.Pelicula;

public abstract class AbstractDao<T,k> {
	
	public void insertar(T obj){
		//Codigo insert
		
		//NO SE PUEDEN UTILIZAR VARIABLES GENÉRICAS. SOLO DECLARARLAS!
		T variable1 = null; 
		//T variable2 = new T(); //NOOOOOO! ¿y si no se pueden crear objetos?
		variable1.toString(); //Los métodos de object nada mas
		
	}	
	
	public void modificar(T obj){
		//Codigo update
	}
	
	public void borrar(T obj){
		//Codido delete
	}
	
	public T buscar(k id){
		//Código select
		return null;
	}
	
	public List<T> listarTodos(){
		//Codigo select
		return null;
	}	
	
}
