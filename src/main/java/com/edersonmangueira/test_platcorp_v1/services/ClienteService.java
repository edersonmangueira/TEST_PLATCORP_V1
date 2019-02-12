package com.edersonmangueira.test_platcorp_v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonmangueira.test_platcorp_v1.dominio.Cliente;
import com.edersonmangueira.test_platcorp_v1.repository.ClienteRepository;



@Service
public class ClienteService {
	
	@Autowired 
	private ClienteRepository repo;
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}

}
