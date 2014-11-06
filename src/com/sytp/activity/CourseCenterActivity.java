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
 * @author STerOTto ���ĳ���γ̽��뵽�γ�����
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
		// ��ʼ��
		courseMenuArray = new CourseMenu[FIRST_MENU_COUNT];
		courseMenuArray[0] = new CourseMenu();
		courseMenuArray[0].setFirstMenu("�γ���Ϣ");
		courseMenuArray[1] = new CourseMenu();
		courseMenuArray[1].setFirstMenu("�ҵ���ҵ");
		courseMenuArray[1].setSecondMenu(new String[]
		{ "д��ҵ" });
		courseMenuArray[2] = new CourseMenu();
		courseMenuArray[2].setFirstMenu("�ҵĲ���");
		courseMenuArray[2].setSecondMenu(new String[]
		{ "������" });
		courseMenuArray[3] = new CourseMenu();
		courseMenuArray[3].setFirstMenu("�ҵĿ���");
		courseMenuArray[3].setSecondMenu(new String[]
		{ "��ѯ�ɼ�" });
		courseMenuArray[4] = new CourseMenu();
		courseMenuArray[4].setFirstMenu("�γ���Դ");
		courseMenuArray[4].setSecondMenu(new String[]
		{ "ѧϰ��Դ" });
		courseMenuArray[5] = new CourseMenu();
		courseMenuArray[5].setFirstMenu("֪ͨ����");
		courseMenuArray[6] = new CourseMenu();
		courseMenuArray[6].setFirstMenu("��������");
		courseMenuArray[6].setSecondMenu(new String[]
		{ "�������", "�����������", "�鿴��������" });
		courseMenuArray[7] = new CourseMenu();
		courseMenuArray[7].setFirstMenu("�༶Ȧ��");

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
	 * ������¼�
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
				// ���ü�ͷͼ��
				node.setSelected(!node.isSelected());
				if (node.isSelected())
				{
					// �����node����
					if (node.getChildNodes() != null
							&& node.getChildNodes().size() > 0)
					{
						NodeUtils.addNodes(nodeList, position,
								node.getChildNodes(), node.getRetractNum());
					}
				} else
				{
					// ɾ��node����
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
		// �����¼�
		switch (view.getId())
		{
		case R.id.go_back_course_center:
			this.finish();
			break;
		}
	}

	/**
	 * �������� �����ļ����ұ���������node�ڵ��superNode����Ȼ��������position����
	 * ��Ϊposition��������superNode������˳����������position����ʧЧ��
	 */
	private void loadDate()
	{
		for (int i = 0, position = 0; i < FIRST_MENU_COUNT; i++)
		{
			// һ���˵�
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
					// �����˵�
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
