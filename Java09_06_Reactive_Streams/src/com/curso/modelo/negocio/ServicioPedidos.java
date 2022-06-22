package com.curso.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;

public class ServicioPedidos {

	public Optional<List<Pedido>> getPedidosCliente(Integer idCliente){
		System.out.println("   ServicioPedidos........... Buscando los pedidos del cliente "+idCliente);
		//Añade a cada cliente un número de pedidos generados aleatoriamente
		List<Pedido> pedidos = new ArrayList<>();
		for(int a=0; a<Long.valueOf(Math.round(Math.random()*5)+2); a++) {
			pedidos.add(new Pedido(a+idCliente*10,"PED-"+a+idCliente*100,LocalDate.now(), Math.random()*1000));
		}
		return Optional.of(pedidos);		
	}
	
}
