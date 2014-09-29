package com.example.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import android.app.ActionBar.LayoutParams;

import com.example.R;
import com.example.util.GetHTML;


public class NewslFragment extends Fragment implements OnGestureListener
{
	private static final String BASE_URL = "http://bjtu.edu.cn/";
	
	private static ScheduledThreadPoolExecutor stpe = null;
	
	private View view;
	private GestureDetector gestureDetector = null;
	private ViewFlipper viewFlipper = null;
	private LinearLayout linearLayout;
	private int SHOW_NEXT = 1;
	private boolean isRun = true;
	private int cruneetImg = 0;
	List<ImageView> imgviewList;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.fragment_news, container, false);
		initView();
		return view;
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		stpe.shutdown();
	}

	@SuppressWarnings("deprecation")
	private void initView()
	{
		
		linearLayout = (LinearLayout) view
				.findViewById(R.id.carouselLinearLayout);
		linearLayout.getBackground().setAlpha(100);// ���ñ���͸��
		viewFlipper = (ViewFlipper) view.findViewById(R.id.viewFlipper);
		// ��ʼ��ͼƬ����
		int[] imgs =
		{ R.drawable.test1, R.drawable.test2, R.drawable.test3 };
		gestureDetector = new GestureDetector(this);
		// ���ͼƬԴ
		for (int i = 0; i < imgs.length; i++)
		{
			ImageView iv = new ImageView(getActivity());
			iv.setImageResource(imgs[i]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			viewFlipper.addView(iv, new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
		}
		// ���СԲ��
		imgviewList = new ArrayList<ImageView>();
		for (int i = 0; i < imgs.length; i++)
		{
			ImageView iv = new ImageView(getActivity());
			if (i == cruneetImg)
			{
				iv.setImageResource(R.drawable.current_icon);
			} else
			{
				iv.setImageResource(R.drawable.for_icon);
			}
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(8, 8);
			lp.setMargins(4, 4, 4, 4);
			iv.setLayoutParams(lp);
			linearLayout.addView(iv);
			imgviewList.add(iv);
		}
		// �Զ�����bannerͼƬ����,�̳߳�
		stpe = new ScheduledThreadPoolExecutor(5);
		stpe.scheduleWithFixedDelay(AutoFlip,3, 3, TimeUnit.SECONDS);
	}

	Thread AutoFlip = new Thread()
	{
		public void run()
		{
			if (isRun)
			{
				Message msg = new Message();
				msg.what = SHOW_NEXT;
				handlerImg.sendMessage(msg);
			}
		}
	};

	Handler handlerImg = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if (msg.what == SHOW_NEXT)
			{
				showNextView();
			}
		}
	};
	
	private class getNewsThread implements Runnable
	{
		@SuppressWarnings("static-access")
		@Override
		public void run()
		{
			String result = GetHTML.getInstance().getHtml(BASE_URL);
			Message msg = new Message();   
            Bundle bundle = new Bundle();
            bundle.putString("result", result);
            msg.setData(bundle);
            handlerNews.sendMessage(msg);
		}
	}
	
	Handler handlerNews = new Handler()
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

	public void showNextView()
	{
		imgviewList.get(cruneetImg).setImageResource(R.drawable.for_icon);
		Animation lInAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.push_left_in); // ���󻬶�������Ľ���Ч����alpha 0.1 -> 1.0��
		Animation lOutAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.push_left_out); // ���󻬶��Ҳ໬���Ľ���Ч����alpha 1.0 -> 0.1��
		viewFlipper.setInAnimation(lInAnim);
		viewFlipper.setOutAnimation(lOutAnim);
		viewFlipper.showNext();
		if (cruneetImg == imgviewList.size() - 1)
		{
			cruneetImg = 0;
		} else
		{
			cruneetImg++;
		}
		imgviewList.get(cruneetImg).setImageResource(R.drawable.current_icon);
	}

	public void showPreviousView()
	{
		imgviewList.get(cruneetImg).setImageResource(R.drawable.for_icon);
		Animation rInAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.push_right_in); // ���һ���������Ľ���Ч����alpha 0.1 -> 1.0��
		Animation rOutAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.push_right_out); // ���һ����Ҳ໬���Ľ���Ч����alpha 1.0 -> 0.1��
		viewFlipper.setInAnimation(rInAnim);
		viewFlipper.setOutAnimation(rOutAnim);
		viewFlipper.showPrevious();
		if (cruneetImg == 0)
		{
			cruneetImg = imgviewList.size() - 1;
		} else
		{
			cruneetImg--;
		}
		imgviewList.get(cruneetImg).setImageResource(R.drawable.current_icon);
	}

	public boolean onTouchEvent(MotionEvent event)
	{
		return gestureDetector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent arg0)
	{
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY)
	{
		if (e2.getX() - e1.getX() > 120)
		{
			showPreviousView();
			return true;
		} else if (e2.getX() - e1.getX() < -120)
		{ 
			// �������󻬶����ҽ������
			showNextView();
			return true;
		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0)
	{

	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3)
	{
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0)
	{

	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0)
	{
		return false;
	}
}
