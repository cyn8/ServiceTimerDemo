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
		Log.d("info", "����������");
		
		startTimer();
		
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.d("info", "���������");
		
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
				//��������߼����룬��Ϊ��Ҫ��ʱִ�еĴ���
				i++;
				Log.d("i��ֵ", String.valueOf(i));		
			}

		};
		
		//��������runִ�еļ����������������task, firstTime, period����firstTimeʱ�̿�ʼ��ÿ��period����ִ��һ�Ρ� 
		timer.schedule(task, 1000, 1000);
	}
	
	public void stopTimer() {
		task.cancel();
		timer.cancel();
	}
}
