package com.edersonmangueira.test_platcorp_v1.dominio;

public class Woeid {
	
	private Integer distance;
	private String title;
	private String location_type;
	private Integer woeid;
	private String latt_long;
	
	public Woeid() {
	}

	public Woeid(Integer distance, String title, String location_type, Integer woeid, String latt_long) {
		this.distance = distance;
		this.title = title;
		this.location_type = location_type;
		this.woeid = woeid;
		this.latt_long = latt_long;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public Integer getWoeid() {
		return woeid;
	}

	public void setWoeid(Integer woeid) {
		this.woeid = woeid;
	}

	public String getLatt_long() {
		return latt_long;
	}

	public void setLatt_long(String latt_long) {
		this.latt_long = latt_long;
	}

	@Override
	public String toString() {
		return "RecuperaWoeid [distance=" + distance + ", title=" + title + ", location_type=" + location_type
				+ ", woeid=" + woeid + ", latt_long=" + latt_long + "]";
	}
}
