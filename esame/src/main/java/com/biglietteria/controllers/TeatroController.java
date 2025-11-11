package com.biglietteria.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biglietteria.entities.Teatro;
import com.biglietteria.services.TeatroService;

@RestController
@RequestMapping("api/teatri")
public class TeatroController {

	private final TeatroService teatroService;
	
	@Autowired
	public TeatroController(TeatroService teatroService) {
		this.teatroService = teatroService;
	}
	
	@GetMapping
	public Iterable<Teatro> getAll(){
		return teatroService.getAll();
	}
	
	@GetMapping("{id}")
	public Optional<Teatro> getById(@PathVariable String id){
		return teatroService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Teatro> add(@RequestBody Teatro teatro) {
	    Teatro saved = teatroService.create(teatro);
	    System.out.println("Teatro inserito correttamente codTeatro: " + saved.getCodTeatro());
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
	    if (teatroService.getById(id).isEmpty()) {
	    	System.out.println("Teatro con ID " + id + " non trovato");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Teatro con ID " + id + " non trovato");
	    }

	    teatroService.delete(id);
	    System.out.println("Teatro con ID " + id + " cancellato correttamente");
	    return ResponseEntity.ok("Teatro con ID " + id + " cancellato correttamente");
	}
	
}
