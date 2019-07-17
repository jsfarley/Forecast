package com.jsfarley.forecast;

public class CurrentWeather {
	private String locationValue;
	private String icon;
	private String summary;
	private double temperature;
	private double humidity;
	private double precipChance;
	private String timeZone;
	private double lowTemp;
	private double apparentTemp;

	public CurrentWeather() {
	}

	public CurrentWeather(String locationValue, String icon, String summary, double temperature,
	                      double humidity, double precipChance, String timeZone, double lowTemp,
	                      double apparentTemp) {
		this.locationValue = locationValue;
		this.icon = icon;
		this.summary = summary;
		this.temperature = temperature;
		this.humidity = humidity;
		this.precipChance = precipChance;
		this.timeZone = timeZone;
		this.lowTemp = lowTemp;
		this.apparentTemp = apparentTemp;
	}

	public double getLowTemp() {
		return lowTemp;
	}

	public void setLowTemp(double lowTemp) {
		this.lowTemp = lowTemp;
	}

	public double getApparentTemp() {
		return apparentTemp;
	}

	public void setApparentTemp(double apparentTemp) {
		this.apparentTemp = apparentTemp;
	}


	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}


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
	public int iconId() {
		int iconId = R.drawable.clear_day;
		switch (icon) {
			case "clear-day":
				iconId = R.drawable.clear_day;
				break;
			case "clear-night":
				iconId = R.drawable.clear_night;
				break;
			case "rain":
				iconId = R.drawable.rain;
				break;
			case "snow":
				iconId = R.drawable.snow;
				break;
			case "sleet":
				iconId = R.drawable.sleet;
				break;
			case "wind":
				iconId = R.drawable.wind;
				break;
			case "fog":
				iconId = R.drawable.fog;
				break;
			case "cloudy":
				iconId = R.drawable.cloudy;
				break;
			case "partly-cloudy-day":
				iconId = R.drawable.partly_cloudy;
				break;
			case "partly-cloudy-night":
				iconId = R.drawable.cloudy_night;
				break;

		}
		return iconId;
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



}
