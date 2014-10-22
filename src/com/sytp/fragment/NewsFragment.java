package com.sytp.fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.ViewFlipper;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.graphics.Bitmap;

import com.sytp.R;
import com.sytp.activity.WebviewActivity;
import com.sytp.constant.Constant;
import com.sytp.http.HttpUtils;
import com.sytp.util.GetHTML;
import com.sytp.util.StringUtil;


@SuppressLint("HandlerLeak")
public class NewsFragment extends Fragment implements OnGestureListener
{
	private static ScheduledThreadPoolExecutor stpe = null;
	
	private View view;
	private GestureDetector gestureDetector = null;
	private ViewFlipper viewFlipper = null;
	private LinearLayout linearLayout;
	private int SHOW_NEXT = 1;
	private boolean isRun = true;
	private int cruneetImg = 0;
	private List<NewsItem> newsItemList;
	private static final int TITLE_NEWS_COUNT = 5; 
	private List<Bitmap> bitmapList;
	private List<ImageView> imgviewList;
	
	private ListView newsListView;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.fragment_news, container, false);
		try
		{
			initView();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return view;
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		stpe.shutdown();
	}

	@SuppressWarnings("deprecation")
	private void initView() throws IOException
	{
		//��ʼ��UI
		newsListView = (ListView) view.findViewById(R.id.newsList);
		linearLayout = (LinearLayout) view
				.findViewById(R.id.carouselLinearLayout);
		linearLayout.getBackground().setAlpha(100);// ���ñ���͸��
		viewFlipper = (ViewFlipper) view.findViewById(R.id.viewFlipper);
		gestureDetector = new GestureDetector(this);	
		// ���СԲ��
		imgviewList = new ArrayList<ImageView>();
		for (int i = 0; i < TITLE_NEWS_COUNT; i++)
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
		//����HTML����
		new Thread(new NewsThread()).start();
		// �Զ�����bannerͼƬ����,�̳߳�
		stpe = new ScheduledThreadPoolExecutor(5);
		stpe.scheduleWithFixedDelay(AutoFlip,3, 3, TimeUnit.SECONDS);
	}

	Thread AutoFlip = new Thread()
	{
		//ͼƬ�ֲ�����
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
		//����ͼƬ
		public void handleMessage(Message msg)
		{
			if (msg.what == SHOW_NEXT)
			{
				showNextView();
			}
		}
	};
	
	private class NewsThread implements Runnable
	{
		@SuppressWarnings("static-access")
		@Override
		public void run()
		{
			//��ȡHTML
			String result = GetHTML.getInstance().getHtml(Constant.BASE_URL);
			//�滻�����ַ�
			result = StringUtil.replaceBlank(result);
			//�������������
			String regex = "imgUrl[\\[]n]=\"(.*?)\";imgLink[\\[]n]=\"(.*?)\";varvTitle=\'(.*?)\'";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(result);
			//����newsItemList
			newsItemList = new ArrayList<NewsItem>();
			while(matcher.find()){
				NewsItem newsItem = new NewsItem(Constant.BASE_URL+matcher.group(1), matcher.group(2), matcher.group(3));
				newsItemList.add(newsItem);
				Log.i("news", newsItem.toString());
			}
			//����bitmapList
			bitmapList = new ArrayList<Bitmap>();
			for (int i = 0; i < TITLE_NEWS_COUNT; i++)
			{
				try
				{
					bitmapList.add(HttpUtils.getImageViewBitMap(newsItemList.get(i).getImgUrl()));
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			Message msg = new Message();   
            Bundle bundle = new Bundle();
            bundle.putString("result", "OK");
            msg.setData(bundle);
            handlerNews.sendMessage(msg);
		}
	}
	
	Handler handlerNews = new Handler()
	{
		//�������� UI����
		public void handleMessage(Message msg)
		{
			Bundle bundle =  msg.getData();
			String result = bundle.getString("result");
			if("OK".equalsIgnoreCase(result))
			{
				for (int i = 0; i < TITLE_NEWS_COUNT; i++)
				{
					ImageView iv = new ImageView(getActivity());
					iv.setImageBitmap(bitmapList.get(i));
					iv.setScaleType(ImageView.ScaleType.FIT_XY);
					viewFlipper.addView(iv, new LayoutParams(LayoutParams.MATCH_PARENT,
							LayoutParams.MATCH_PARENT));
				}
				List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
				for(NewsItem newsItem : newsItemList)
				{
					HashMap<String, Object> data = new HashMap<String, Object>();
					data.put("news_tv_item", newsItem.getNewsTitle());
					dataList.add(data);
				}
				SimpleAdapter adapter = new SimpleAdapter(getActivity(), dataList, R.layout.item_news, new String[]{"news_tv_item"}, new int[]{R.id.news_tv_item});
				newsListView.setAdapter(adapter);
				newsListView.setOnItemClickListener(new OnItemClickListener()
				{
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id)
					{
						Intent  intent = new Intent();
						intent.putExtra("url", newsItemList.get(position).getNewsLink());
						intent.setClass(getActivity(), WebviewActivity.class);
						startActivity(intent);
					}
				});
			}
		}	
	};
	

	public void showNextView()
	{
		//��ʾ��һ��ͼƬ
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
		//��ʾǰһ��ͼƬ
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
	
	/**
	 * @author STerOTto
	 * �������ӵ���
	 */
	class NewsItem
	{
		//ͼƬ��ַ
		private String imgUrl;
		//�������ӵ�ַ
		private String newsLink;
		//���ű���
		private String newsTitle;
		
		public NewsItem(String imgUrl, String newsLink, String newsTitle)
		{
			super();
			this.imgUrl = imgUrl;
			this.newsLink = newsLink;
			this.newsTitle = newsTitle;
		}
		public String getImgUrl()
		{
			return imgUrl;
		}
		public void setImgUrl(String imgUrl)
		{
			this.imgUrl = imgUrl;
		}
		public String getNewsLink()
		{
			return newsLink;
		}
		public void setNewsLink(String newsLink)
		{
			this.newsLink = newsLink;
		}
		public String getNewsTitle()
		{
			return newsTitle;
		}
		public void setNewsTitle(String newsTitle)
		{
			this.newsTitle = newsTitle;
		}
		@Override
		public String toString()
		{
			return "NewsItem [imgUrl=" + imgUrl + ", newsLink=" + newsLink
					+ ", newsTitle=" + newsTitle + "]";
		}
	}
}
