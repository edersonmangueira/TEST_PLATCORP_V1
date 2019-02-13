package com.edersonmangueira.test_platcorp_v1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonmangueira.test_platcorp_v1.dominio.Cliente;
import com.edersonmangueira.test_platcorp_v1.dto.ClienteDTO;
import com.edersonmangueira.test_platcorp_v1.repository.ClienteRepository;
import com.edersonmangueira.test_platcorp_v1.services.exception.ObjectNotFoundException;



@Service
public class ClienteService {
	
	@Autowired 
	private ClienteRepository repo;
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Cliente findById(String id) {
		Optional<Cliente> cliente = repo.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Cliente insert(Cliente cliente) {
		return repo.insert(cliente);
	}
	
	public void delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Cliente update(Cliente cliente) {
		findById(cliente.getId());
		return repo.save(cliente);
	}
	
	public Cliente fromDTO(ClienteDTO clienteDto) {
		return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getIdade()); 
	}

}
