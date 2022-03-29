package _1_Thread;

public class CaballoThread extends Thread {

	private String nombre;
	
	public CaballoThread(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {

		for(int a=0; a<=100; a++){
			System.out.printf("Soy el caballo %10s y he recorrido %d\n", nombre, a);
		}
		
	}

}
