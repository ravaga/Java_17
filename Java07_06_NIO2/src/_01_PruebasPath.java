import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class _01_PruebasPath {

	public static void main(String[] args) {
		
		//Con java.io
		File f = new File("datos.txt");
		f.exists();
		f.canRead();
		f.getAbsolutePath();
		f.delete();
		f.isDirectory();
		
		//Con NIO usamos la clase Path
		//Path no representa un fichero, solo a la ruta		
		System.out.println("=======================================================");
		Path p1 = Paths.get("datos.txt");
		
		System.out.println("Absoluto:"+p1.isAbsolute()); //false
		System.out.println("toString:"+p1);

		//La clase path representa unicamente una ruta a un fichero.
		//Guarda esa ruta en una estructura de datos (file, como mucho, nos daba un string)
		Path p2 = Paths.get("dir1/dir2/patatin/patatan/fichero.txt");
		
		System.out.println("Num elementos:"+p2.getNameCount());
		System.out.println("Elemento 0:"+p2.getName(0));
		System.out.println("Elemento 3:"+p2.getName(3));

		
		System.out.println("=======================================================");
		//GetParent (y muchos otros métodos devuelven un path (this) )
		System.out.println("Parent    :"+p1.getParent());
		System.out.println("Parent    :"+p2.getParent().getParent());
		
		
		//GetRoot me dice en que unidad está el path (microsoft)
		//En unix nos dará siempre lo mismo: en unix solo hay un raiz
		System.out.println("Root      :"+p1.getRoot());
		System.out.println("Root      :"+p2.getRoot());
		
		
		System.out.println("=======================================================");
		//Path es Iterable
		for(Path aux: p2){
			System.out.println(aux);
		}
	
		
		System.out.println("=======================================================");
		//Puede que nos encontremos con una ruta que incluya información redundante
		Path p3 = Paths.get("c:\\dir1\\.\\dir2\\dir3\\..\\fichero.txt");
		//Los objetos del tipo path son inmutables
		p3.normalize();
		System.out.println(p3);
		p3 = p3.normalize();
		System.out.println(p3);
		

		System.out.println("=======================================================");
		System.out.println(p2.toUri());
		p1 = p1.toAbsolutePath();
		System.out.println(p1);
		System.out.println(p1.isAbsolute());
		//Obteniendo una parte del path
		System.out.println(p1.subpath(0, 2));
		
		System.out.println(p1.subpath(p1.getNameCount()-2,p1.getNameCount()));
		
		//Como obtener la ruta absoluta a partir de una relativa
		Path p4 = Paths.get("datos.txt");
		p4 = p4.toAbsolutePath();
		System.out.println(p4.getParent());
		System.out.println(p4.getRoot());

		//ToRealPath nos da la ruta real al fichero, y eso solo es posible
		//si el fichero existe. De ahi que nos obliguen a capturar IOException
		//Si el fichero existe el resultado es el mismo que si invocamos toAbsolutePath 
		System.out.println("=======================================================");
		Path p5 = Paths.get("datos.txt");
		
		try {
			p5.toRealPath();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		//Otros metodos...
		System.out.println("=======================================================");
		Path p6 = Paths.get("c:/dir1/dir2/patatin/patatan/fichero.txt");
		System.out.println("P2 == P6:"+p2.equals(p6));
		//Como si fuera un String
		System.out.println(p6.startsWith("c:\\dir1\\dir2"));
		//p6.endsWith("XXX")	
				
	}
	
}
