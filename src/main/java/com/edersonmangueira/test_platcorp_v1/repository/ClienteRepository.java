package com.edersonmangueira.test_platcorp_v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edersonmangueira.test_platcorp_v1.dominio.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

}
