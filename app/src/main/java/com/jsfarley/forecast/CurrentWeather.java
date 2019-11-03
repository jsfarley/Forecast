package com.jsfarley.forecast;

import android.graphics.Color;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentWeather {
	private String locationValue;
	private String icon;
	private long time;
	private double temperature;
	private double humidity;
	private double precipProbability;
	private String summary;
	private String timeZone;
	private String weatherColor;



	public CurrentWeather() {
	}
	public CurrentWeather(String locationValue, String icon, String summary, double temperature,
	                      double humidity, double precipProbability, String timeZone, long time, String weatherColor
	                      ) {
		this.locationValue = locationValue;
		this.icon = icon;
		this.summary = summary;
		this.temperature = temperature;
		this.humidity = humidity;
		this.precipProbability = precipProbability;
		this.timeZone = timeZone;
		this.time = time;
		this.weatherColor = weatherColor;
	}
	public String getFormattedTime(){
		SimpleDateFormat formatter = new SimpleDateFormat("h:mm:a");
		formatter.setTimeZone(TimeZone.getTimeZone(timeZone));

		Date dateTime = new Date(time * 1000);
		return formatter.format(dateTime);
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}


	/*public double getLowTemp() {
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
	}*/

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

		int iconId = R.drawable.fsunny;
		switch (icon) {
			case "clear-day":
				iconId = R.drawable.fsunny;
				break;
			case "clear-night":
				iconId = R.drawable.fclear_night;
				break;
			case "rain":
				iconId = R.drawable.frain;
				break;
			case "snow":
				iconId = R.drawable.fsnow;
				break;
			case "sleet":
				iconId = R.drawable.fsleet;
				break;
			case "wind":
				iconId = R.drawable.fwind;
				break;
			case "fog":
				iconId = R.drawable.ffog;
				break;
			case "cloudy":
				iconId = R.drawable.fcloudy;
				break;
			case "partly-cloudy-day":
				iconId = R.drawable.fpartly_cloudy;
				break;
			case "partly-cloudy-night":
				iconId = R.drawable.fcloudy_night;
				break;
			case "thunderstorm":
				iconId = R.drawable.fthunder_storm;
				break;

		}
		return iconId;
	}

	public String getWeatherColor() {
		return weatherColor;
	}
	public void setWeatherColor(String weatherColor) {
		this.weatherColor = weatherColor;
	}
	public int weatherColorId(){
		int weatherColorId = Color.parseColor("#FF0F74C2");
		switch (icon){
			case "clear-day":
				weatherColorId = Color.parseColor("#FF0F74C2");
				break;
			case "clear-night":
				weatherColorId = Color.parseColor("#3D044A");
				break;
			case "rain":
				weatherColorId = Color.parseColor("#73A2BF");
				break;
			case "snow":
				weatherColorId = Color.parseColor("#99ADBF");
				break;
			case "sleet":
				weatherColorId = Color.parseColor("#99ADBF");
				break;
			case "wind":
				weatherColorId = Color.parseColor("#7EC6F2");
				break;
			case "fog":
				weatherColorId = Color.parseColor("#979C9C");
				break;
			case "cloudy":
				weatherColorId = Color.parseColor("#979C9C");
				break;
			case "partly-cloudy-day":
				weatherColorId = Color.parseColor("#FF0F74C2");
				break;
			case "partly-cloudy-night":
				weatherColorId = Color.parseColor("#3D044A");
				break;
			case "thunderstorm":
				weatherColorId = Color.parseColor("#73A2BF");
				break;
		}
	return weatherColorId;
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

	public double getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(double precipProbability) {
		this.precipProbability = precipProbability;
	}


}
