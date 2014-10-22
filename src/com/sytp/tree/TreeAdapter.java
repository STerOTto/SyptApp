package com.sytp.tree;

import java.util.ArrayList;
import java.util.List;

import com.sytp.config.SyptApplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author STerOTto
 * adapter 对象
 */
public class TreeAdapter extends BaseAdapter
{

	private List<Node> nodes = null;

	public TreeAdapter()
	{
		if (nodes == null)
		{
			this.nodes = new ArrayList<Node>();
		}
	}

	public void setData(List<Node> nodes)
	{
		if (nodes == null)
		{
			this.nodes = new ArrayList<Node>();
		} else
		{
			this.nodes = nodes;
		}
		notifyDataSetChanged();
	}

	@Override
	public int getCount()
	{
		return nodes.size();
	}

	@Override
	public Object getItem(int position)
	{
		return nodes.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Node node = nodes.get(position);
		NodeView itemView = null;
		if (convertView == null)
		{
			itemView = new NodeView(SyptApplication.getInstance());
			convertView = itemView;
		} else
		{
			itemView = (NodeView) convertView;
		}
		itemView.setData(node);
		return itemView;
	}

}
