package com.curso.servicio;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Disco {
	private Long id;
	@NotNull
	@NotEmpty
	private String titulo;
	@NotNull
	@NotEmpty
	private String grupo;
	@NotNull
	@Min(0)
	private Integer year;

	public Disco() {
		super();
	}

	public Disco(Long id, String titulo, String grupo, Integer year) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.grupo = grupo;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Discos [id=" + id + ", titulo=" + titulo + ", grupo=" + grupo + ", year=" + year + "]";
	}
	
	public boolean equals(Object otroObjeto) {
		if(!(otroObjeto instanceof Disco)) {
			return false;
		}
		Disco otroDisco = (Disco) otroObjeto;
		return otroDisco.id == id;
	}

}


