package com.biglietteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biglietteria.entities.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer>{

}
