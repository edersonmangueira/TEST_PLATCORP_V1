package com.edersonmangueira.test_platcorp_v1.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edersonmangueira.test_platcorp_v1.dominio.Cliente;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll(){
		
		Cliente maria = new Cliente(1, "Maria", 50);
		Cliente alex = new Cliente(2, "alex", 50);
		
		List<Cliente> lista = new ArrayList<>();
		
		lista.addAll(Arrays.asList(maria,alex));
		
		return ResponseEntity.ok().body(lista); 
	}

}
