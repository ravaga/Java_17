package com.curso.modelo.stream;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

import com.curso.modelo.entidad.Cliente;

//
// Recibe elementos de un stream por parte del anterior eslabón de la cadena (por eso implementa processor)
// Envía un elemento al siguiente eslabón (por eso hereda de publisher)
// 
public abstract class ClientesProcessor extends SubmissionPublisher<Cliente> implements Processor<Cliente, Cliente> {

	//La subscripción es una representación del enlace entre el productor/publisher y el consumidor/subscriber
	private Subscription subscription;
	
	public ClientesProcessor(Executor executorService) {
		super(executorService,Flow.defaultBufferSize());
	}
	
	public abstract Cliente procesarCliente(Cliente cliente) throws Exception;

	@Override
	//Este callback se ejecuta cuando el processor se subscribe a un publisher
	//Nada más subscribirse solicita un elemento
	public final void onSubscribe(Subscription subscription) {
	    this.subscription = subscription;  
	    subscription.request(1); 		
	}

	@Override
	//Cada vez que llega un elemento por el stream se invoca este callback
	public final void onNext(Cliente cliente) {
		try {
			//Procesa el cliente
			Cliente clienteProcesado = procesarCliente(cliente);
			//Envía el resultado al siguiente 
			submit(clienteProcesado);
			//Solicita un elemento más
			subscription.request(1);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public final void onError(Throwable throwable) {
		System.out.println("Error procesando:"+throwable.getMessage());
	}

	@Override
	public final void onComplete() {
		System.out.println(Thread.currentThread().getId()+"-ClientesProcessor......... FIN");
		close();
	}

}










