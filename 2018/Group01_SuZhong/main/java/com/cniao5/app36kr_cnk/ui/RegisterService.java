package com.cniao5.app36kr_cnk.ui;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterService {
    public static int register(String username, String password) {
        try {
            String path = "http://10.22.31.52/APP/register.php?username=" + username + "&password=" + password;
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            int code = conn.getResponseCode();

            if(code == 200) {
                //读取网页返回的数据
                //读取网页返回的数据
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(conn.getInputStream()));//获得输入流
                String line="";
                StringBuilder sb=new StringBuilder();//建立输入缓冲区
                while (null!=(line=bufferedReader.readLine())){//结束会读入一个null值
                    sb.append(line);//写缓冲区
                }
                String result= sb.toString();//返回结果
                //Log.i("my", result);
                //Log.i("my", "runrunrun");
                //登陆成功，result=1;失败,result=0;
                return Integer.parseInt(result);
            }else return 0;



        } catch (Exception e) {
            e.printStackTrace();
            Log.i("my",e.toString());
            return 0;
        }
    }
}
