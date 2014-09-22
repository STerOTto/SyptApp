//package com.example.fragment;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import com.example.R;
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//import android.widget.Toast;
//
//public class HomeMenuFragment extends Fragment
//{
//	private final static Integer[] MenuImgIds =
//		{ 
//			R.drawable.lock, 
//			R.drawable.write,
//			R.drawable.paper, 
//			R.drawable.out 
//		};
//	private final static String[] MenuItems =
//		{ 
//			"修改密码", 
//			"意见反馈", 
//			"使用说明", 
//			"退出登录" 
//		};
//	private final static Integer GO_ROGHT = R.drawable.go_right;
//
//	private View view;
//	private ListView listView;
//
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState)
//	{
//		view = inflater.inflate(R.layout.fragment_home_menu, container, false);
//		return view;
//	}
//
//	public void onCreate(Bundle savedInstanceState)
//	{
//		super.onCreate(savedInstanceState);
//	}
//
//	private void initView()
//	{
//		//初始化UI
//		listView = (ListView) view
//				.findViewById(R.id.fragment_home_menu_listview);
//		List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
//		for (int i = 0; i < MenuItems.length; i++)
//		{
//			HashMap<String, Object> data = new HashMap<String, Object>();
//			data.put("imgitem", MenuImgIds[i]);
//			data.put("listItem", MenuItems[i]);
//			data.put("goRight", GO_ROGHT);
//			dataList.add(data);
//		}
//		SimpleAdapter adapter = new SimpleAdapter(getActivity(), dataList,
//				R.layout.home_list_item_style, new String[]
//				{ "imgItem", "listItem", "goRight" }, new int[]
//				{ R.id.imgItem, R.id.listItem, R.id.goRight });
//		//data表示显示的数据，一个Map为一行，List<Map> dataList表示多行  
//		//R.layout.home_list_item_style表示一个item的布局  
//		//new String[]{"imgItem", "listItem", "goRight" }表示将key="imgitem"的值映射到R.id.imgItem上 
//		listView.setAdapter(adapter);
//		listView.setOnItemClickListener(new OnItemClickListener()
//		{
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position,
//					long id)
//			{
//				Toast.makeText(getActivity(), "clicked:"+position, Toast.LENGTH_SHORT).show();
//				switch(position)
//				{
//					
//				}
//			}
//			
//		});
//	}
//}
