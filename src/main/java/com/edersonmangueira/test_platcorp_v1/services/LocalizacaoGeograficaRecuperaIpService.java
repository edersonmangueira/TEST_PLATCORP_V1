package com.edersonmangueira.test_platcorp_v1.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edersonmangueira.test_platcorp_v1.dominio.GeoLocalizacao;
import com.edersonmangueira.test_platcorp_v1.dominio.PegaIP;

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

		return pegaIP.getOrigin();
	}

	public void recuperaWoeid(String latitude, String longitude) throws Exception {

		String url = "https://www.metaweather.com/api/location/search/?lattlong=" + latitude + "," + longitude;

		
		  URL obj = new URL(url); HttpURLConnection con = (HttpURLConnection)
		  obj.openConnection();
		  
		  int responseCode = con.getResponseCode();
		  
		  System.out.println("\nSending 'GET' request to URL : " + url);
		  System.out.println("Response Code : " + responseCode);
		  
		  BufferedReader in = new BufferedReader(new
		  InputStreamReader(con.getInputStream())); String inputLine; StringBuffer
		  response = new StringBuffer(); while ((inputLine = in.readLine()) != null) {
		  response.append(inputLine); } in.close();
		  
		  JSONObject myResponse = new JSONObject(response);
		 

		/*
		 * String ip = (String) myResponse.getString("origin");
		 * 
		 * return (String) myResponse.getString("origin");
		 */

		/*
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * RecuperaWoeid woeid = restTemplate.getForObject(url, RecuperaWoeid.class);
		 * 
		 * System.out.println(woeid);
		 */
	}
}