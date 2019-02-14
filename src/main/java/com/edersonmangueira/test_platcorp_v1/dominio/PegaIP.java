package com.edersonmangueira.test_platcorp_v1.dominio;

public class PegaIP {
	
	private String origin;
	
	public PegaIP() {
	}

	public PegaIP(String origin) {
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
