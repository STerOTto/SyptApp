package com.example.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.R;
import com.example.util.GetHTML;
import com.slidingmenu.lib.SlidingMenu;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * @author STerOTto
 *
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HomeActivity extends Activity implements OnClickListener
{
	private SlidingMenu slidingMenu;
	private ImageView menuSetting;
	private RelativeLayout menuForgotPasswordRelativeLayout;
	private RelativeLayout menuFeedBackRelativeLayout;
	private RelativeLayout menuDirectionRelativeLayout;
	private RelativeLayout menuLoginOutRelativeLayout;
	private LinearLayout homeNewsLinearLayout;
	private LinearLayout homeLearnCenterLinearLayout;
	private LinearLayout homeCommunityLinearLayout;
	private ImageView homeBottomMenuNews;
	private ImageView homeBottomMenuLearnCenter;
	private ImageView homeBottomMenuCommunity;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		initView();
	}
	
	@SuppressWarnings("deprecation")
	private void initSlidingMenu()
	{
		//SlidingMenu initialization
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
	private void initView()
	{
		//UI initialization
		initSlidingMenu();
		menuSetting = (ImageView) findViewById(R.id.menuSetting);
		menuSetting.setOnClickListener(this);
		menuForgotPasswordRelativeLayout = (RelativeLayout) findViewById(R.id.menuForgotPasswordRelativeLayout);
		menuForgotPasswordRelativeLayout.setOnClickListener(this);
		menuFeedBackRelativeLayout = (RelativeLayout) findViewById(R.id.menuFeedBackRelativeLayout);
		menuFeedBackRelativeLayout.setOnClickListener(this);
		menuDirectionRelativeLayout = (RelativeLayout) findViewById(R.id.menuDirectionRelativeLayout);
		menuDirectionRelativeLayout.setOnClickListener(this);
		menuLoginOutRelativeLayout = (RelativeLayout) findViewById(R.id.menuLoginOutRelativeLayout);
		menuLoginOutRelativeLayout.setOnClickListener(this);
		homeNewsLinearLayout = (LinearLayout) findViewById(R.id.homeNewsLinearLayout);
		homeNewsLinearLayout.setOnClickListener(this);
		homeLearnCenterLinearLayout = (LinearLayout) findViewById(R.id.homeLearnCenterLinearLayout);
		homeLearnCenterLinearLayout.setOnClickListener(this);
		homeCommunityLinearLayout = (LinearLayout) findViewById(R.id.homeCommunityLinearLayout);
		homeCommunityLinearLayout.setOnClickListener(this);
		homeBottomMenuNews = (ImageView) findViewById(R.id.homeBottomMenuNews);
		homeBottomMenuLearnCenter = (ImageView) findViewById(R.id.homeBottomMenuLearnCenter);
		homeBottomMenuCommunity = (ImageView) findViewById(R.id.homeBottomMenuCommunity);
		//test
		MyThread myThread = new MyThread();
	 	new Thread(myThread).start();
		
	}

	@Override
	public void onClick(View view)
	{
		//Events of click
		switch(view.getId())
		{
		case R.id.menuSetting:
			slidingMenu.toggle();
			break;
		case R.id.menuForgotPasswordRelativeLayout:
			Toast.makeText(this, R.string.menuForgotPassword, Toast.LENGTH_SHORT).show();
			break;
		case R.id.menuFeedBackRelativeLayout:
			Toast.makeText(this, R.string.menuFeedBack, Toast.LENGTH_SHORT).show();
			break;
		case R.id.menuDirectionRelativeLayout:
			Toast.makeText(this, R.string.menuDirection, Toast.LENGTH_SHORT).show();
			break;
		case R.id.menuLoginOutRelativeLayout:
			Toast.makeText(this, R.string.menuLoginOut, Toast.LENGTH_SHORT).show();
			break;
		case R.id.homeNewsLinearLayout:
			homeBottomMenuNews.setBackgroundResource(R.drawable.news);
			homeBottomMenuLearnCenter.setBackgroundResource(R.drawable.learn_center_black_white);
		}
	}
	
	@SuppressLint("HandlerLeak")
	Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			Bundle bundle =  msg.getData();
			String result = bundle.getString("result");
			String regex = "<li><a href=\"(.*?)\" title=\"(.*?)\".*?</li>";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(result);
			while(matcher.find()){
				Log.i("Title", matcher.group(2));
				Log.i("Url", matcher.group(1).toString());
			}
		}	
	};
	
	private class MyThread implements Runnable
	{
		@SuppressWarnings("static-access")
		@Override
		public void run()
		{
			String url ="http://news.bjtu.edu.cn/zongheyaowen/" ;	
			String result = GetHTML.getInstance().getHtml(url);
			Message msg = new Message();   
            Bundle bundle = new Bundle();
            bundle.putString("result", result);
            msg.setData(bundle);
            handler.sendMessage(msg);
		}
		
	}
}
