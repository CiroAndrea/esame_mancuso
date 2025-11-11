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

import com.biglietteria.entities.Spettacolo;
import com.biglietteria.services.SpettacoloService;

@RestController
@RequestMapping("api/spettacoli")
public class SpettacoloController {

	private final SpettacoloService spettacoloService;
	
	@Autowired
	public SpettacoloController(SpettacoloService spettacoloService) {
		this.spettacoloService = spettacoloService;
	}
	
	@GetMapping
	public Iterable<Spettacolo> getAll(){
		return spettacoloService.getAll();
	}
	
	@GetMapping("{id}")
	public Optional<Spettacolo> getById(@PathVariable String id){
		return spettacoloService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Spettacolo> add(@RequestBody Spettacolo spettacolo) {
	    Spettacolo saved = spettacoloService.create(spettacolo);
	    System.out.println("Spettacolo inserito correttamente codSpettacolo: " + saved.getCodSpettacolo());
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
	    if (spettacoloService.getById(id).isEmpty()) {
	    	System.out.println("Spettacolo con ID " + id + " non trovato");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Spettacolo con ID " + id + " non trovato");
	    }

	    spettacoloService.delete(id);
	    System.out.println("Spettacolo con ID " + id + " cancellato correttamente");
	    return ResponseEntity.ok("Spettacolo con ID " + id + " cancellato correttamente");
	}
	
}
