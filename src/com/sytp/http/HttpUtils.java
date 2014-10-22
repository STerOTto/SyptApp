package com.sytp.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class HttpUtils
{
	/**
     * �������л�ȡͼƬ����������ʽ����
     * @return
     */
    public static Bitmap getImageViewBitMap(String URL_PATH) throws IOException {
        InputStream inputStream = null;
        Bitmap bitmap = null;
        URL url = new URL(URL_PATH);                    //��������ַ
        if (url != null) {
            //������
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(2000);//�����������ӳ�ʱ��ʱ��
            httpURLConnection.setRequestMethod("GET");        //�������󷽷�ΪGET
            httpURLConnection.setDoInput(true);                //��������
            int responseCode = httpURLConnection.getResponseCode();    // ��ȡ��������Ӧֵ
            Log.d("responseCode", String.valueOf(responseCode));
            if (responseCode == HttpURLConnection.HTTP_OK) {        //��������
                inputStream = httpURLConnection.getInputStream();        //��ȡ������
                bitmap = BitmapFactory.decodeStream(inputStream);
            }
        }
        return bitmap;
    }
}
