package com.curso.modelo.negocio;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.curso.modelo.entidad.Cliente;

public class ClientesSubscriber implements Subscriber<Cliente> {

	//La subscripción es una representación del enlace entre el productor y el consumidor
	private Subscription subscription;
	private int counter;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println(Thread.currentThread().getId()+"-Subscrito");
		this.subscription = subscription;
		System.out.println(Thread.currentThread().getId()+"-onSubscribe solicitando un elemento");
		//Solicitamos un elemento nada más empezar. So no hay, se esperará
		subscription.request(1); 
	}

	@Override
	public void onNext(Cliente cliente) {
		procesarCliente(cliente);
		counter++;
		subscription.request(1);
	}
	
	public void procesarCliente(Cliente cliente) {
		//LN
		System.out.println(Thread.currentThread().getId()+"-Procesando cliente "+cliente);
	}

	@Override
	public void onError(Throwable e) {
		System.out.println(Thread.currentThread().getId()+"-Error");
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println(Thread.currentThread().getId()+"-FIN");
	}

	public int getCounter() {
		return counter;
	}
}




























