package com.curso.modelo.stream;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ServicioClientes;
import com.curso.modelo.negocio.ServicioEstadisticas;

//
// Un Subscriber recibe elementos del estream y es el final de la cadena
// Varios subscribers pueden subscribirse al stream
//
public class EstadisticasSubscriber implements Subscriber<Cliente> {

	//Ningún elemento del stream debe tener lógica de negocio y delega la tarea en un servicio
	private ServicioEstadisticas servicioEstadisticas = new ServicioEstadisticas();
		
	//La subscripción es una representación del enlace entre el productor/publisher y el consumidor/subscriber
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1); 
	}

	@Override
	public void onNext(Cliente cliente) {
		System.out.println(Thread.currentThread().getId()+"-EstadisticasSubscriber.... Elemento recibido: "+cliente);
		servicioEstadisticas.addCliente(cliente);
		subscription.request(1);
	}


	@Override
	public void onError(Throwable e) {
		System.out.println(Thread.currentThread().getId()+"-Error");
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println(Thread.currentThread().getId()+"-EstadisticasSubscriber.... FIN");
	}

}




























