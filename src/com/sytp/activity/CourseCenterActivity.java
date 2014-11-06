package com.sytp.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.sytp.R;
import com.sytp.entity.StudentCourse;
import com.sytp.tree.Node;
import com.sytp.tree.NodeUtils;
import com.sytp.tree.NodeView;
import com.sytp.tree.TreeAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/**
 * @author STerOTto 点击某个课程进入到课程中心
 */
public class CourseCenterActivity extends Activity implements OnClickListener
{
	private static final int FIRST_MENU_COUNT = 8;
	private ListView lv_course_menu;
	private ImageView goBack;
	private TreeAdapter treeAdapter;
	private List<Node> nodeList;
	private CourseMenu[] courseMenuArray;
	private StudentCourse studentCourse;
	private static final String[] courseUrl = new String[]
	{ "getCourseIntroduction.do", "doWork_taskList.do", "test.do",
			"inquiryscores.do", "abtainResourceTypeInfo.do",
			"getAllInNotice.do", "zjzlist.do", "viewmymessage.do",
			"viewothermessage.do", "class.jsp" };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_course_center);
		initView();
	}

	public void initView()
	{
		// 初始化
		courseMenuArray = new CourseMenu[FIRST_MENU_COUNT];
		courseMenuArray[0] = new CourseMenu();
		courseMenuArray[0].setFirstMenu("课程信息");
		courseMenuArray[1] = new CourseMenu();
		courseMenuArray[1].setFirstMenu("我的作业");
		courseMenuArray[1].setSecondMenu(new String[]
		{ "写作业" });
		courseMenuArray[2] = new CourseMenu();
		courseMenuArray[2].setFirstMenu("我的测试");
		courseMenuArray[2].setSecondMenu(new String[]
		{ "做测试" });
		courseMenuArray[3] = new CourseMenu();
		courseMenuArray[3].setFirstMenu("我的考试");
		courseMenuArray[3].setSecondMenu(new String[]
		{ "查询成绩" });
		courseMenuArray[4] = new CourseMenu();
		courseMenuArray[4].setFirstMenu("课程资源");
		courseMenuArray[4].setSecondMenu(new String[]
		{ "学习资源" });
		courseMenuArray[5] = new CourseMenu();
		courseMenuArray[5].setFirstMenu("通知公告");
		courseMenuArray[6] = new CourseMenu();
		courseMenuArray[6].setFirstMenu("答疑中心");
		courseMenuArray[6].setSecondMenu(new String[]
		{ "提出问题", "我提出的问题", "查看所有问题" });
		courseMenuArray[7] = new CourseMenu();
		courseMenuArray[7].setFirstMenu("班级圈子");

		studentCourse = new StudentCourse();
		studentCourse = (StudentCourse) getIntent().getSerializableExtra(
				"studentCourse");
		Log.d("studentCourse", studentCourse.toString());

		lv_course_menu = (ListView) findViewById(R.id.fragment_lv_course_menu);
		goBack = (ImageView) findViewById(R.id.go_back_course_center);
		treeAdapter = new TreeAdapter();
		nodeList = new ArrayList<Node>();
		loadDate();
		treeAdapter.setData(nodeList);
		lv_course_menu.setAdapter(treeAdapter);
		clickListener();
	}

	/**
	 * 鼠标点击事件
	 */
	@SuppressLint("ShowToast")
	private void clickListener()
	{
		lv_course_menu.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				Toast.makeText(getApplicationContext(), "position:"+position, Toast.LENGTH_SHORT).show();
				NodeView nodeView = (NodeView) view;
				Node node = nodeView.getData();
				// 设置箭头图标
				node.setSelected(!node.isSelected());
				if (node.isSelected())
				{
					// 添加子node对象
					if (node.getChildNodes() != null
							&& node.getChildNodes().size() > 0)
					{
						NodeUtils.addNodes(nodeList, position,
								node.getChildNodes(), node.getRetractNum());
					}
				} else
				{
					// 删除node对象
					NodeUtils.deleteNodes(nodeList, position,
							node.getChildNodes());
				}
				treeAdapter.notifyDataSetChanged();

			}

		});
		goBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View view)
	{
		// 单击事件
		switch (view.getId())
		{
		case R.id.go_back_course_center:
			this.finish();
			break;
		}
	}

	/**
	 * 加载数据 方法的加载我必须先设置node节点的superNode对象，然后在设置position对象。
	 * 因为position对象依赖superNode对象，若顺序有误则导致position数据失效。
	 */
	private void loadDate()
	{
		for (int i = 0, position = 0; i < FIRST_MENU_COUNT; i++)
		{
			// 一级菜单
			Node node = new Node();
			List<Node> nodeChildList = new ArrayList<Node>();
			node.setSuperNode(null);
			node.setName(courseMenuArray[i].getFirstMenu());
			node.setPosition(i);
			if (null == courseMenuArray[i].getSecondMenu()
					|| 0 == courseMenuArray[i].getSecondMenu().length)
			{
				node.setUrl(courseUrl[position]);
				position++;
			} else
			{
				for (int j = 0; j < courseMenuArray[i].getSecondMenu().length; j++)
				{
					// 二级菜单
					Node childNode = new Node();
					childNode.setName(courseMenuArray[i].getSecondMenu()[j]);
					childNode.setSuperNode(node);
					childNode.setPosition(j);
					childNode.setUrl(courseUrl[position]);
					position++;
					nodeChildList.add(childNode);
				}
			}
			node.setChildNodes(nodeChildList);
			nodeList.add(node);
		}

	}

	class CourseMenu
	{
		private String firstMenu;
		private String[] secondMenu;

		public String getFirstMenu()
		{
			return firstMenu;
		}

		public void setFirstMenu(String firstMenu)
		{
			this.firstMenu = firstMenu;
		}

		public String[] getSecondMenu()
		{
			return secondMenu;
		}

		public void setSecondMenu(String[] secondMenu)
		{
			this.secondMenu = secondMenu;
		}

		@Override
		public String toString()
		{
			return "CourseMenu [firstMenu=" + firstMenu + ", secondMenu="
					+ Arrays.toString(secondMenu) + "]";
		}
	}
}
