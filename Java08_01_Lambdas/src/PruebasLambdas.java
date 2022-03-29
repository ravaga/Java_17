import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.swing.JButton;

public class PruebasLambdas {

	
	
	private static void insertar() {
		//Método de palo
	}	
	
	public static void main(String[] args) {
		
		//
		//Cases internas anónimas
		//
		
		JButton boton = new JButton("Dale");		
		
		//Definiendo el oyente con una clase interna anónima
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón pulsado");
			}
		};
		boton.addActionListener(al);
		
		//Igual, pero sin usar una variable intermedia
		JButton boton2 = new JButton("Dale más");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón pulsado");
			}
		});
		
		//
		//Expresiones lambda
		//
		
		JButton boton3 = new JButton();
		ActionListener oyenteBotonInsertar = e -> insertar();
		boton3.addActionListener(oyenteBotonInsertar);
			
		//Mejor todavía (sin variable):
		boton3.addActionListener( e -> insertar() );
		
		
		//
		//EXPRESIONES LAMBDA
		//		
		System.out.println("========================");
		Reloj r1 = new Reloj() {
			public void decirHora() {
				System.out.println(new Date());
			}
		};
		r1.decirHora();
		
		//Cuando el método no recibe parámetros los parentesis son obligatorios
		//Cuando el metodo solo tiene una línea nos podemos ahorrar las llaves del método		
		Reloj r2 = () -> System.out.println(new Date());
		r2.decirHora();			
		
		
		System.out.println("========================");
		Saludador s1 = new Saludador() {
			public void saludar(String nombre) {
				System.out.println("Hola "+nombre);
			}
		};
		s1.saludar("Luis Ramón");
		
		//Cuando el método recibe un único parámetro se pueden quitar los parentesis
		Saludador s2 = nombre -> System.out.println("Hola "+nombre);
		s2.saludar("Luis Ramón");

		
		System.out.println("========================");
		Calculador c1 = new Calculador() {
			public void calcular(Double n1, Double n2) {
				System.out.println(n1+n2);
			}
		};
		c1.calcular(25d, 500d);
		
		//Cuando se recibe más de un parámetro los parentesis vuelven a ser obligatorios
		Calculador c2 = (n1, n2) -> System.out.println(n1+n2);
		c2.calcular(25d, 500d);
		
		
		System.out.println("========================");
		Formateador f1 = new Formateador() {
			public String formatear(String dato1, String dato2) {
				return dato1+"+"+dato2;
			}
		};		
		System.out.println(f1.formatear("aaa", "bbb"));
		
		//Cuando quitamos las llaves del método el return es IMPLÍCITO
		Formateador f2 = (dato1, dato2) -> dato1+"+"+dato2;
		System.out.println(f2.formatear("AAA", "BBB"));
						

		//
		//¿Son closures las expresiones lambda de java?
		//
		//NO
		
		/*
		int m1 = 25;		
		Consumer<Integer> multiplicador25 = m2 -> {
			//m1++;
			System.out.println(m1*m2);
		};
		
		
		multiplicador25.accept(10);
		multiplicador25.accept(20);		
		
		System.exit(0);
		*/
		
		
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
		
		System.exit(0);
		
	}

}


//
//Interfaces funcionales: solo tienen un método
//

//
//La anotación @FunctionalInterface indica al compilador que debe comprobar que efectivamente se trata
//de una interfaz con un único método
//
@FunctionalInterface
interface Reloj{
	public void decirHora();
	//public void decirHora2();
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




