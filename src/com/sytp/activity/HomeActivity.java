package com.sytp.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.slidingmenu.lib.SlidingMenu;
import com.sytp.R;
import com.sytp.R.color;
import com.sytp.config.SyptApplication;
import com.sytp.entity.UserControl;
import com.sytp.fragment.CommunityFragment;
import com.sytp.fragment.LearnCenterFragment;
import com.sytp.fragment.NewsFragment;
import com.sytp.http.AndroidToServer;

/**
 * @author STerOTto
 * @description 主界面
 */

public class HomeActivity extends FragmentActivity implements OnClickListener
{
	// Fragment manage
	private NewsFragment newsFragment;
	private LearnCenterFragment learnCenterFragment;
	private CommunityFragment communityFragment;
	// Sliding menu
	private SlidingMenu slidingMenu;
	private ImageView menuSetting;
	// UI widget
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
	private TextView newsTextView;
	private TextView learnCenterTextView;
	private TextView communityTextView;
	// Application
	private SyptApplication syptApplication;
	// UserContril
	private UserControl logInfo;
	private EditText studentId ;
	private EditText password ;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		initView();
	}

	private void initSlidingMenu()
	{
		// SlidingMenu initialization
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		slidingMenu.setShadowWidth(5);
		slidingMenu.setShadowDrawable(R.drawable.ic_launcher);
		slidingMenu.setFadeDegree(0.35f);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setMenu(R.layout.left_menu);
		WindowManager wManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		@SuppressWarnings("deprecation")
		int screenWidth = wManager.getDefaultDisplay().getWidth();
		slidingMenu.setBehindWidth((int) (screenWidth * 0.6));
	}

	private void initFragment()
	{
		// Fragment initialization
		newsFragment = new NewsFragment();
		learnCenterFragment = new LearnCenterFragment();
		communityFragment = new CommunityFragment();

	}

	private void replaceFragment(Fragment newFragment)
	{
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		if (!newFragment.isAdded())
		{
			try
			{
				fragmentTransaction.replace(R.id.emptyFragment, newFragment);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();

			} catch (Exception e)
			{
				// AppConstants.printLog(e.getMessage());
				Log.e("errer", e.toString());
			}
		} else
			fragmentTransaction.show(newFragment);

	}

	private void initView()
	{
		// UI initialization
		initSlidingMenu();
		initFragment();
		replaceFragment(newsFragment);
		// 获取登录信息
		syptApplication = (SyptApplication) getApplication();
		logInfo = syptApplication.getUserControl();
		// menuSetting
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
		newsTextView = (TextView) findViewById(R.id.newsTextView);
		learnCenterTextView = (TextView) findViewById(R.id.learnCenterTextView);
		communityTextView = (TextView) findViewById(R.id.communityTextView);
	}

	@Override
	public void onClick(View view)
	{
		// Events of click
		switch (view.getId())
		{
		case R.id.menuSetting:
			// 显示菜单
			slidingMenu.toggle();
			break;
		case R.id.menuForgotPasswordRelativeLayout:
			// 忘记密码
			Toast.makeText(this, R.string.menuForgotPassword,
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.menuFeedBackRelativeLayout:
			// 意见反馈
			Toast.makeText(this, R.string.menuFeedBack, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.menuDirectionRelativeLayout:
			// 使用说明
			Toast.makeText(this, R.string.menuDirection, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.menuLoginOutRelativeLayout:
			// 退出登录
			Toast.makeText(this, R.string.menuLoginOut, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.homeNewsLinearLayout:
			// 校内新闻
			homeBottomMenuNews.setImageResource(R.drawable.news);
			homeBottomMenuLearnCenter
					.setImageResource(R.drawable.learn_center_black_white);
			homeBottomMenuCommunity
					.setImageResource(R.drawable.community_black_white);
			newsTextView.setTextColor(Color.BLUE);
			learnCenterTextView.setTextColor(color.grey_black);
			communityTextView.setTextColor(color.grey_black);
			replaceFragment(newsFragment);
			break;
		case R.id.homeLearnCenterLinearLayout:
			// 学习中心
			if (null == logInfo||!"4".equals(logInfo.getMessage()))
			{
				// 未登陆或者登陆失败
				showLoginDialog();
			} else
			{
				homeBottomMenuNews
						.setImageResource(R.drawable.news_black_white);
				homeBottomMenuLearnCenter
						.setImageResource(R.drawable.learn_center);
				homeBottomMenuCommunity
						.setImageResource(R.drawable.community_black_white);
				newsTextView.setTextColor(color.grey_black);
				learnCenterTextView.setTextColor(Color.BLUE);
				communityTextView.setTextColor(color.grey_black);
				replaceFragment(learnCenterFragment);
			}
			break;
		case R.id.homeCommunityLinearLayout:
			// 我的圈子
			homeBottomMenuNews.setImageResource(R.drawable.news_black_white);
			homeBottomMenuLearnCenter
					.setImageResource(R.drawable.learn_center_black_white);
			homeBottomMenuCommunity.setImageResource(R.drawable.community);
			newsTextView.setTextColor(color.grey_black);
			learnCenterTextView.setTextColor(color.grey_black);
			communityTextView.setTextColor(Color.BLUE);
			replaceFragment(communityFragment);
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
		case KeyEvent.KEYCODE_BACK:
			this.finish();
			return true;
		case KeyEvent.KEYCODE_MENU:
			slidingMenu.toggle();
			return true;
		default:
			return false;
		}
	}
	
	void showLoginDialog()
	{
		LayoutInflater dialogInflater = getLayoutInflater();
		View dialogLayoutView = dialogInflater.inflate(R.layout.dialog_login,
				(ViewGroup) findViewById(R.id.dialogLogin));
		studentId = (EditText) dialogLayoutView.findViewById(R.id.dialogStudentId);
		password = (EditText) dialogLayoutView.findViewById(R.id.dialogPassword);
		new AlertDialog.Builder(this)
				.setTitle("请登录")
				.setView(dialogLayoutView)
				.setPositiveButton("登录",
						new DialogInterface.OnClickListener()
						{
							// 点击登录
							@Override
							public void onClick(DialogInterface dialog,
									int which)
							{
								new Thread(new LoginThread()).start();
							}
						})
				.setNegativeButton("取消",
						new DialogInterface.OnClickListener()
						{
							// 点击取消
							@Override
							public void onClick(DialogInterface dialog,
									int which)
							{
								// 取消不采取任何操作
							}
						}).show();
	}
	
	class LoginThread implements Runnable
	{
		// 登录进程
		@SuppressWarnings("static-access")
		@Override
		public void run()
		{
			AndroidToServer androidClient = new AndroidToServer();
			String url = androidClient.BASE_URL + "login.do";
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("userId", studentId.getText().toString()));
			params.add(new BasicNameValuePair("password", password.getText().toString()));
			String result = androidClient.doPost(url, params);
			Message msg = new Message();   
            Bundle bundle = new Bundle();
            bundle.putString("result", result);
            msg.setData(bundle);
            handler.sendMessage(msg);
		}
	}
	
	@SuppressLint({ "HandlerLeak", "ShowToast" })
	Handler handler = new Handler()
	{
		public void handleMessage(Message msg) 
		{
			 
			 Bundle bundle =  msg.getData();
			 String result = bundle.getString("result");
			 if(null == result||"doPostError".equalsIgnoreCase(result)||"".equalsIgnoreCase(result))
			 {
				 Toast.makeText(getApplicationContext(), "连接超时，请检查您的网络", 1)
					.show();
				 return;
			 }
			 Gson gson = new Gson();
			 UserControl user = new UserControl();
			 user = gson.fromJson(result, UserControl.class);
			 if (null == user.getMessage() || "".equals(user.getMessage()))
				{
					Toast.makeText(getApplicationContext(), "连接超时，请检查您的网络", 1)
							.show();
				} else if ("4".equals(user.getMessage()))
				{
					// 4 : The type of user is student
					logInfo = new UserControl();
					logInfo = user;
					syptApplication.setUserControl(logInfo);
				} else
				{
					// wrong studentId or password
					Toast.makeText(getApplicationContext(), "用户名或密码错误", 1).show();
				}
		};
	};
}
