package com.curso.modelo.negocio;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.curso.modelo.entidad.Cliente;

public class GestorMk implements Subscriber<Cliente>{
	
	private Subscription subscription;
	
	public GestorMk() {
		super();
		ClientesPublisher.subscribe(this);
	}

	public void freirACorreosElectronicosNoDeseados(Integer idCliente) {
		System.out.println(Thread.currentThread().getId()+"-Enviando 100.000 correos al cliente "+idCliente);
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);		
	}
	
	@Override
	public void onNext(Cliente item) {
		freirACorreosElectronicosNoDeseados(item.getId());
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
	}

	@Override
	public void onComplete() {
	}
		
}
