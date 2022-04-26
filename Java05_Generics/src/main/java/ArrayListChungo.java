
public class ArrayListChungo<T> {

	Object[] elementos= new Object[20];
	int pos = 0;
	
	public void add(T obj){
		elementos[pos] = obj;
		pos++;
	}
	
	public T get(int pos){
		return (T) elementos[pos];
	}
	
	
}
