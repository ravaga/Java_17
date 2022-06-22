package com.curso.modelo.stream;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Factura;
import com.curso.modelo.negocio.ServicioFacturas;

//
// Recibe un cliente y lo envía con sus facturas
//
public class ClientesProcessorFacturas extends ClientesProcessor {

	//Ningún elemento del stream debe tener lógica de negocio y delega la tarea en un servicio
	private ServicioFacturas servicioPedidos = new ServicioFacturas();
	
	public ClientesProcessorFacturas(Executor executorService) {
		super(executorService);
	}
	
	public Cliente procesarCliente(Cliente cliente) throws Exception {
		System.out.println(Thread.currentThread().getId()+"-ClientesProcessorFacturas. Elemento recibido: "+cliente);
		Optional<List<Factura>> facOp = servicioPedidos.getFacturasCliente(cliente.getId());
		cliente.setFacturas(facOp.orElseThrow(()->new Exception("Zasca")));
		return cliente;
	}
	
}










