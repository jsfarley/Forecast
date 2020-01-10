package com.jsfarley.forecast;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.jsfarley.forecast.R.*;

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
	                      double humidity, double precipProbability, String timeZone, long time, String weatherColor ) {
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

		int iconId = drawable.fsunny;
		switch (icon) {
			case "clear-day":
				iconId = drawable.fsunny;
				break;
			case "clear-night":
				iconId = drawable.fclear_night;
				break;
			case "rain":
				iconId = drawable.frain;
				break;
			case "snow":
				iconId = drawable.fsnow;
				break;
			case "sleet":
				iconId = drawable.fsleet;
				break;
			case "wind":
				iconId = drawable.fwind;
				break;
			case "fog":
				iconId = drawable.ffog;
				break;
			case "cloudy":
				iconId = drawable.fcloudy;
				break;
			case "partly-cloudy-day":
				iconId = drawable.fpartly_cloudy;
				break;
			case "partly-cloudy-night":
				iconId = drawable.fcloudy_night;
				break;
			case "thunderstorm":
				iconId = drawable.fthunder_storm;
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

		//int weatherColorId = Color.parseColor("#FF0F74C2");
		int weatherColorId = drawable.drawable_clear_gradient;
		switch (icon){
			case "clear-day":
				//weatherColorId = Color.parseColor("#FF0F74C2");
				weatherColorId = drawable.drawable_clear_gradient;
				break;
			case "clear-night":
				weatherColorId = drawable.drawable_clear_night_gradient;
				break;
			case "rain":
				weatherColorId =drawable.drawable_cloudy_gradient ;
				break;
			case "snow":
				weatherColorId =drawable.drawable_cloudy_gradient ;
				break;
			case "sleet":
				weatherColorId =drawable.drawable_cloudy_gradient ;
				break;
			case "wind":
				weatherColorId =drawable.drawable_clear_gradient ;
				break;
			case "fog":
				weatherColorId =drawable.drawable_cloudy_gradient ;
				break;
			case "cloudy":
				weatherColorId =drawable.drawable_cloudy_gradient ;
				break;
			case "partly-cloudy-day":
				weatherColorId =drawable.drawable_clear_gradient ;
				break;
			case "partly-cloudy-night":
				weatherColorId = drawable.drawable_cloudy_night_gradient;
				break;
			case "thunderstorm":
				weatherColorId =drawable.drawable_cloudy_gradient ;
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
