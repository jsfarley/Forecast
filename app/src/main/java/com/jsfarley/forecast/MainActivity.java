package com.jsfarley.forecast;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String apiKey = "bf0b68ba54650be9dd914dc48c709de2";
		double latitude = 41.5236;
		double longitude = -90.5776;
		String forecastURL = "https://api.darksky.net/forecast/"+apiKey+ "/"+latitude+","+longitude;

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
						Log.v(TAG, jsonData);
						if (response.isSuccessful()) {
							currentWeather = getCurrentDetails(jsonData);

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
		return null;
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
}
