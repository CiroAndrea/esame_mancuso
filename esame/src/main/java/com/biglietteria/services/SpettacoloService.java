package com.biglietteria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biglietteria.entities.Spettacolo;
import com.biglietteria.repositories.ISpettacoloRepository;

@Service
public class SpettacoloService {

	@Autowired
	private ISpettacoloRepository repo;
	
	public SpettacoloService() {}
	
	public Iterable<Spettacolo> getAll(){
		return repo.findAll();
	}
	
	public Optional<Spettacolo> getById(String id){
		return repo.findById(id);
	}
	
	public Spettacolo create(Spettacolo spettacolo){
		return repo.save(spettacolo);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
}
