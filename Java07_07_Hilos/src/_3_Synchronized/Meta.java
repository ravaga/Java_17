package _3_Synchronized;

import java.util.ArrayList;
import java.util.List;

public class Meta {

	//
	//CUIDADO CON ARRAY LIST QUE NO ES THREAD SAFE!
	//
	private List<CaballoRunnable> clasificacion = new ArrayList<>();
 	
	//Sincronizando el método impedimos que entre más de un hilo a la vez
	public synchronized void apuntar(CaballoRunnable caballo){
		
		clasificacion.add(caballo);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(caballo.getNombre()+": Pos "+clasificacion.size());
		
	}	
	
	
	public void apuntar2(CaballoRunnable caballo){
		
		//
		//
		//
		//
		//Aqui tambien serviría 'clasificacion'
		synchronized (this) {
			clasificacion.add(caballo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(caballo.getNombre()+": Pos "+clasificacion.size());
		}
		//
		//
		//
		//
		
	}	
	
}
