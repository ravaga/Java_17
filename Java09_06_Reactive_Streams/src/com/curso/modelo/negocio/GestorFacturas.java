package com.curso.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.curso.modelo.entidad.Factura;

public class GestorFacturas {

	public Optional<List<Factura>> getFacturasCliente(Integer idCliente){
		//Añade a cada cliente un número de facturas generadas aleatoriamente
		List<Factura> facturas = new ArrayList<>();
		for(int a=0; a<Long.valueOf(Math.round(Math.random()*5)+2); a++) {
			facturas.add(new Factura(a+idCliente*10,"FAC-"+a+idCliente*100,LocalDate.now(), Math.random()*1000));
		}
		return Optional.of(facturas);		
	}
	
}
