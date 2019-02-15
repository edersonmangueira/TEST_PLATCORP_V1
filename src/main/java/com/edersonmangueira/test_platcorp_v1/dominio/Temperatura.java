package com.edersonmangueira.test_platcorp_v1.dominio;

import java.util.Date;

public class Temperatura {
	
	private String id; 
	private String weather_state_name;
	private String weather_state_abbr;
	private String wind_direction_compass;
	private String created;
	private Date applicable_date;
	private Double min_temp; 
	private Double max_temp;
	private Double the_temp;
	private Double wind_speed;
	private Double wind_direction;
	private Double air_pressure;
	private Integer humidity;
	private Double visibility;
	private Integer predictability;
	
	public Temperatura() {
	}

	public Temperatura(String id, String weather_state_name, String weather_state_abbr, String wind_direction_compass,
			String created, Date applicable_date, Double min_temp, Double max_temp, Double the_temp, Double wind_speed,
			Double wind_direction, Double air_pressure, Integer humidity, Double visibility, Integer predictability) {
		this.id = id;
		this.weather_state_name = weather_state_name;
		this.weather_state_abbr = weather_state_abbr;
		this.wind_direction_compass = wind_direction_compass;
		this.created = created;
		this.applicable_date = applicable_date;
		this.min_temp = min_temp;
		this.max_temp = max_temp;
		this.the_temp = the_temp;
		this.wind_speed = wind_speed;
		this.wind_direction = wind_direction;
		this.air_pressure = air_pressure;
		this.humidity = humidity;
		this.visibility = visibility;
		this.predictability = predictability;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeather_state_name() {
		return weather_state_name;
	}

	public void setWeather_state_name(String weather_state_name) {
		this.weather_state_name = weather_state_name;
	}

	public String getWeather_state_abbr() {
		return weather_state_abbr;
	}

	public void setWeather_state_abbr(String weather_state_abbr) {
		this.weather_state_abbr = weather_state_abbr;
	}

	public String getWind_direction_compass() {
		return wind_direction_compass;
	}

	public void setWind_direction_compass(String wind_direction_compass) {
		this.wind_direction_compass = wind_direction_compass;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Date getApplicable_date() {
		return applicable_date;
	}

	public void setApplicable_date(Date applicable_date) {
		this.applicable_date = applicable_date;
	}

	public Double getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(Double min_temp) {
		this.min_temp = min_temp;
	}

	public Double getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(Double max_temp) {
		this.max_temp = max_temp;
	}

	public Double getThe_temp() {
		return the_temp;
	}

	public void setThe_temp(Double the_temp) {
		this.the_temp = the_temp;
	}

	public Double getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(Double wind_speed) {
		this.wind_speed = wind_speed;
	}

	public Double getWind_direction() {
		return wind_direction;
	}

	public void setWind_direction(Double wind_direction) {
		this.wind_direction = wind_direction;
	}

	public Double getAir_pressure() {
		return air_pressure;
	}

	public void setAir_pressure(Double air_pressure) {
		this.air_pressure = air_pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Double getVisibility() {
		return visibility;
	}

	public void setVisibility(Double visibility) {
		this.visibility = visibility;
	}

	public Integer getPredictability() {
		return predictability;
	}

	public void setPredictability(Integer predictability) {
		this.predictability = predictability;
	}

	@Override
	public String toString() {
		return "Temperatura [id=" + id + ", weather_state_name=" + weather_state_name + ", weather_state_abbr="
				+ weather_state_abbr + ", wind_direction_compass=" + wind_direction_compass + ", created=" + created
				+ ", applicable_date=" + applicable_date + ", min_temp=" + min_temp + ", max_temp=" + max_temp
				+ ", the_temp=" + the_temp + ", wind_speed=" + wind_speed + ", wind_direction=" + wind_direction
				+ ", air_pressure=" + air_pressure + ", humidity=" + humidity + ", visibility=" + visibility
				+ ", predictability=" + predictability + "]";
	}
}
