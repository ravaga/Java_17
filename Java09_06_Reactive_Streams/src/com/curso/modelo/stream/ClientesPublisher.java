package com.curso.modelo.stream;

import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

import com.curso.modelo.entidad.Cliente;

//
// Esta clase utiliza un SubmissionPublisher para enviar elementos a un stream
//
public class ClientesPublisher {
	
	private SubmissionPublisher<Cliente> publisher;

	public ClientesPublisher(Executor executorService) {
		super();
		//Si queremos solo un hilo para procesar los clientes en la cadena
		//Executor executorService = Executors.newSingleThreadScheduledExecutor();
		System.out.println("Flow.defaultBufferSize:"+Flow.defaultBufferSize());
		publisher = new SubmissionPublisher<>(executorService,Flow.defaultBufferSize());
	}
	
	//Envía el elemento al primer eslabón del stream
	public void publicarCliente(Cliente cliente) {
		publisher.submit(cliente);
	}	

	//Para indicar a los subscriptores que no habrá más elementos
	public void finalizarStream() {
		publisher.close();
	}		
	
	public void addSubscriber(Subscriber<Cliente> subscriptor) {
		publisher.subscribe(subscriptor);
	}
	
}
