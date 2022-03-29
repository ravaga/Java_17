import java.io.Serializable;
import java.util.List;

//No se puede sustituir un 'hueco' con un tipo primitivo
//Podemos controlar con qué se sustituyen los huecos
public interface InterfazDao<T extends Serializable, K> {

	void insertar(T obj);
	void modificar(T obj);
	void borrar(T obj);
	T buscar(K id);
	List<T> listar();
	
}
