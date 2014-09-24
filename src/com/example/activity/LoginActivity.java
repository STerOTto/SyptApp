package com.example.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.R;
import com.example.entity.UserControl;
import com.example.http.AndroidToServer;
import com.google.gson.Gson;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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
import android.widget.Toast;

/**
 * @author STerOTto
 * @use use for student login in the sypt
 */
public class LoginActivity extends Activity implements OnClickListener
{
	private Animation my_Translate;// Loading animation
	private RelativeLayout relativeLayout_login;
	private Button login;
	private TextView visitorLogin;
	private TextView forgetPassword;
	private EditText studentId;
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
		studentId = (EditText) findViewById(R.id.studengtId);
		passwordTxt = (EditText) findViewById(R.id.passwordTxt);

		// click Listener
		login.setOnClickListener(this);
		forgetPassword.setOnClickListener(this);
		visitorLogin.setOnClickListener(this);
	}

	private void anim()
	{
		// Loading animation
		my_Translate = AnimationUtils.loadAnimation(this, R.anim.my_translate);
	}

	@SuppressLint("ShowToast")
	@Override
	public void onClick(View view)
	{
		// Click events
		switch (view.getId())
		{
		case (R.id.login):		
			// Login
			MyThread myThread = new MyThread();
		 	new Thread(myThread).start();
			break;
		case (R.id.fogetPassword):
			// User forgot password
			break;
		case (R.id.visitorLogin):
			// User login as a visitor
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, HomeActivity.class);
			startActivity(intent);
			break;
		default:
			// Do nothing
			break;
		}

	}

	@SuppressWarnings({ "static-access" })
	public UserControl loginCheck(String userId, String password)
	{
		// According the values of userId and password check user login is success
		UserControl userControl = new UserControl();
		try
		{
			AndroidToServer androidClient = new AndroidToServer();
			String url = androidClient.BASE_URL + "login.do";
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("userId", userId));
			params.add(new BasicNameValuePair("password", password));
			String result = androidClient.doPost(url, params);
			Gson gson = new Gson();
			userControl = gson.fromJson(result, UserControl.class);
			return userControl;
		} catch (Exception e)
		{
		}
		return userControl;
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
			 UserControl logInfo = new UserControl();
			 logInfo = gson.fromJson(result, UserControl.class);
			 if (null == logInfo.getMessage() || "".equals(logInfo.getMessage()))
				{
					Toast.makeText(getApplicationContext(), "连接超时，请检查您的网络", 1)
							.show();
				} else if ("4".equals(logInfo.getMessage()))
				{
					// 4 : The type of user is student
					bundle.putSerializable("logInfo", logInfo);
					Intent intent = new Intent();
					intent.putExtras(bundle);
					intent.setClass(LoginActivity.this, HomeActivity.class);
					startActivity(intent);
				} else
				{
					// wrong studentId or password
					Toast.makeText(getApplicationContext(), "用户名或密码错误", 1).show();
				}
		 }
	};
	
	private class MyThread implements Runnable
	{
		@SuppressWarnings("static-access")
		@Override
		public void run()
		{
			AndroidToServer androidClient = new AndroidToServer();
			String url = androidClient.BASE_URL + "login.do";
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("userId", studentId.getText().toString()));
			params.add(new BasicNameValuePair("password", passwordTxt.getText().toString()));
			String result = androidClient.doPost(url, params);
			Message msg = new Message();   
            Bundle bundle = new Bundle();
            bundle.putString("result", result);
            msg.setData(bundle);
            handler.sendMessage(msg);
		}
	}
}
