package com.curso.modelo.entidad;

import java.time.LocalDate;

public class Factura {

	private Integer id;
	private String codigo;
	private LocalDate fecha;
	private Double total;

	public Factura() {
		super();
	}

	public Factura(Integer id, String codigo, LocalDate fecha, Double total) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + ", total=" + total + "]";
	}

}
