package com.curso.modelo.entidad;

public class FacturaDTO {

	//id
	private String codigo;
	private String cliente;
	private Double total;

	public FacturaDTO() {
		super();
	}

	public FacturaDTO(String codigo, String cliente, Double total) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.total = total;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "FacturaDTO [codigo=" + codigo + ", cliente=" + cliente + ", total=" + total + "]";
	}
		
}
