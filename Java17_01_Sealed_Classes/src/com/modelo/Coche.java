package com.modelo;

//Las clases que heredan de superclase sellada han de ser finales o selladas
public final class Coche extends Vehiculo {

	@Override
	public void arrancar() {
		System.out.println("Soy el coche y arranco");
	}

}
