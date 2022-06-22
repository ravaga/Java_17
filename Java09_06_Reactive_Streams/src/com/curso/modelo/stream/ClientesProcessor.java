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
// Envía un elemento al siguiente eslabón (por eso hereda de publisher)
// Recibe elementos de un stream por parte del anterior eslabón de la cadena (por eso implementa processor)
// 
public abstract class ClientesProcessor extends SubmissionPublisher<Cliente> implements Processor<Cliente, Cliente> {

	//La subscripción es una representación del enlace entre el productor/publisher y el consumidor/subscriber
	private Subscription subscription;
	
	public ClientesProcessor(Executor executorService) {
		super(executorService,Flow.defaultBufferSize());
	}
	
	public abstract Cliente procesarCliente(Cliente cliente) throws Exception;

	//Estos son los métodos que tienen los subscriptores
	//Cada uno de ellos es un callback que se ejecuta en el momento adecuado:
	//-onSubscribe: cuando se efectúa la subscripcion
	//-onNext: cuando llega un elemento
	//-onError: cuando el elemento que llega es un error
	//-onComplete: cuando el que envía los elementos dice que ya no hay más

	@Override
	//Este callback se ejecuta cuando el processor se subscribe a un publisher
	//Nada más subscribirse solicita un elemento
	public final void onSubscribe(Subscription subscription) {
	    //Si nos quedamos con la subscripcion, por ejemplo, cancelarla
		this.subscription = subscription; 
		//Se solicita el primer elemento
		//Si no lo hay se espera
	    subscription.request(1); 		
	}
	
	@Override
	//Cada vez que llega un elemento por el stream se invoca este callback
	public final void onNext(Cliente cliente) {
		try {
			//Procesa el cliente
			Cliente clienteProcesado = procesarCliente(cliente);
			//Envía el resultado al siguiente del stream 
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










