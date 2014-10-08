package com.example.util;

import android.util.Log;

/**
 * @author STerOTto
 * @category Get HTML by url from Internet 
 * For example : 
 * url ="http://news.bjtu.edu.cn/zongheyaowen/" 
 * Matcher matcher = GetHTML.getInstance()
 * 					.getHtml(url);
 */
public class GetHTML
{

	private static final GetHTML _instance;

	static
	{
		_instance = new GetHTML();
	}

	public static GetHTML getInstance()
	{
		return _instance;
	}

	public static String getHtml(String urlString)
	{
		try
		{
			StringBuffer html = new StringBuffer();
			java.net.URL url = new java.net.URL(urlString); // ���� String ��ʾ��ʽ����
															// URL ����
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url
					.openConnection();// ����һ�� URLConnection ��������ʾ�� URL
										// �����õ�Զ�̶�������ӡ�
			java.io.InputStreamReader isr = new java.io.InputStreamReader(
					conn.getInputStream(), "GB2312");// ���شӴ˴򿪵����Ӷ�ȡ����������
			java.io.BufferedReader br = new java.io.BufferedReader(isr);// ����һ��ʹ��Ĭ�ϴ�С���뻺�����Ļ����ַ���������

			String temp;
			while ((temp = br.readLine()) != null)
			{ // ���ж�ȡ�����
				if (!temp.trim().equals(""))
				{
					html.append(temp).append("\n"); // ����ÿ�к���
				}
			}
			br.close(); // �ر�
			isr.close(); // �ر�
			return html.toString(); // ���ش����������ݵ��ַ�����ʾ��ʽ��
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
