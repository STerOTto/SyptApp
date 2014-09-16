package com.example.http;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * @author STerOTto 
 * app communication to server
 */
public class AndroidToServer
{
	private static HttpParams httpParams;
	private static DefaultHttpClient httpClient;
	private static String JSESSIONID; // ����һ����̬���ֶΣ�����sessionID
	public static final String BASE_URL = "http://202.112.154.51/SYTP/";

	/**
	 * @return
	 * @throws Exception
	 * 
	 */
	public static DefaultHttpClient getHttpClient() throws Exception
	{
		// ���� HttpParams ���������� HTTP ��������һ���ֲ��Ǳ���ģ�
		httpParams = new BasicHttpParams();
		// �������ӳ�ʱ�� Socket ��ʱ���Լ� Socket �����С
		HttpConnectionParams.setConnectionTimeout(httpParams, 20 * 1000);
		HttpConnectionParams.setSoTimeout(httpParams, 20 * 1000);
		HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
		// �����ض���ȱʡΪ true
		HttpClientParams.setRedirecting(httpParams, true);
		// ���� user agent
		String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6";
		HttpProtocolParams.setUserAgent(httpParams, userAgent);
		// ����һ�� HttpClient ʵ��
		// ע�� HttpClient httpClient = new HttpClient(); ��Commons HttpClient
		// �е��÷����� Android 1.5 ��������Ҫʹ�� Apache ��ȱʡʵ�� DefaultHttpClient
		httpClient = new DefaultHttpClient(httpParams);
		return httpClient;
	}

	/**
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String doGet(String url, Map params) throws Exception
	{
		/* ����HTTPGet���� */
		String paramStr = "";
		if (params != null)
		{
			Iterator iter = params.entrySet().iterator();
			while (iter.hasNext())
			{
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				paramStr += paramStr = "&" + key + "=" + val;
			}
		}
		if (!paramStr.equals(""))
		{
			paramStr = paramStr.replaceFirst("&", "?");
			url += paramStr;
		}
		HttpGet httpRequest = new HttpGet(url);
		if (null != JSESSIONID)
		{
			httpRequest.setHeader("Cookie", "JSESSIONID=" + JSESSIONID);
		}
		String strResult = "doGetError";
		httpClient = getHttpClient();
		/* �������󲢵ȴ���Ӧ */
		HttpResponse httpResponse = httpClient.execute(httpRequest);
		/* ��״̬��Ϊ200 ok */
		if (httpResponse.getStatusLine().getStatusCode() == 200)
		{
			/* ���������� */
			strResult = EntityUtils.toString(httpResponse.getEntity());
			/* ��ȡcookieStore */
			CookieStore cookieStore = httpClient.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			for (int i = 0; i < cookies.size(); i++)
			{
				if ("JSESSIONID".equals(cookies.get(i).getName()))
				{
					JSESSIONID = cookies.get(i).getValue();
					break;
				}
			}
		} else
		{
			strResult = "Error Response: "
					+ httpResponse.getStatusLine().toString();
		}
		Log.v("strResult", strResult);
		return strResult;
	}

	/**
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url, List<NameValuePair> params)
	{
		/* ����HTTPPost���� */
		HttpPost httpRequest = new HttpPost(url);
		Log.v("url", url);
		String strResult = "doPostError";
		try
		{
		/* ������������������� */
		if (params != null && params.size() > 0)
		{
			Log.v("params",params.toString());
			httpRequest.setEntity(new UrlEncodedFormEntity(params, "gbk"));
		}
		if (null != JSESSIONID)
		{
			httpRequest.setHeader("Cookie", "JSESSIONID=" + JSESSIONID);
			Log.i("JSESSIONID", JSESSIONID);
		}
		/* �������󲢵ȴ���Ӧ */
			httpClient = getHttpClient();
		Log.v("httpClient", httpClient.toString());
		HttpResponse httpResponse = httpClient.execute(httpRequest);
		Log.v("httpResponse", httpResponse.toString());
		/* ��״̬��Ϊ200 ok */
		Log.v("status", String.valueOf(httpResponse.getStatusLine().getStatusCode()));
		if (httpResponse.getStatusLine().getStatusCode() == 200)
		{		
			/* ���������� */
			strResult = EntityUtils.toString(httpResponse.getEntity());
			/* ��ȡcookieStore */
			CookieStore cookieStore = httpClient.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			for (int i = 0; i < cookies.size(); i++)
			{
				if ("JSESSIONID".equals(cookies.get(i).getName()))
				{
					JSESSIONID = cookies.get(i).getValue();
					Log.i("JSESSIONID", JSESSIONID);
					break;
				}
			}
		}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			Log.e("error", e.toString());
			e.printStackTrace();
		}
		Log.v("strResult", strResult);
		return strResult;
	}

}