package com.jsfarley.forecast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;


import com.jsfarley.forecast.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

	public static final String TAG = MainActivity.class.getSimpleName();

	private CurrentWeather currentWeather;
	private ImageView iconImageView;
	final double latitude = 29.8833;
	final double longitude = -97.9414;
	ConstraintLayout constraintLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getForecast(latitude, longitude);

	}


	private void getForecast(double latitude, double longitude){
		final ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
		String apiKey = "bf0b68ba54650be9dd914dc48c709de2";
		String forecastURL = "https://api.darksky.net/forecast/"+apiKey+ "/"+latitude+","+longitude;

		iconImageView = findViewById(R.id.iconImageView);
		constraintLayout = findViewById(R.id.linearLayout);

		if(isNetworkAvailable()) {
			
			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder().url(forecastURL).build();
			Call call = client.newCall(request);
			call.enqueue(new Callback() {
				@Override
				public void onFailure(@NotNull Call call, @NotNull IOException e) {

				}

				@Override
				public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
					try {
						String jsonData = response.body().string();
						//Log.v(TAG, jsonData);
						if (response.isSuccessful()) {
							currentWeather = getCurrentDetails(jsonData);

							final CurrentWeather displayWeather = new CurrentWeather(
									currentWeather.getLocationValue(),
									currentWeather.getIcon(),
									currentWeather.getSummary(),
									currentWeather.getTemperature(),
									currentWeather.getHumidity(),
									currentWeather.getPrecipProbability(),
									currentWeather.getTimeZone(),
									currentWeather.getTime(),
									currentWeather.getWeatherColor()
							);
							Log.d(TAG, currentWeather.getFormattedTime());
							binding.setWeather(displayWeather);
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Drawable drawable = (Drawable) getResources().getDrawable(displayWeather.iconId());
									Drawable gradientDrawable = (Drawable) getResources().getDrawable(displayWeather.weatherColorId());
									iconImageView.setImageDrawable(drawable);
									//constraintLayout.setBackgroundColor(displayWeather.weatherColorId());
									constraintLayout.setBackground(gradientDrawable);



									//Animates background color
									//constraintLayout.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));

									Animation fadeIn = new AlphaAnimation(0,1);
									fadeIn.setInterpolator(new DecelerateInterpolator());
									fadeIn.setDuration(1000);

									AnimationSet animation = new AnimationSet(false);
									animation.addAnimation(fadeIn);
									constraintLayout.setAnimation(animation);

								}
							});
						} else {
							alertUserAboutError();
						}
					} catch (IOException e) {
						Log.e(TAG, "IO Exception Caught", e);
					}catch (JSONException e){
						Log.e(TAG,"JSON Exception caught", e);
					}
				}
			});
		}//end of network available statement
	}

	private CurrentWeather getCurrentDetails(String jsonData) throws JSONException {
		JSONObject forecast = new JSONObject(jsonData);

		String timezone = forecast.getString("timezone");
		Log.i(TAG,"From JSON: " + timezone );

		JSONObject currently = forecast.getJSONObject("currently");
		//JSONObject hourly = forecast.getJSONObject("hourly");

		//Sets objects from CurrentWeather class and JSON data
		CurrentWeather currentWeather = new CurrentWeather();
		currentWeather.setHumidity(currently.getDouble("humidity"));
		currentWeather.setPrecipProbability(currently.getDouble("precipProbability"));
		currentWeather.setIcon(currently.getString("icon"));
		//This will be updated to be based upon gps location
		currentWeather.setLocationValue("San Marcos, TX");
		currentWeather.setTime(currently.getLong("time"));
		currentWeather.setSummary(currently.getString("summary"));
		currentWeather.setTemperature(currently.getDouble("temperature"));
		//currentWeather.setLowTemp(currently.getDouble("dewPoint"));
		//currentWeather.setApparentTemp(currently.getDouble("apparentTemperature"));
		currentWeather.setTimeZone(timezone);
		currentWeather.setWeatherColor(currently.getString("icon"));
		//Log.d(TAG, currentWeather.getFormattedTime());
		return currentWeather;
	}

	//checks for network and internet availability
	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

		boolean isAvailable = false;
		if(networkInfo != null && networkInfo.isConnected()){
			isAvailable = true;
		} else{
			//Toast.makeText(this, "Sorry, no network availability.", Toast.LENGTH_LONG).show();
			networkDialogError();
		}
		return isAvailable;
	}

	//Creates an error dialog if no location is found
	private void alertUserAboutError() {
		AlertDialogFragment dialog = new AlertDialogFragment();
		dialog.show(getSupportFragmentManager(),"error dialog");
	}
	//Creates network dialog error dialog
	private void networkDialogError() {
		NetworkDialogFragment networkDialogFragment = new NetworkDialogFragment();
		networkDialogFragment.show(getSupportFragmentManager(), "Network Error");
	}

	//Refresh
	public void refreshOnClick(View view){
		getForecast(latitude, longitude);
		Toast.makeText(this, "Refreshing", Toast.LENGTH_LONG).show();
	}
}
