package _4_WaitNotify;

public class Consumidor implements Runnable {

	private String nombre;
	private Cola cola;

	public Consumidor(String nombre, Cola cola) {
		super();
		this.nombre = nombre;
		this.cola = cola;
	}

	public void run(){
		
		for(int a=0; a<10; a++){
			String mensaje = cola.getMensaje();
			System.out.println(nombre+":"+mensaje);
		}	
		
	}
	
}
