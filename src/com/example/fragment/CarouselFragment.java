package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CarouselFragment extends Fragment implements OnGestureListener
{
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
		view = inflater.inflate(R.layout.fragment_carousel, container, false);
		initView();
		return view;
	}

	@SuppressWarnings("deprecation")
	private void initView()
	{
		linearLayout = (LinearLayout) view
				.findViewById(R.id.carouselLinearLayout);
		linearLayout.getBackground().setAlpha(100);// 设置背景透明
		viewFlipper = (ViewFlipper) view.findViewById(R.id.viewFlipper);
		// 初始化图片数据
		int[] imgs =
		{ R.drawable.test1, R.drawable.test2, R.drawable.test3 };
		gestureDetector = new GestureDetector(this);
		// 添加图片源
		for (int i = 0; i < imgs.length; i++)
		{
			ImageView iv = new ImageView(getActivity());
			iv.setImageResource(imgs[i]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			viewFlipper.addView(iv, new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
		}
		// 添加小圆点
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
		// 自动播放banner图片启动
		AutoFlip.start();
	}

	Thread AutoFlip = new Thread()
	{
		public void run()
		{
			while (isRun)
			{
				try
				{
					Thread.sleep(5000);
					Message msg = new Message();
					msg.what = SHOW_NEXT;
					handler.sendMessage(msg);
				} catch (InterruptedException e)
				{
					isRun = false;
					e.printStackTrace();
				}
			}
		}
	};

	@SuppressLint("HandlerLeak")
	Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if (msg.what == SHOW_NEXT)
			{
				showNextView();
			}
		}
	};

	public void showNextView()
	{
		imgviewList.get(cruneetImg).setImageResource(R.drawable.for_icon);
		Animation lInAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.push_left_in); // 向左滑动左侧进入的渐变效果（alpha 0.1 -> 1.0）
		Animation lOutAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.push_left_out); // 向左滑动右侧滑出的渐变效果（alpha 1.0 -> 0.1）
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
				R.anim.push_right_in); // 向右滑动左侧进入的渐变效果（alpha 0.1 -> 1.0）
		Animation rOutAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0 -> 0.1）
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
			// 从右向左滑动（右进左出）
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
