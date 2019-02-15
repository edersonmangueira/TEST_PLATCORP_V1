package com.edersonmangueira.test_platcorp_v1.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edersonmangueira.test_platcorp_v1.dominio.GeoLocalizacao;
import com.edersonmangueira.test_platcorp_v1.dominio.PegaIP;
import com.edersonmangueira.test_platcorp_v1.dominio.RecuperaWoeid;
import com.edersonmangueira.test_platcorp_v1.dominio.RecuperaWoeidList;

@Service
public class LocalizacaoGeograficaRecuperaIpService {

	public void LocalizacaoGeografica(String ip) throws Exception {

		String url = "https://ipvigilante.com/" + ip;

		RestTemplate restTemplate = new RestTemplate();

		GeoLocalizacao geoLocalizacao = restTemplate.getForObject(url, GeoLocalizacao.class);

		System.out.println("------------------------------------------");
		System.out.println(geoLocalizacao);

		recuperaWoeid(geoLocalizacao.getData().getLatitude(), geoLocalizacao.getData().getLongitude());
	}

	public String recuperaIp() throws Exception {

		String url = "http://httpbin.org/ip";

		RestTemplate restTemplate = new RestTemplate();

		PegaIP pegaIP = restTemplate.getForObject(url, PegaIP.class);

		System.out.println("------------------------------------------");
		System.out.println(pegaIP);

		return pegaIP.getOrigin();
	}

	public void recuperaWoeid(String latitude, String longitude) throws Exception {

		String url = "https://www.metaweather.com/api/location/search/?lattlong=" + latitude + "," + longitude;

		RestTemplate restTemplate = new RestTemplate();

		RecuperaWoeid[] forNow = restTemplate.getForObject(url, RecuperaWoeid[].class);

		List<RecuperaWoeid> woeids = Arrays.asList(forNow);
		
		System.out.println("------------------------------------------");

		System.out.println(woeids);

	}
}