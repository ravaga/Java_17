import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Pruebas {

	public static void main(String[] args) {
		
		//
		//Hasta java 6
		//
		Connection cx = null;
		Socket     sk = null;
		FileReader fr = null;
		
		try {
			cx = DriverManager.getConnection("","","");
			sk = new Socket("ip",5000);
			fr = new FileReader("datos.txt");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
				sk.close();
				fr.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//
		//A partir de Java 7
		//
		try(Connection cx2 = DriverManager.getConnection("","","");
			Socket     sk2 = new Socket("ip",1000);
			FileReader fr2 = new FileReader("datos.dat")){
			
			//Nuestro código
			
		} catch (SQLException | FileNotFoundException | UnknownHostException e) {
			//No podemos agrupar en un mismo multicatch excepciones en la
			//misma rama de herencia
			e.printStackTrace();
		} catch (IOException e ){
			e.printStackTrace();
		}
		
	}
	
}











