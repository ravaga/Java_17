package com.curso.modelo.stream;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.ServicioPedidos;

//
// Recibe un cliente y lo envía con sus pedidos
//
public class ClientesProcessorPedidos extends ClientesProcessor {

	//Ningún elemento del stream debe tener lógica de negocio y delega la tarea en un servicio
	private ServicioPedidos serviciopedidos = new ServicioPedidos();
	
	public ClientesProcessorPedidos(Executor executorService) {
		super(executorService);
	}
	
	public Cliente procesarCliente(Cliente cliente) throws Exception {
		System.out.println(Thread.currentThread().getId()+"-ClientesProcessorPedidos.. Elemento recibido: "+cliente);
		Optional<List<Pedido>> pedOp = serviciopedidos.getPedidosCliente(cliente.getId());
		cliente.setPedidos(pedOp.orElseThrow(()->new Exception("Zasca")));
		return cliente;
	}



}










