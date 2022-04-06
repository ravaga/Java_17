package com.curso.modelo.negocio;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;

//Esta es una clase normal y corriente
//Su responsabilidad es la de construir un stream reactivo con tres 'ClienteProcessor'
public class ClientesPublisher {

	private static GestorClientes gestorClientes = new GestorClientes();
	private static GestorFacturas gestorFacturas = new GestorFacturas();
	private static GestorPedidos  gestorPedidos  = new GestorPedidos();
	
	//Globales para toda la aplicación
	
	//A este publisher le damos la orden de que dispare los eventos
	//Cada evento será un cliente que solo tiene el id
	private static SubmissionPublisher<Cliente> publisher;
	private static SubmissionPublisher<Cliente> ultimo;
	
	static {
		
		//Executor executorService = Executors.newSingleThreadScheduledExecutor();
		Executor executorService = Executors.newFixedThreadPool(8);		
		
		System.out.println("Flow.defaultBufferSize:"+Flow.defaultBufferSize());
		publisher = new SubmissionPublisher<>(executorService,Flow.defaultBufferSize());

		//Esta instancia de ClientesProcessor recibe una función que, a partir del id del cliente, obtiene el cliente
		ClientesProcessor cp1 = new ClientesProcessor( c -> {
			System.out.println(Thread.currentThread().getId()+"-Buscando el cliente "+c.getId());			
			//Optional<Cliente> cliOp = gestorClientes.buscarCliente(c.getId());
			//return cliOp.orElseThrow(()->new Exception("Zasca"));			
			return gestorClientes
				.buscarCliente(c.getId())
				.orElseThrow(()->new Exception("Zasca"));			
		}, executorService);

		//En este caso la función recibe un cliente y lo devuelve con sus facturas
		ClientesProcessor cp2 = new ClientesProcessor( c -> {
			System.out.println(Thread.currentThread().getId()+"-Buscando las facturas del cliente "+c.getId());
			Optional<List<Factura>> fraOp = gestorFacturas.getFacturasCliente(c.getId());
			c.setFacturas(fraOp.orElseThrow(()->new Exception("Zasca")));
			return c;
		}, executorService);

		//Recibe un cliente y lo devuelve con sus pedidos
		ClientesProcessor cp3 = new ClientesProcessor( c -> {
			System.out.println(Thread.currentThread().getId()+"-Buscando los pedidos del cliente "+c.getId());
			Optional<List<Pedido>> pedOp = gestorPedidos.getPedidosCliente(c.getId());
			c.setPedidos(pedOp.orElseThrow(()->new Exception("Zasca")));
			return c;
		}, executorService);

		//Cadena de subscriptores inicial
		publisher.subscribe(cp1);
		cp1.subscribe(cp2);
		cp2.subscribe(cp3);
		
		//El último eslabón
		ultimo = cp3;
		
	}

	//Cualquier subscriptor adicional será el último eslabón del stream
	public static void subscribe(Subscriber<Cliente> subscriptor) {
		ultimo.subscribe(subscriptor);
	}
	
	//Envía el elemento al primer eslabón del stream
	public static void publicarCliente(Cliente cliente) {
		publisher.submit(cliente);
	}	
	
}
