package com;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Pruebas {

	public static void main(String[] args) {

		String fichero = "fichero.txt";
		
		//            //
		// OR TIMEOUT //
		//            //
		Future<String> dato = 
			CompletableFuture.supplyAsync( () -> {
				
				try {
					Thread.sleep(1100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				return "DATO1";		

			})
			.orTimeout(1000, TimeUnit.MILLISECONDS);

		//
		//Más código
		//
		
		try {
			System.out.println(dato.get());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} catch (ExecutionException e) {
			System.out.println(e.getMessage());
		}

		//                     //
		// COMPLETE ON TIMEOUT //
		//                     //
		Future<String> dato2 = 
			CompletableFuture.supplyAsync( () -> {
				
				try {
					Thread.sleep(1101);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				return "DATO2";		

			})
			.completeOnTimeout("TARDE!", 1100, TimeUnit.MILLISECONDS);

		//
		//Más código
		//
		
		try {
			System.out.println(dato2.get());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} catch (ExecutionException e) {
			System.out.println(e.getMessage());
		}
		

		//                  //
		// DELAYED EXECUTOR //
		//                  //
		System.out.println("Submit...");
		Future<String> dato3 = 
			CompletableFuture.supplyAsync( () -> {
				return "DATO3";		
			}, CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS));

		//
		//Más código
		//
		
		try {
			System.out.println(dato3.get());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} catch (ExecutionException e) {
			System.out.println(e.getMessage());
		}

	}

}
