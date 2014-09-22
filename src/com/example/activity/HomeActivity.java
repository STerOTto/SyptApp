package com.example.activity;

import com.example.R;
import com.slidingmenu.lib.SlidingMenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class HomeActivity extends Activity implements OnTouchListener
{
	private SlidingMenu slidingMenu;
	private LinearLayout leftMenuLinearLayout;
	private LinearLayout homeLinearLayout;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
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
		slidingMenu.setMenu(R.layout.left_menu);
		WindowManager wManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		int screenWidth = wManager.getDefaultDisplay().getWidth();
		slidingMenu.setBehindWidth((int) (screenWidth*0.6));
	}
//	private void initView()
//	{
//		leftMenuLinearLayout = (LinearLayout) findViewById(R.id.leftMenuLinearLayout);
//		homeLinearLayout = (LinearLayout) findViewById(R.id.homeLinearLayout);
//		leftMenuLinearLayout.setOnTouchListener(this);
//		homeLinearLayout.setOnTouchListener(this);
//	}
//
//	@Override
//	public boolean onTouch(View view, MotionEvent motionEvent)
//	{
//		switch(view.getId())
//		{
//		case R.id.leftMenuLinearLayout:
//
//			break;
//		case R.id.homeLinearLayout:
//			slidingMenu.toggle();
//			break;
//		}
//		return false;
//	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1)
	{
		// TODO Auto-generated method stub
		return false;
	}
}
