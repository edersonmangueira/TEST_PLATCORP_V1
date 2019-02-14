package com.edersonmangueira.test_platcorp_v1.dominio;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GeoLocalizacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private String status;
	private Data data;
	
	public GeoLocalizacao() {
	}
	
	public GeoLocalizacao(String status, Data data) {
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GeoLocalizacao [status=" + status + ", data=" + data + "]";
	}
	
}
