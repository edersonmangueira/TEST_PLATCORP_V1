package com.edersonmangueira.test_platcorp_v1.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edersonmangueira.test_platcorp_v1.dominio.GeoLocalizacao;

@Service
public class LocalizacaoGeograficaRecuperaIpService {

	public void LocalizacaoGeografica(String ip) throws Exception {

		String url = "https://ipvigilante.com/" + ip;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print in String
		System.out.println(response.toString());

		// Read JSON response and print

		JSONObject myResponse = new JSONObject(response.toString());
		System.out.println("result after Reading JSON Response");
		System.out.println("status- " + myResponse.getString("status"));
		System.out.println("data- " + myResponse.get("data"));

		RestTemplate restTemplate = new RestTemplate();
		
		GeoLocalizacao geoLocalizacao = restTemplate.getForObject(url, GeoLocalizacao.class);
		
		System.out.println("------------------------------------------");
		System.out.println(geoLocalizacao);
		/*
		 * JSONObject dataJson = (JSONObject) myResponse.get("data");
		 */

		/*
		 * System.out.println("ipv4- " + myResponse.getString("ipv4"));
		 * System.out.println("continent_name " +
		 * myResponse.getString("continent_name")); System.out.println("country_name- "
		 * + myResponse.getString("country_name"));
		 * System.out.println("subdivision_1_name- " +
		 * myResponse.getString("subdivision_1_name"));
		 */

	}

	public String recuperaIp() throws Exception {

		String url = "http://httpbin.org/ip";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print in String
		System.out.println(response.toString());

		JSONObject myResponse = new JSONObject(response.toString());

		String ip = (String) myResponse.getString("origin");

		System.out.println("IP :" + ip);

		return (String) myResponse.getString("origin");

	}
}