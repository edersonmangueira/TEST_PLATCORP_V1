package com.edersonmangueira.test_platcorp_v1.services;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edersonmangueira.test_platcorp_v1.dominio.GeoLocalizacao;
import com.edersonmangueira.test_platcorp_v1.dominio.IP;
import com.edersonmangueira.test_platcorp_v1.dominio.Woeid;

@Service
public class LocalizacaoGeograficaRecuperaIpService {

	public void LocalizacaoGeografica(String ip) throws Exception {

		String url = "https://ipvigilante.com/" + ip;

		RestTemplate restTemplate = new RestTemplate();

		GeoLocalizacao geoLocalizacao = restTemplate.getForObject(url, GeoLocalizacao.class);

		System.out.println("------------------------------------------");
		System.out.println(geoLocalizacao);

		Integer woeid = recuperaWoeid(geoLocalizacao);
		recuperaTemperatura(woeid);
	}

	public String recuperaIp() throws Exception {

		String url = "http://httpbin.org/ip";

		RestTemplate restTemplate = new RestTemplate();

		IP pegaIP = restTemplate.getForObject(url, IP.class);

		System.out.println("------------------------------------------");
		System.out.println(pegaIP);

		return pegaIP.getOrigin();
	}

	public Integer recuperaWoeid(GeoLocalizacao geoLocalizacao) throws Exception {

		String url = "https://www.metaweather.com/api/location/search/?lattlong="
				+ geoLocalizacao.getData().getLatitude() + "," + geoLocalizacao.getData().getLongitude();

		RestTemplate restTemplate = new RestTemplate();

		Woeid[] forNow = restTemplate.getForObject(url, Woeid[].class);

		List<Woeid> woeids = Arrays.asList(forNow);

		System.out.println("------------------------------------------");

		System.out.println(woeids);

		for (Woeid recuperaWoeid : woeids) {
			if (recuperaWoeid.getTitle().equals(geoLocalizacao.getData().getCity_name())) {
				System.out.println(recuperaWoeid.getWoeid());
				return recuperaWoeid.getWoeid();
			} else {
				return null;
			}
		}
		return null;

	}

	public void recuperaTemperatura(Integer woeid) throws Exception {

		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd");
		System.out.print(formatarDate.format(data));

		String url = "https://www.metaweather.com/api/location/" + woeid + "/" + data + "/";

		RestTemplate restTemplate = new RestTemplate();

		/*
		 * Terminar amanhã o construir a classe e mudar o metodo
		 * 
		 * RecuperaWoeid[] forNow = restTemplate.getForObject(url,
		 * RecuperaWoeid[].class);
		 * 
		 * List<RecuperaWoeid> woeids = Arrays.asList(forNow);
		 * 
		 * System.out.println("------------------------------------------");
		 * 
		 * System.out.println(woeids);
		 */

	}
}