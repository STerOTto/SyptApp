package com.example.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;
import com.example.R.color;
import com.example.fragment.CommunityFragment;
import com.example.fragment.LearnCenterFragment;
import com.example.fragment.NewslFragment;
import com.slidingmenu.lib.SlidingMenu;

/**
 * @author STerOTto
 *
 */

public class HomeActivity extends FragmentActivity implements OnClickListener
{
	// Fragment manage
	private NewslFragment newslFragment;
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
		newslFragment = new NewslFragment();
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
				// TODO: handle exception
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
		replaceFragment(newslFragment);
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
			slidingMenu.toggle();
			break;
		case R.id.menuForgotPasswordRelativeLayout:
			Toast.makeText(this, R.string.menuForgotPassword,
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.menuFeedBackRelativeLayout:
			Toast.makeText(this, R.string.menuFeedBack, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.menuDirectionRelativeLayout:
			Toast.makeText(this, R.string.menuDirection, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.menuLoginOutRelativeLayout:
			Toast.makeText(this, R.string.menuLoginOut, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.homeNewsLinearLayout:
			homeBottomMenuNews.setImageResource(R.drawable.news);
			homeBottomMenuLearnCenter
					.setImageResource(R.drawable.learn_center_black_white);
			homeBottomMenuCommunity
					.setImageResource(R.drawable.community_black_white);
			newsTextView.setTextColor(Color.BLUE);
			learnCenterTextView.setTextColor(color.grey_black);
			communityTextView.setTextColor(color.grey_black);
			replaceFragment(newslFragment);
			break;
		case R.id.homeLearnCenterLinearLayout:
			homeBottomMenuNews.setImageResource(R.drawable.news_black_white);
			homeBottomMenuLearnCenter.setImageResource(R.drawable.learn_center);
			homeBottomMenuCommunity
					.setImageResource(R.drawable.community_black_white);
			newsTextView.setTextColor(color.grey_black);
			learnCenterTextView.setTextColor(Color.BLUE);
			communityTextView.setTextColor(color.grey_black);
			replaceFragment(learnCenterFragment);
			break;
		case R.id.homeCommunityLinearLayout:
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
		switch(keyCode)
		{
		case KeyEvent.KEYCODE_BACK:
			this.finish();
			return true;
		case KeyEvent.KEYCODE_MENU:
			slidingMenu.toggle();
			return true;
		default :
			return false;
		}
	}
}
