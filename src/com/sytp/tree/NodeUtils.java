package com.sytp.tree;

import java.util.ArrayList;
import java.util.List;


/**
 * Node助手�?    主要提供对node的添加删除操�?
 * @author STerOTto
 *
 */
public class NodeUtils {
	
	/**
	 * 添加node对象
	 * @param nodes 源数�?
	 * @param index 添加�?始的索引
	 * @param addDatas 添加的数�?
	 * @param retractNum 为添加后的数据添加缩�?
	 */
	public static void addNodes(List<Node> nodes,int index,List<Node> addDatas,int retractNum){
		index++;
		retractNum++;
		if(addDatas==null||addDatas.size()==0){
			return ;
		}
		if(nodes==null){
			nodes = new ArrayList<Node>();
		}
		for (int i = 0; i < addDatas.size(); i++) {
			Node n = addDatas.get(i);
			n.setRetractNum(retractNum);
			nodes.add(index+i,n);
		}
	}
	/**
	 * 删除node对象
	 * @param nodes 源数�?
	 * @param index 删除�?始索�?
	 * @param deleteDatas 删除的数�?
	 */
	public static void deleteNodes(List<Node> nodes,int index,List<Node> deleteDatas){
		if(deleteDatas==null||deleteDatas.size()==0){
			return ;
		}
		if(nodes==null||nodes.size()==0){
			return ;
		}
		index++;
		int deleteLength = getOpenNodeLength(deleteDatas);
		for (int i = 0; i < deleteLength; i++) {
			nodes.set(i+index, null);
		}
		while (nodes.contains(null)) {
			nodes.remove(null);
		}
		
	}
	
	/**
	 * 获取要删除的node的长�?
	 * @param deleteDatas 要删除的node数据对象
	 * @return
	 */
	public static int getOpenNodeLength(List<Node> deleteDatas){
		if(deleteDatas==null||deleteDatas.size()==0){
			return 0;
		}
		int l = deleteDatas.size();
		for (int i = 0; i < deleteDatas.size(); i++) {
			Node n = deleteDatas.get(i);
			int length = 0;
			if(n.isSelected()){
				length = getOpenNodeLength(n.getChildNodes());
			}
			//删除了数据以后改变node的箭头指�?
			n.setSelected(false);
			l+=length;
		}
		return l;
	}

}
