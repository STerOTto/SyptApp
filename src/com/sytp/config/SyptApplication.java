package com.sytp.config;

import android.app.Application;

import com.sytp.entity.UserControl;

public class SyptApplication extends Application
{
	private static SyptApplication instance;

	public static SyptApplication getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}
	
	private UserControl userControl;
	
	public UserControl getUserControl()
	{
		return userControl;
	}

	public void setUserControl(UserControl userControl)
	{
		this.userControl = userControl;
	}
}
