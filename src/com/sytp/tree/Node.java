package com.sytp.tree;

import java.util.List;

/**
 * @author STerOTto
 * node对象
 */
public class Node
{
	// 用于展示数据的string变量
	private String name;
	// 放置子对�?
	private List<Node> childNodes;
	// 标记是否选中状�??
	private boolean isSelected = false;
	// 缩进格数
	private int retractNum = 0;
	// 父对�?
	private Node superNode;
	// 记录当前位置的对�?
	private String position;
	// 链接
	private String url;

	public Node getSuperNode()
	{
		return superNode;
	}

	public void setSuperNode(Node superNode)
	{
		this.superNode = superNode;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		if (this.superNode == null || this.superNode.getPosition() == null
				|| this.superNode.getPosition().equalsIgnoreCase(""))
			this.position = String.format("%d", position);
		else
			this.position = String.format("%s,%d",
					this.superNode.getPosition(), position);
	}

	public int getRetractNum()
	{
		return retractNum;
	}

	public void setRetractNum(int retractNum)
	{
		this.retractNum = retractNum;
	}

	public boolean isSelected()
	{
		return isSelected;
	}

	public void setSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Node> getChildNodes()
	{
		return childNodes;
	}

	public void setChildNodes(List<Node> childNodes)
	{
		this.childNodes = childNodes;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
	
}
