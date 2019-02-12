package com.edersonmangueira.test_platcorp_v1.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edersonmangueira.test_platcorp_v1.dominio.Cliente;
import com.edersonmangueira.test_platcorp_v1.dto.ClienteDTO;
import com.edersonmangueira.test_platcorp_v1.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll(){
		
		List<Cliente> lista = service.findAll();
		List<ClienteDTO> listaDto = lista.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto); 
	}

}
