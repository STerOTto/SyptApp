package com.example.activity;

import com.example.R;
import com.slidingmenu.lib.SlidingMenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class HomeActivity extends Activity
{
	private SlidingMenu slidingMenu;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_home);
		initSlidingMenu();
		slidingMenu.toggle();
	}
	@SuppressWarnings("deprecation")
	private void initSlidingMenu()
	{
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		slidingMenu.setShadowWidth(5);
		slidingMenu.setShadowDrawable(R.drawable.ic_launcher);
		slidingMenu.setFadeDegree(0.35f);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setMenu(R.layout.fragment_home_menu);
		WindowManager wManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		int screenWidth = wManager.getDefaultDisplay().getWidth();
		slidingMenu.setBehindWidth((int) (screenWidth*0.8));
	}
}
