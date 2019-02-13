package com.edersonmangueira.test_platcorp_v1.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<ClienteDTO> findById (@PathVariable String id){
		
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(cliente)); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClienteDTO clienteDto){
		
		Cliente cliente = service.fromDTO(clienteDto);
		cliente = service.insert(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable String id){
		
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody ClienteDTO clienteDto){
		
		Cliente cliente = service.fromDTO(clienteDto);
		cliente.setId(id);
		cliente = service.update(cliente);
		
		return ResponseEntity.noContent().build(); 
	}
}
