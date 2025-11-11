package com.biglietteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biglietteria.entities.Biglietto;

@Repository
public interface IBigliettoRepository extends CrudRepository<Biglietto, Integer>{

}
