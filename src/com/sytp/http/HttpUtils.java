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
     * 从网络中获取图片，以流的形式返回
     * @return
     */
    public static Bitmap getImageViewBitMap(String URL_PATH) throws IOException {
        InputStream inputStream = null;
        Bitmap bitmap = null;
        URL url = new URL(URL_PATH);                    //服务器地址
        if (url != null) {
            //打开连接
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(2000);//设置网络连接超时的时间
            httpURLConnection.setRequestMethod("GET");        //设置请求方法为GET
            httpURLConnection.setDoInput(true);                //打开输入流
            int responseCode = httpURLConnection.getResponseCode();    // 获取服务器响应值
            Log.d("responseCode", String.valueOf(responseCode));
            if (responseCode == HttpURLConnection.HTTP_OK) {        //正常连接
                inputStream = httpURLConnection.getInputStream();        //获取输入流
                bitmap = BitmapFactory.decodeStream(inputStream);
            }
        }
        return bitmap;
    }
}
