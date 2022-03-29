
public class ArrayListEjemploGenerics_<E> {

	private Object[] elems;
	private int contador;
	
	public ArrayListEjemploGenerics_() {
		super();
		elems = new Object[20];
	}
	
	public ArrayListEjemploGenerics_(int tam) {
		super();
		elems = new Object[tam];
	}
	
	public void add(E elem){
		elems[contador] = elem;
		contador++;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int pos){
		return (E) elems[pos];
	}
	
}




