import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;


public class _02_PruebasFiles {

	public static void main(String[] args) {
		
		//Casi todos los metodos de Path devuelven this y
		//podemos concatenar las llamadas
		Path p1 = Paths.get("texto1.txt").toAbsolutePath();
		Path p2 = Paths.get("ringorango.txt").toAbsolutePath();
		
		//Files es una clase de utilidad para trabajar con ficheros
		System.out.println("=================================================");
		//Tenemos una serie de metodos que antes estaban en la clase File
		System.out.println("Existe:"+Files.exists(p1)); //File.exists
		System.out.println("Existe:"+Files.exists(p2));
		System.out.println(Files.isExecutable(p1));
		System.out.println(Files.isReadable(p1));
		System.out.println(Files.isWritable(p1));
		
		try { //Nos obligan a capturar la excepción por si el path es falso
			System.out.println("Tamaño:"+Files.size(p1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Acceso a otros atributos del fichero
		//Dependiendo del sistema de archivos que tengamos los atributos son uno u otros
		//Accediendo a ellos NOS ESTAMOS ACOPLANDO AL SISTEMA OPERATIVO
		System.out.println("=================================================");
		BasicFileAttributes bfa; //Esta interfaz define los atributos básicos presentes en cualquier sistema de archivos
		PosixFileAttributes pfa; //Atributos de UNIX
		DosFileAttributes   dfa; //Atributos de MS-DOS 
		
		try {
			bfa = Files.readAttributes(p1, BasicFileAttributes.class);
			System.out.println(bfa.creationTime());
			System.out.println(bfa.lastAccessTime());
			System.out.println(bfa.isDirectory()); //File.isDirectory()
			System.out.println(bfa.isRegularFile());                    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("=================================================");
		//FileStore representa al sistema de archivos
		try {
			//En windows dependiendo de la unidad en la que esté el path tendremos unos resultados u otros
			FileStore fs = Files.getFileStore(p1); //El sistema de archivos en el que se encuentra p1
			System.out.println("Espacio total :"+( fs.getTotalSpace() / (1024*1024) ) );
			System.out.println(fs.getUnallocatedSpace() / (1024*1024) );
			System.out.println(fs.getUsableSpace() / (1024*1024) );
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("=================================================");
		Path p3 = Paths.get("texto1.txt").toAbsolutePath();		
		try { //Implica que ambos ficheros existen
			System.out.println("Mismo fichero:"+Files.isSameFile(p1, p3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		// Operaciones con ficheros
		//
		
		//Copia de ficheros
		System.out.println("=================================================");
		Path p4 = Paths.get("texto1.txt"); //Este existe
		Path p5 = Paths.get("texto2.txt"); //Este no

		try {
			Files.copy(p4, p5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			//Si ahora no reemplazamos lanza excepcion: el destino ya existe
			Files.copy(p4, p5, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Copy tambien trabaja con streams
		//Enviar un fichero por un socket...
		//Socket sk = new Socket("no se donde", 20000);
		//Files.copy(p1, sk.getOutputStream()); //Y hasta luego Lucas
		
		//Escribir en un fichero lo que nos llega por un inputStream
		//Files.copy(sk.getInputStream(), p1);  //Y ya está
		
		//Tenemos Files.move
		
		//Borrar fichero
		System.out.println("=================================================");
		Path p6 = Paths.get("texto2.txt");
		Path p7 = Paths.get("texto2.txt");
		Path p8 = Paths.get("texto2.txt");
		
		try {
			Files.delete(p6); //Funciona
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Files.delete(p7); //Falla: el fichero ya no existe
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Files.deleteIfExists(p8); //El fichero no existe, pero no falla
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
