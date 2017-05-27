package com.dl.http.lib;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 第五课 post请求
 * Created by dl on 2017/5/26.
 */
public class PostOkhttp {

    public static void main(String[] args){
        OkHttpClient client = new OkHttpClient();
        FormBody body = new FormBody.Builder().add("username","dl").add("userage","26").build();
        Request request = new Request.Builder().url("http://localhost:8080/web/HelloServlet").post(body).build();
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
