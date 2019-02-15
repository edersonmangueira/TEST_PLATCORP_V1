package com.edersonmangueira.test_platcorp_v1.dominio;

public class IP {
	
	private String origin;
	
	public IP() {
	}

	public IP(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "PegaIP [origin=" + origin + "]";
	}
}
