package com.curso.modelo.negocio;

public interface FunctionThrows<T,R> {
	R apply(T valor) throws Exception;
}
