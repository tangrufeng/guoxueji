package com.zhuyin.gxj.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Tom on 16/7/14.
 */
public class NetUtils {
    private static String TAG = "NetUtils";

    public static String doPost(String target, String content) {
        Log.d(TAG,target+"?"+content);

        String result="";
        try {
            URL url = new URL(target);
            HttpURLConnection urlConn = (HttpURLConnection) url
                    .openConnection(); // 创建一个HTTP连接
            urlConn.setRequestMethod("POST"); // 指定使用POST请求方式
            urlConn.setDoInput(true); // 向连接中写入数据
            urlConn.setDoOutput(true); // 从连接中读取数据
            urlConn.setUseCaches(false); // 禁止缓存
            urlConn.setInstanceFollowRedirects(true);   //自动执行HTTP重定向
            urlConn.setRequestProperty("Content-Type",
                    "application/json"); // 设置内容类型
            DataOutputStream out = new DataOutputStream(
                    urlConn.getOutputStream()); // 获取输出流
            out.writeBytes(content);//将要传递的数据写入数据输出流
            out.flush();    //输出缓存
            out.close();    //关闭数据输出流
            // 判断是否响应成功
            if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in = new InputStreamReader(
                        urlConn.getInputStream()); // 获得读取的内容
                BufferedReader buffer = new BufferedReader(in); // 获取输入流对象
                String inputLine = null;
                while ((inputLine = buffer.readLine()) != null) {
                    result += inputLine + "\n";
                }
                in.close(); //关闭字符输入流
            }
            urlConn.disconnect();
        } catch (MalformedURLException e) {
            Log.e(TAG, target, e);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, target, e);
        } catch (ProtocolException e) {
            Log.e(TAG, target, e);
        } catch (IOException e) {
            Log.e(TAG, target, e);
        }

        Log.d(TAG,target+"?"+content+"===>result=="+result);
        return result;
    }


    public static String doGet(String target,String params) {
        Log.d(TAG,target+"?"+params);
        String result="";
        try {
            URL url = new URL(target+"?"+params);
            HttpURLConnection urlConn = (HttpURLConnection) url
                    .openConnection();
            // 判断是否响应成功
            if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in = new InputStreamReader(
                        urlConn.getInputStream()); // 获得读取的内容
                BufferedReader buffer = new BufferedReader(in); // 获取输入流对象
                String inputLine = null;
                while ((inputLine = buffer.readLine()) != null) {
                    result += inputLine + "\n";
                }
                in.close(); //关闭字符输入流
            }
            urlConn.disconnect();
        } catch (MalformedURLException e) {
            Log.e(TAG, target, e);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, target, e);
        } catch (ProtocolException e) {
            Log.e(TAG, target, e);
        } catch (IOException e) {
            Log.e(TAG, target, e);
        }

        Log.d(TAG,target+"?"+params+"===>result=="+result);
        return result;
    }
}
