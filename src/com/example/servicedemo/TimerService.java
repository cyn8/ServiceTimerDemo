package com.example.servicedemo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TimerService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		Log.d("info", "服务启动！");
		
		startTimer();
		
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.d("info", "服务结束！");
		
		stopTimer();
		
		super.onDestroy();
	}
	
	private Timer timer;
	private TimerTask task;
	private int i = 0;
	
	public void startTimer() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				//这里放置逻辑代码，即为需要定时执行的代码
				i++;
				Log.d("i的值", String.valueOf(i));		
			}

		};
		
		//这里设置run执行的间隔，传递三个参数task, firstTime, period，从firstTime时刻开始，每隔period毫秒执行一次。 
		timer.schedule(task, 1000, 1000);
	}
	
	public void stopTimer() {
		task.cancel();
		timer.cancel();
	}
}
