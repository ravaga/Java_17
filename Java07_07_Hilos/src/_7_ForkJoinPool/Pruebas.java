package _7_ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Pruebas {

	public static void main(String[] args) {
		
		Integer[] datos = new Integer[20_000];
		for(int a=0; a<20_000; a++){
			datos[a] = (int) Math.round(Math.random()*10_00_000);
		}
		long inicio;
		long fin;
		Integer max;
		
		/*
		[ Th2                                                                                         ]
		[ Th2                                        ][ Th3                                           ]
		[ Th2                 ][ Th4                 ][ Th3                  ][ Th5                   ]
		[ Th2     ][ Th6      ][ Th4      ][ Th7     ][ Th3      ][ Th8      ][ Th5      ][ Th9       ]
				
		*/	
		
		/*
		 */
		inicio = System.currentTimeMillis();
		max = Integer.MIN_VALUE;
		for(int a=0; a<20_000; a++){
			if(datos[a]>max)
				max=datos[a];
			/*try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		fin = System.currentTimeMillis();
		System.out.println("Del tirón, max:"+max+", "+(fin-inicio)+" milisegundos");
		
		inicio = System.currentTimeMillis();
		
		
		BuscadorMax b = new BuscadorMax(datos, 0, datos.length);
		
		
		System.out.println("Procesadores disponibles:"+Runtime.getRuntime().availableProcessors());
		//ForkJoinPool fjp = new ForkJoinPool(2); //Usará dos procesadores
		ForkJoinPool fjp = new ForkJoinPool();    //Maximos procesadores disponibles
		System.out.println(fjp.getParallelism()); 
		max = fjp.invoke(b);
		fin = System.currentTimeMillis();
		System.out.println("Recursivo, max:"+max+", "+(fin-inicio)+" milisegundos");

	}

}

class BuscadorMax extends RecursiveTask<Integer> {

	private Integer[] datos;
	private int inicio;
	private int fin;

	public BuscadorMax(Integer[] datos, int inicio, int fin) {
		super();
		this.datos = datos;
		this.inicio = inicio;
		this.fin = fin;
	}

	@Override
	//run
	//call
	protected Integer compute() {

		if(fin-inicio<=1000){
			Integer max = Integer.MIN_VALUE;
			for(int a=inicio; a<fin; a++){
				if(datos[a]>max)
					max = datos[a];
				/*try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
			}
			return max;
		}

		int longitud = fin-inicio;
		int mitad = longitud/2;

		BuscadorMax izquierda = new BuscadorMax(datos, inicio, fin-mitad);
		BuscadorMax derecha   = new BuscadorMax(datos, inicio+mitad, fin);
		//Similar a Thread.start
		derecha.fork(); //Se crea un hilo nuevo
		//Podríamos lanzar izquierda en otro hilo y luego esperar a que los
		//dos finalizen y devuelvan el resultado
		//izquierda.fork();
		//return Math.max(izquierda.join(), derecha.join());

		//Pero creamos solo uno para procesar la parte derecha y la izquierda
		//que la procese el hilo que ya tenemos

		//Aqui izquierda.compute ni lanza hilo ni nada de nada
		return Math.max(izquierda.compute(), derecha.join());

	}

}
