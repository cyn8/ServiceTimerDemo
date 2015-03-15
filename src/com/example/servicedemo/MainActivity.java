package com.example.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnStartService;
	private Button btnStopService;
	private Intent serviceIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStartService = (Button) findViewById(R.id.btnStartService);
		btnStopService = (Button) findViewById(R.id.btnStopService);
		
		serviceIntent = new Intent(this, TimerService.class);
		
		btnStartService.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startService(serviceIntent);
			}
		});
		btnStopService.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stopService(serviceIntent);
			}
		});
	}

}
