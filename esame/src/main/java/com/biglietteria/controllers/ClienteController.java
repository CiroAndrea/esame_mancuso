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

import com.biglietteria.entities.Cliente;
import com.biglietteria.services.ClienteService;

@RestController
@RequestMapping("api/clienti")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public Iterable<Cliente> getAll(){
		return clienteService.getAll();
	}
	
	@GetMapping("{id}")
	public Optional<Cliente> getById(@PathVariable Integer id){
		return clienteService.getById(id);
	}
		
	@PostMapping
	public ResponseEntity<Cliente> add(@RequestBody Cliente cliente) {
	    Cliente saved = clienteService.create(cliente);
	    System.out.println("Cliente inserito correttamente codCliente: " + saved.getCodCliente());
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
	    if (clienteService.getById(id).isEmpty()) {
	    	System.out.println("Cliente con ID " + id + " non trovato");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Cliente con ID " + id + " non trovato");
	    }

	    clienteService.delete(id);
	    System.out.println("Cliente con ID " + id + " cancellato correttamente");
	    return ResponseEntity.ok("Cliente con ID " + id + " cancellato correttamente");
	}

}
