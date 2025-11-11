package com.biglietteria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biglietteria.entities.Teatro;
import com.biglietteria.repositories.ITeatroRepository;

@Service
public class TeatroService {
	
	@Autowired
	private ITeatroRepository repo;
	
	public TeatroService() {}
	
	public Iterable<Teatro> getAll(){
		return repo.findAll();
	}
	
	public Optional<Teatro> getById(String id){
		return repo.findById(id);
	}
	
	public Teatro create(Teatro teatro) {
		return repo.save(teatro);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}

}
