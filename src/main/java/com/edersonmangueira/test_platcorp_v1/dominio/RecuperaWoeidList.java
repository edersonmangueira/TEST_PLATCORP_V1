package com.edersonmangueira.test_platcorp_v1.dominio;

import java.util.List;

public class RecuperaWoeidList {
	private List<RecuperaWoeid> recuperaWoeid;

	public RecuperaWoeidList() {
	}
	public RecuperaWoeidList(List<RecuperaWoeid> recuperaWoeid) {
		this.recuperaWoeid = recuperaWoeid;
	}
	
	public List<RecuperaWoeid> getRecuperaWoeid() {
		return recuperaWoeid;
	}
	public void setRecuperaWoeid(List<RecuperaWoeid> recuperaWoeid) {
		this.recuperaWoeid = recuperaWoeid;
	}	
}
