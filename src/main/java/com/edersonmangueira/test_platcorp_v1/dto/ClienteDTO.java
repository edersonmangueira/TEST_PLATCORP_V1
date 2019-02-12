package com.edersonmangueira.test_platcorp_v1.dto;

import java.io.Serializable;

import com.edersonmangueira.test_platcorp_v1.dominio.Cliente;

public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String idade;
	
	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		idade = cliente.getIdade();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	
}
