package com.biglietteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biglietteria.entities.Replica;

@Repository
public interface IReplicaRepository extends CrudRepository<Replica, String>{

}
