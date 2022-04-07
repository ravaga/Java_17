package com.curso.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/////////////////////////////////////////////////////
//Claro ejemplo de cómo no se deben hacer las cosas//
/////////////////////////////////////////////////////

@SuppressWarnings("serial")
@SpringBootApplication
@RestController
public class ServicioRest {

	private static List<Disco> discos;

	static {
		//Esto es un antipatrón
		discos = new ArrayList<>() {{
			add(new Disco(1L,"Passion play","Jethro Tull",1973));
			add(new Disco(2L,"Number of the beast","Iron Maiden",1982));
			add(new Disco(3L,"Fireball","Deep Purple",1971));
			add(new Disco(4L,"Crises","Mike Oldfield",1983));
		}};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServicioRest.class, args);
	}
	
	@PostMapping("/discos")
	public ResponseEntity<Object> insertar(@Valid @RequestBody Disco disco, BindingResult br){
		if(br.hasErrors()) {
			return new ResponseEntity<>(br.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		disco.setId(System.currentTimeMillis());
		ServicioRest.discos.add(disco);
		return new ResponseEntity<>(disco, HttpStatus.CREATED);
	}

	@PutMapping("/discos/{id}")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Disco disco, @PathVariable("id") Long id, BindingResult br){
		if(br.hasErrors()) {
			return new ResponseEntity<>(br.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		disco.setId(id);		
		int pos = discos.indexOf(disco);
		if(pos == -1) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		discos.set(pos, disco);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@DeleteMapping("/discos/{id}")
	public ResponseEntity<Void> borrar(@PathVariable("id") Long id){
		boolean eliminado = discos.removeIf(d -> d.getId()==id);
		if(!eliminado) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	

	@GetMapping("/discos/{id}")
	public ResponseEntity<Disco> buscar(@PathVariable("id") Long id){
		return discos
				.stream()
				.filter(d -> d.getId()==id) //De aqui saldría un disco
				.map( d -> new ResponseEntity<>(d, HttpStatus.OK)) //De aqui sale un ReponseEntity
				.findFirst()
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/discos")
	public List<Disco> listar(){
		return discos;
	}
	
}

