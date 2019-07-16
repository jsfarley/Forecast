package com.jsfarley.forecast;

public class CurrentWeather {
	public String getLocationValue() {
		return locationValue;
	}

	public void setLocationValue(String locationValue) {
		this.locationValue = locationValue;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPrecipChance() {
		return precipChance;
	}

	public void setPrecipChance(double precipChance) {
		this.precipChance = precipChance;
	}

	private String locationValue;
	private String icon;
	private String summary;
	private double temperature;
	private double humidity;
	private double precipChance;


}
