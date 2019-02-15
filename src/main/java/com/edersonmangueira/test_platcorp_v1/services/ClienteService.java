package com.edersonmangueira.test_platcorp_v1.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonmangueira.test_platcorp_v1.dominio.Cliente;
import com.edersonmangueira.test_platcorp_v1.dominio.ClienteTemperatura;
import com.edersonmangueira.test_platcorp_v1.dominio.GeoLocalizacao;
import com.edersonmangueira.test_platcorp_v1.dominio.Temperatura;
import com.edersonmangueira.test_platcorp_v1.dto.ClienteDTO;
import com.edersonmangueira.test_platcorp_v1.repository.ClienteRepository;
import com.edersonmangueira.test_platcorp_v1.repository.ClienteTemperaturaRepository;
import com.edersonmangueira.test_platcorp_v1.services.exception.ObjectNotFoundException;



@Service
public class ClienteService {
	
	@Autowired 
	private ClienteRepository repo;
	
	@Autowired 
	private ClienteTemperaturaRepository repoTemperatura;
	
	@Autowired
	private LocalizacaoGeograficaRecuperaIpService loca;
	
	Date data = new Date(System.currentTimeMillis());
	SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Cliente findById(String id) {
		Optional<Cliente> cliente = repo.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Cliente insert(Cliente cliente) {
		try {
			String ip = loca.recuperaIp();
			GeoLocalizacao geoLocalizacao = loca.LocalizacaoGeografica(ip);
			Integer woeid = loca.recuperaWoeid(geoLocalizacao);
			List<Temperatura> temperaturas = loca.recuperaTemperatura(woeid);
			
			Double tempMinima = null;
			Double tempMaxima = null;
			
			for (Temperatura temperatura : temperaturas) {
				
				if(temperatura.getApplicable_date().equals(formatarDate.format(data))) {
					tempMinima = temperatura.getMin_temp();
					tempMaxima = temperatura.getMax_temp();
				}
			}
			
			ClienteTemperatura clienteTemperatura = new ClienteTemperatura(tempMinima, tempMaxima,cliente);
			repoTemperatura.insert(clienteTemperatura);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
