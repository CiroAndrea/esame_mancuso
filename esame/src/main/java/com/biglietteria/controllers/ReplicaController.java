package com.biglietteria.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biglietteria.entities.Replica;
import com.biglietteria.services.ReplicaService;

@RestController
@RequestMapping("api/repliche")
public class ReplicaController {

	private final ReplicaService replicaService;
	
	public ReplicaController(ReplicaService replicaService) {
		this.replicaService = replicaService;
	}
	
	@GetMapping
	public Iterable<Replica> getAll(){
		return replicaService.getAll();
	}
	
	@GetMapping("{id}")
	public Optional<Replica> getById(@PathVariable String id){
		return replicaService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Replica> add(@RequestBody Replica replica) {
		Replica saved = replicaService.create(replica);
		System.out.println("Replica inserita correttamente codReplica: " + saved.getCodReplica());
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		if (replicaService.getById(id).isEmpty()) {
	    	System.out.println("Replica con ID " + id + " non trovata");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Replica con ID " + id + " non trovata");
	    }

		replicaService.delete(id);
	    System.out.println("Replica con ID " + id + " cancellata correttamente");
	    return ResponseEntity.ok("Replica con ID " + id + " cancellata correttamente");
	}
	
}
