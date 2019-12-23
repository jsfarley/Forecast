package com.jsfarley.forecast;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {
	private AnimationDrawable animationDrawable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
				.withFullScreen()
				.withTargetActivity(MainActivity.class)
				.withSplashTimeOut(3000)
				.withBackgroundResource(R.drawable.splash_gradient)
				.withLogo(R.drawable.forecast_logo);

		View easySplashScreen = config.create();
		setContentView(easySplashScreen);


	}

}
