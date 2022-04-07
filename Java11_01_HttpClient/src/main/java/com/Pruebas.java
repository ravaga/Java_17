package com;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.curso.servicio.Disco;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Pruebas {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		//
		//Clase HttpRequest
		//
		
		//
		//Tiene los constructores privados e implementa el patrón Builder
		//
		
		//Proporcionando la url
		HttpRequest request1 = HttpRequest
			.newBuilder(new URI("http://localhost:8080/discos"))
			.build();
		 
		//Otra manera
		//La clase tiene 'fluent api'
		HttpRequest request2 =HttpRequest
			.newBuilder()
			.uri(new URI("http://localhost:8080/discos"))
			.build();
		
		//Especificando el método HTTP (por defecto GET)
		HttpRequest request3 = HttpRequest.newBuilder()
		  .uri(new URI("http://localhost:8080/discos"))
		  .GET() 
		  .build();
		
		//Versión del protocolo HTTP (por defecto HTTP/2)
		HttpRequest request4 = HttpRequest.newBuilder()
		  .uri(new URI("http://localhost:8080/discos"))
		  .version(HttpClient.Version.HTTP_2)
		  .GET()
		  .build();
		
		//Headers
		HttpRequest request5 = HttpRequest.newBuilder()
			.uri(new URI("http://localhost:8080/discos"))
			.version(HttpClient.Version.HTTP_2)
			.header("accept", "application/json")
			.headers("header1","valor1","header2","valor2","Header3","y así...")
			.GET()
			.build();
		
		//Timeout
		HttpRequest request6 = HttpRequest.newBuilder()
		  .uri(new URI("http://localhost:8080/discos"))
		  .timeout(Duration.of(10, ChronoUnit.SECONDS))
		  .GET()
		  .build();
		
		//Body
		HttpRequest request7 = HttpRequest.newBuilder()
		  .uri(new URI("http://localhost:8080/discos"))
		  .POST(HttpRequest.BodyPublishers.noBody())
		  .build();
		
		Disco disco = new Disco(null, "Selling England by the pound","Genesis",1973);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(disco);
		
		HttpRequest request8 = HttpRequest.newBuilder()
		  .uri(new URI("http://localhost:8080/discos"))
		  .headers("Content-Type", "application/json")
		  .POST(HttpRequest.BodyPublishers.ofString(json))
		  .build();
		
		//
		//Clase HttpClient
		//
		HttpClient httpClient = HttpClient.newBuilder().build();
		
		//
		//Clase HttpResponse
		//
		HttpResponse<String> response1 = httpClient.send(request1, BodyHandlers.ofString());
		System.out.println(response1.statusCode());
		System.out.println(response1.headers());
		System.out.println(response1.body());
		
		HttpResponse<String> response2 = httpClient.send(request8, BodyHandlers.ofString());
		System.out.println(response2.body());

		HttpResponse<String> response3 = httpClient.send(request1, BodyHandlers.ofString());
		System.out.println(response3.body());
		
	}
	
}
