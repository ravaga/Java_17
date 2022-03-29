package com;

import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ClientesPublisher;
import com.curso.modelo.negocio.ClientesSubscriber;
import com.curso.modelo.negocio.GestorMk;

public class Pruebas {

	public static void main(String[] args) {

		//Este se subscribe el solito:
		GestorMk gestorMk = new GestorMk();
		
		List<Cliente> clientes = List.of(
			new Cliente(1),
			new Cliente(2),
			new Cliente(3),
			new Cliente(4),
			new Cliente(5),
			new Cliente(6),
			new Cliente(7),
			new Cliente(8),
			new Cliente(9)
		);	
		
		//A este le subcribimos nosotros
		ClientesSubscriber cs = new ClientesSubscriber();
		
		//No es el clientesPublisher el que se suscribe sino al revés
		ClientesPublisher.subscribe(cs);
		
		clientes.forEach(c -> ClientesPublisher.publicarCliente(c));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

