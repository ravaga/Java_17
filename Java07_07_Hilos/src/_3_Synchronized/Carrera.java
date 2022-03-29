package _3_Synchronized;

public class Carrera {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getId());
		
		Meta m = new Meta();
		
		CaballoRunnable c1 = new CaballoRunnable("Rocinante",m);
		CaballoRunnable c2 = new CaballoRunnable("Bucefalo",m);
		CaballoRunnable c3 = new CaballoRunnable("Imperioso",m);
		
		//Esto se ejecuta secuencialmente. Llamar a 'run' no crea un hilo
		//c1.run();
		//c2.run();
		//c3.run();
		
		
		//1 [Main]
		
		
		Thread th1 = new Thread(c1);
		Thread th2 = new Thread(c2);
		Thread th3 = new Thread(c3);		
		
		//1
		
		th1.start();
		th2.start();
		th3.start();
		
		//1-4
		
		//Deprecated desde el minuto cero:
		//th1.stop();
	}
	
}
