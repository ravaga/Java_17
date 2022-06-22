package com.curso.modelo.negocio;

import java.util.List;
import java.util.Optional;

import com.curso.modelo.entidad.Cliente;

public class ServicioClientes {

	private static List<Cliente> clientes;
	
	static {
		clientes = List.of(
			new Cliente(1,"N1","D1","T1",null,null),
			new Cliente(2,"N2","D2","T2",null,null),
			new Cliente(3,"N3","D3","T3",null,null),
			new Cliente(4,"N4","D4","T4",null,null),
			new Cliente(5,"N5","D5","T5",null,null),
			new Cliente(6,"N6","D6","T6",null,null),
			new Cliente(7,"N7","D7","T7",null,null),
			new Cliente(8,"N8","D8","T8",null,null),
			new Cliente(9,"N9","D9","T9",null,null)
		);	
	}
	
	//Devuelve el clliente sin facturas ni pedidos
	public Optional<Cliente> buscarCliente(Integer id){
		System.out.println("   ServicioClientes.......... Buscando los datos del cliente "+id);
		for(Cliente c:clientes) {
			if(c.getId().equals(id)) {
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}
	
	public void insertarCliente(Cliente cliente) {
		System.out.println("   Servicio clientes......... Insertando el cliente en la BB.DD:"+cliente);
	}
	
}
