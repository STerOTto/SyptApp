package com.sytp.tree;


import com.sytp.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Item 视图对象
 * @author STerOTto
 *
 */
public class NodeView extends RelativeLayout {
	
	//缩进长度
	private int retractLength = 30;
	//箭头
	private ImageView iocn;
	//展示数据的textview
	private TextView msg;
	
	private Node node ;
	/**
	 * 设置数据
	 */
	public void setData(Node node){
		this.node = node;
		if(node==null){
			clearData();
		}else{
			loadData();
		}
	}
	
	public Node getData(){
		return node;
	}
	
	private void loadData(){
		if(node==null){
			return ;
		}
		//当没有子对象是删除箭
		if(node.getChildNodes()==null||node.getChildNodes().size()==0){
			iocn.setImageBitmap(null);
		}else{
			//设置不同状的箭头
			if(node.isSelected()){
				iocn.setImageDrawable(getContext().getResources().getDrawable(R.drawable.hidden));
			}else{
				iocn.setImageDrawable(getContext().getResources().getDrawable(R.drawable.show));
			}
		}
		//在不同级别目录下面设置缩进的格数
		msg.setPadding(retractLength*node.getRetractNum(), 0, 0, 0);
		msg.setText(node.getName());
		
	}
	/**
	 * 清空数据
	 */
	private void clearData(){
		iocn.setImageBitmap(null);
		msg.setText("");
	}

	private void init(){
		View view = LayoutInflater.from(getContext()).inflate(R.layout.node, null);
		addView(view);
		iocn = (ImageView) view.findViewById(R.id.icon);
		msg = (TextView) view.findViewById(R.id.msg);
	}

	public NodeView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public NodeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public NodeView(Context context) {
		super(context);
		init();
	}
	
	

}
