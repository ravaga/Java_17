import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;


public class _04_PruebasDirectorios {

	public static void main(String[] args) {
		
		//Recorrer un directorio
		
		Path p1 = Paths.get("c:\\windows");
		
		//Para recorer el contenido de un directorio necesitamos un objeto
		//del tipo DirectoryStream
		//Si lo creamos en el try lo cierran ellos solitos
		//Listando todo el directorio
		System.out.println("================================================");
		try ( DirectoryStream<Path> ds = Files.newDirectoryStream(p1) ){
			//DirectoryStream es iterable
			//ds.iterator()
			for(Path p : ds){
				System.out.printf("%10b %s\n", Files.isDirectory(p), p.getFileName());
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}

		
		
		//Listando con un 'glob', una expresion regular que se aplica al nombre del fichero
		System.out.println("================================================");
		/*
	    An asterisk, *, matches any number of characters (including none).
	    Two asterisks, **, works like * but crosses directory boundaries. This syntax is generally used for matching complete paths.
	    A question mark, ?, matches exactly one character.
	    Braces specify a collection of subpatterns. For example:
	        {sun,moon,stars} matches "sun", "moon", or "stars".
	        {temp*,tmp*} matches all strings beginning with "temp" or "tmp".
	    Square brackets convey a set of single characters or, when the hyphen character (-) is used, a range of characters. For example:
	        [aeiou] matches any lowercase vowel.
	        [0-9] matches any digit.
	        [A-Z] matches any uppercase letter.
	        [a-z,A-Z] matches any uppercase or lowercase letter.
	    Within the square brackets, *, ?, and \ match themselves.
	    All other characters match themselves.
	    To match *, ?, or the other special characters, you can escape them by using the backslash character, \. For example: \\ matches a single backslash, and \? matches the question mark.

	    *.html – Matches all strings that end in .html
	    ??? – Matches all strings with exactly three letters or digits
	    *[0-9]* – Matches all strings containing a numeric value
	    *.{htm,html,pdf} – Matches any string ending with .htm, .html or .pdf
	    a?*.java – Matches any string beginning with a, followed by at least one letter or digit, and ending with .java
	    {foo*,*[0-9]*} – Matches any string beginning with foo or any string containing a numeric value
		*/
		try ( DirectoryStream<Path> ds = Files.newDirectoryStream(p1,"Hola?*.exe") ){
			for(Path p : ds){
				System.out.printf("%10b %s\n", Files.isDirectory(p), p.getFileName());
			}
		} catch (IOException e){
			e.printStackTrace();
		}		
		
		//Cuando no nos sirve una expresión regular podemos crear un filtro
		System.out.println("================================================");

		//Lo mismo con expresiones lambda
		//try ( DirectoryStream<Path> ds = 
		//		Files.newDirectoryStream(p1, path -> path.getFileName().toString().endsWith(".exe") ) ){
			
		try ( DirectoryStream<Path> ds = Files.newDirectoryStream(p1, new Filtro() ) ){
			for(Path p : ds){
				System.out.printf("%10b %s\n", Files.isDirectory(p), p.getFileName());
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}		
		
	}
	
}

class Filtro implements Filter<Path>{
	@Override
	public boolean accept(Path path) throws IOException {
		//Esto está mal!!!
		//return path.getFileName().endsWith(".exe");
		return path.getFileName().toString().endsWith(".exe");
	}
	
}

