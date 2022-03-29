import java.io.Serializable;

public class ArrayListChungo<E> {

	private Object[] elementos;
	private int contador;
	
	public ArrayListChungo() {
		super();
		elementos = new Object[20];
	}

	public ArrayListChungo(int tam) {
		super();
		elementos = new Object[tam];
	}
	
	public void add(E obj) {
		elementos[contador] = obj;
		contador++;
		//if (contador==elementos.length)
	}
	
	@SuppressWarnings("unchecked")
	public E get(int pos) {
		return (E) elementos[pos];
	}
	
}
