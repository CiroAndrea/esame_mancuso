package com.biglietteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biglietteria.entities.Teatro;

@Repository
public interface ITeatroRepository extends CrudRepository<Teatro, String>{

}
