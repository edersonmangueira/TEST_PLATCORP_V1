package com.edersonmangueira.test_platcorp_v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edersonmangueira.test_platcorp_v1.dominio.ClienteTemperatura;

@Repository
public interface ClienteTemperaturaRepository extends MongoRepository<ClienteTemperatura, String>{

}
