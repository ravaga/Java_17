package com.curso.modelo.entidad;

import java.util.List;

public class Cliente {

	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	private List<Factura> facturas;
	private List<Pedido> pedidos;

	public Cliente() {
		super();
	}

	public Cliente(Integer id) {
		super();
		this.id = id;
	}

	public Cliente(Integer id, String nombre, String direccion, String telefono, List<Factura> facturas,
			List<Pedido> pedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.facturas = facturas;
		this.pedidos = pedidos;
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", facturas=" + facturas + ", pedidos=" + pedidos + "]";
	}

}
