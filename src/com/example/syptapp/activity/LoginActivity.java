package com.example.syptapp.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author STerOTto
 *@use use for student login in the sytp
 */
public class LoginActivity extends Activity implements OnClickListener
{
	private Animation my_Translate;// Loading animation
	private RelativeLayout relativeLayout_login;
	private Button login;
	private TextView visitorLogin;
	private TextView forgetPassword;
	private EditText studengtId;
	private EditText passwordTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		initView();
		anim();
		relativeLayout_login.startAnimation(my_Translate);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	private void initView()
	{
		// UI initialization
		relativeLayout_login = (RelativeLayout) findViewById(R.id.relativeLayout_login);
		login = (Button) findViewById(R.id.login);
		forgetPassword = (TextView) findViewById(R.id.fogetPassword);
		visitorLogin = (TextView) findViewById(R.id.visitorLogin);
		studengtId = (EditText) findViewById(R.id.studengtId);
		passwordTxt = (EditText) findViewById(R.id.passwordTxt);
		
		// click Listener
		login.setOnClickListener(this);
		forgetPassword.setOnClickListener(this);
		visitorLogin.setOnClickListener(this);
		
	}
	private void anim()
	{
		// Loading animation
		my_Translate = AnimationUtils.loadAnimation(this,R.anim.my_translate);
	}

	@Override
	public void onClick(View view)
	{
		// Click events
		switch(view.getId())
		{
		case(R.id.login):
			// Login
			break;
		case(R.id.fogetPassword):
			// User forgot password 
			break;
		case(R.id.visitorLogin):
			// User login as a visitor
			break;
		default :
			// Do nothing
			break;
		}
		
	}
}
