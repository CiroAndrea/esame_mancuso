package com.biglietteria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biglietteria.entities.Biglietto;
import com.biglietteria.repositories.IBigliettoRepository;

@Service
public class BigliettoService {

	@Autowired
	private IBigliettoRepository repo;
	
	public BigliettoService() {}
	
	public Iterable<Biglietto> getAll(){
		return repo.findAll();
	}
	
	public Optional<Biglietto> getById(Integer id){
		return repo.findById(id);
	}
	
	public Biglietto create(Biglietto biglietto) {
		return repo.save(biglietto);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}

