import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.swing.JButton;

public class PruebasLambdas {
	
	private static void insertar() {
		//M�todo de palo
	}
	
	private static Function<Integer, Integer> sum (final Integer a){
		return b->a+b;
	}
	
	public static void main(String[] args) {
		
		//
		//Cases internas an�nimas
		//
		
		JButton boton = new JButton("Dale");
		
		//boton.addActionListener(new OyenteBotonInsertar());

		
		//Definiendo el oyente con una clase interna an�nima
		//Definiendo el oyente con una clase interna an�nima
		//Una clase interna an�nima es
		//-una clase definida dentro de un m�todo
		//-Con constructor sin par�metros
		//-inaccesible desde el resto de la aplicaci�n
		//-se programan heredando de una clase o implementando una interfaz
		//-en un �nico movimiento definimos la clase y creamos el objeto		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println();
			}
		};
		boton.addActionListener(al);

		//Igual, pero sin usar una variable intermedia
		JButton boton2 = new JButton("Dale m�s");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bot�n pulsado");
			}
		});
		
		//
		//Expresiones lambda
		//

		JButton boton3 = new JButton();
		ActionListener oyenteBotonInsertar = e -> insertar();
		boton3.addActionListener(oyenteBotonInsertar);
			
		//Mejor todav�a (sin variable):
		boton3.addActionListener( e -> insertar() );
		
		
		//
		//EXPRESIONES LAMBDA
		//	
		
		//interface Reloj{
		//	public void decirHora();
		//}			
		System.out.println("========================");
		Reloj r1 = new Reloj() {
			public void decirHora() {
				System.out.println(new Date());
			}
		};
		r1.decirHora();
		
		//Cuando el m�todo no recibe par�metros los parentesis son obligatorios
		//Cuando el metodo solo tiene una l�nea nos podemos ahorrar las llaves del m�todo		
		
		Reloj r2 = () -> System.out.println(new Date());		
		r2.decirHora();			

		
		//interface Saludador{
		//	public void saludar(String nombre);
		//}
		System.out.println("========================");
		Saludador s1 = new Saludador() {
			public void saludar(String nombre) {
				System.out.println("Hola "+nombre);
			}
		};		
		s1.saludar("Luis Ram�n");
		
		//Podemos ahorrarnos el tipo de los par�metros
		//Cuando el m�todo recibe un �nico par�metro y no se indica el tipo se pueden quitar los parentesis 
		Saludador s2 = nombre -> System.out.println("Hola "+nombre);
		s2.saludar("Luis Ram�n");		

		

		//interface Calculador{
		//	public void calcular(Double n1, Double n2);
		//}		
		System.out.println("========================");
		Calculador c1 = new Calculador() {
			public void calcular(Double n1, Double n2) {
				System.out.println(n1+n2);
			}
		};
		c1.calcular(25d, 500d);

		//Cuando se recibe m�s de un par�metro los parentesis vuelven a ser obligatorios
		Calculador c2 = (n1, n2) -> System.out.println(n1+n2);
		c2.calcular(25d, 500d);

		//interface Formateador{
		//	public String formatear(String dato1, String dato2);
		//}
		System.out.println("========================");
		Formateador f1 = new Formateador() {
			public String formatear(String dato1, String dato2) {
				return dato1+"+"+dato2;
			}
		};		
		System.out.println(f1.formatear("aaa", "bbb"));

		//Cuando quitamos las llaves del m�todo el compilador a�ade un return IMPL�CITO
		Formateador f2 = (dato1, dato2) -> dato1+"+"+dato2;
		System.out.println(f2.formatear("aaa", "bbb"));
		
		
		//
		//�Son closures las expresiones lambda de java?
		//
		//NO: solo pueden utilizar variables declaradas fuera de ellas si son finales o 'efectivamente finales'
		//
		int m1=25;	
		Consumer<Integer> multiplicador25 = m2 -> {
			//m1++;
			System.out.println(m1*m2);
		};
			
		multiplicador25.accept(10);
		multiplicador25.accept(20);		
		
		//
		//Interfaces funcionales en el api de Java8
		//		
		System.out.println("===========================================");
		//consumer: public void accept(T t)
		//biconsumer: public void accept(T t, J j)
		Consumer<String> c = txt -> System.out.println("Consumer:"+txt);
		c.accept("Descanso!");	
		
		//predicate: public boolean test(T t)
		Predicate<String> filtro = txt -> txt.length()>10;
		
		boolean rs1 = filtro.test("HOLA");
		boolean rs2 = filtro.test("HOLA RADIOLA");
		System.out.println(rs1+","+rs2);

		//function
		//public Tipo1 apply(Tipo2 t)
		Function<String, String> transformacion = txt -> txt.toUpperCase();
		String txt = transformacion.apply("abcdefg");
		System.out.println(txt);
				
		//supplier
		//public T get()
		Supplier<Double> suplier = () -> Math.random();
		Double n = suplier.get();
		System.out.println(n);
		
		// ejercicio clase

		System.out.println(sum(5)); // imprime el método lambda
		System.out.println(sum(5).apply(6));
		
	}

}


/*
//Un oyente definido en su propia clase
//
class OyenteBotonInsertar implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		//Codigo...
	}
}
*/

//
//Interfaces funcionales: solo tienen un m�todo
//

//
//La anotaci�n @FunctionalInterface indica al compilador que debe comprobar que efectivamente se trata
//de una interfaz con un �nico m�todo
//
@FunctionalInterface
interface Reloj{
	void decirHora();
	//void decirHora2();
}

//Consumer
interface Saludador{
	public void saludar(String nombre);
}

interface Calculador{
	public void calcular(Double n1, Double n2);
}

interface Formateador{
	public String formatear(String dato1, String dato2);
}










