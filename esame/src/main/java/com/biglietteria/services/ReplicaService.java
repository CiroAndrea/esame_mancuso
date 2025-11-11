package com.biglietteria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biglietteria.entities.Replica;
import com.biglietteria.repositories.IReplicaRepository;

@Service
public class ReplicaService {

	@Autowired
	private IReplicaRepository repo;
	
	public ReplicaService() {}
	
	public Iterable<Replica> getAll(){
		return repo.findAll();
	}
	
	public Optional<Replica> getById(String id){
		return repo.findById(id);
	}
	
	public Replica create(Replica replica) {
		return repo.save(replica);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
}
