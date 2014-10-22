package com.sytp.activity;


import com.sytp.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

/**
 * @author STerOTto
 * 
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebviewActivity extends Activity implements OnClickListener
{

	/** Called when the activity is first created. */
	private WebView webview;
	private ImageView go_back;

	/**
	 * 初始化UI
	 */
	@SuppressWarnings("deprecation")
	@SuppressLint("SetJavaScriptEnabled")
	private void initview(String url)
	{
		// webview设置
		webview = (WebView) findViewById(R.id.webviewId);
		webview.setWebViewClient(new HolleWebViewClient());
		webview.loadUrl(url);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setSupportZoom(true);
		webview.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.getSettings().setUseWideViewPort(true);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.requestFocus();
		// 返回按钮
		go_back = (ImageView) findViewById(R.id.go_back);
		go_back.setOnClickListener(this);

	}

	/*
	 * 点击响应事件 (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.go_back:
			this.finish();
			break;
		}

	}

	@SuppressLint("SetJavaScriptEnabled")
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_webview);
		Intent intent = getIntent();
		String url = intent.getStringExtra("url");
		Log.d("url", url);
		initview(url);

	}

	public boolean onKeyDown(int keyCoder, KeyEvent event)
	{
		if ((keyCoder == KeyEvent.KEYCODE_BACK) && webview.canGoBack())
		{
			webview.goBack();
			return true;
		} else if ((keyCoder == KeyEvent.KEYCODE_BACK) && !webview.canGoBack())
		{
			WebviewActivity.this.finish();
		}
		return false;

	}

	private class HolleWebViewClient extends WebViewClient
	{
		public boolean shouldOverrideUrlLoading(WebView view, String url)
		{
			view.loadUrl(url);
			return true;
		}
	}

}
