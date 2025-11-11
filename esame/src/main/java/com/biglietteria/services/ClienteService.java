package com.biglietteria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biglietteria.entities.Cliente;
import com.biglietteria.repositories.IClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private IClienteRepository repo;
	
	public ClienteService() {}
	
	public Iterable<Cliente> getAll() {
		return repo.findAll();
	}
	
	public Optional<Cliente> getById(Integer id) {
		return repo.findById(id);
	}
	
	public Cliente create(Cliente cliente){
		return repo.save(cliente);
	}
	
	public void delete(Integer id){
		repo.deleteById(id);
	}
	
}
