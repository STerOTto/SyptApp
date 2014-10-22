package com.sytp.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.sytp.R;
import com.sytp.activity.CourseCenterActivity;
import com.sytp.config.SyptApplication;
import com.sytp.constant.Constant;
import com.sytp.entity.StudentCourse;
import com.sytp.entity.UserControl;
import com.sytp.http.AndroidToServer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/**
 * @author STerOTto ѧϰ���ģ���ʾ��ѧ�������пγ�
 */
public class LearnCenterFragment extends Fragment
{
	private View view;
	private UserControl logInfo;// ��¼�Ļ�����Ϣ
	private ListView courseList;// ���пγ̵� list view
	private UserControl userControl;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.fragement_learn_center, container,
				false);
		initView();
		return view;
	}

	public void initView()
	{
		// ��ʼ��UI
		courseList = (ListView) view.findViewById(R.id.courseList);
		SyptApplication syptApplication = (SyptApplication) getActivity().getApplication();
		logInfo = syptApplication.getUserControl();
		new Thread(new CourseTread()).start();
	}

	class CourseTread implements Runnable
	{
		// ��ȡ��ǰѧ�������пγ�
		@SuppressWarnings("static-access")
		@Override
		public void run()
		{
			AndroidToServer androidClient = new AndroidToServer();
			String url = androidClient.BASE_URL + "showCourse.do";
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("id", logInfo.getUserId()));
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
		// �γ���Ϣ����
		public void handleMessage(Message msg)
		{
			Bundle bundle = msg.getData();
			String result = bundle.getString("result");
			if (null == result || "doPostError".equalsIgnoreCase(result)
					|| "".equalsIgnoreCase(result))
			{
				// ��ȡ�γ�Ϊ��
				Toast.makeText(getActivity(), "���ӳ�ʱ��������������", 1).show();
				return;
			} else
			{
				// ��ȡ���γ�
				Gson gson = new Gson();
				userControl = gson.fromJson(result, UserControl.class);
				List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
				for (StudentCourse studentCourse : userControl.getSc())
				{
					HashMap<String, Object> hashMap = new HashMap<String, Object>();
					hashMap.put("course_item", studentCourse.getCourseTeacher()
							.getCourse().getName());
					dataList.add(hashMap);
				}
				SimpleAdapter adapter = new SimpleAdapter(getActivity(),
						dataList, R.layout.item_course,
						new String[] { "course_item" },
						new int[] { R.id.course_tv_item });
				courseList.setAdapter(adapter);
				courseList.setOnItemClickListener(new OnItemClickListener()
				{
					// �γ̵���¼�
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id)
					{
						Intent intent = new Intent();
						intent.putExtra("url", Constant.SY_BASE_URL
								+ "enterCourse.do?studentCourseId="
								+ userControl.getSc().get(position)
										.getStudentCourseId());
						intent.setClass(getActivity(), CourseCenterActivity.class);
						startActivity(intent);
					}
				});
			}
		};
	};
}
