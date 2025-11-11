package com.biglietteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biglietteria.entities.Spettacolo;

@Repository
public interface ISpettacoloRepository extends CrudRepository<Spettacolo, String>{

}
