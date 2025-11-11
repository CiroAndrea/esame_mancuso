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

import com.biglietteria.entities.Biglietto;
import com.biglietteria.entities.Replica;
import com.biglietteria.entities.Spettacolo;
import com.biglietteria.entities.Teatro;
import com.biglietteria.services.BigliettoService;
import com.biglietteria.services.ReplicaService;
import com.biglietteria.services.SpettacoloService;
import com.biglietteria.services.TeatroService;

@RestController
@RequestMapping("api/biglietti")
public class BigliettoController {

	private final BigliettoService bigliettoService;
	private final ReplicaService replicaService;
	private final SpettacoloService spettacoloService;
	private final TeatroService teatroService;
	
	@Autowired
	public BigliettoController(BigliettoService bigliettoService, ReplicaService replicaService, SpettacoloService spettacoloService, TeatroService teatroService) {
		this.bigliettoService = bigliettoService;
		this.replicaService = replicaService;
		this.spettacoloService = spettacoloService;
		this.teatroService = teatroService;
	}
	
	@GetMapping
	public Iterable<Biglietto> getAll(){
		return bigliettoService.getAll();
	}
	
	@GetMapping("{id}")
	public Optional<Biglietto> getById(@PathVariable Integer id){
		return bigliettoService.getById(id);
	}
	
	//Prima di inserire il nuovo biglietto bisogna verificare la capacità del teatro
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Biglietto biglietto) {
		Optional<Replica> replicaOpt = replicaService.getById(biglietto.getCodReplica());
		Replica replicaTrovata = replicaOpt.get();
		
		Optional<Spettacolo> spettacoloOpt = spettacoloService.getById(replicaTrovata.getCodSpettacolo());
		Spettacolo spettacoloTrovato = spettacoloOpt.get();
		
		Optional<Teatro> teatroOpt = teatroService.getById(spettacoloTrovato.getCodTeatro());
		Teatro teatroTrovato = teatroOpt.get();
		
		int posti = teatroTrovato.getPosti();

		if(biglietto.getQuantita() <= posti) {
			Biglietto saved = bigliettoService.create(biglietto);
			System.out.println("Biglietto inserito correttamente con codOperazione: " + saved.getCodOperazione());
			return ResponseEntity.status(HttpStatus.CREATED).body("Biglietto inserito correttamente con codOperazione: " + saved.getCodOperazione());
		}else {
			System.out.println("Ci spiace ma il Teatro ha raggiunto il numero massimo di posti");
			return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE)
								.body("Ci spiace ma il Teatro ha raggiunto il numero massimo di posti");
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
	    if (bigliettoService.getById(id).isEmpty()) {
	    	System.out.println("Biglietto con ID " + id + " non trovato");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Biglietto con ID " + id + " non trovato");
	    }

	    bigliettoService.delete(id);
	    System.out.println("Biglietto con ID " + id + " cancellato correttamente");
	    return ResponseEntity.ok("Biglietto con ID " + id + " cancellato correttamente");
	}
	
}
