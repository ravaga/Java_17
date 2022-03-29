package com.curso.modelo.entidad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cliente implements Comparable<Cliente>{

	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	//1..n
	public List<Factura> facturas = new ArrayList<>();
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}

	@Override
	public int compareTo(Cliente otroCliente) {
		return nombre.compareTo(otroCliente.nombre);
	}
	
}



