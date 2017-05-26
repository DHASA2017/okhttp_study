package com.dl.http.lib;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 第四课 get请求
 * Created by dl on 2017/5/26.
 */
public class GetHttp {

    public static void main(String[] args){
        OkHttpClient client = new OkHttpClient();
        HttpUrl httpUrl = HttpUrl.parse("https://free-api.heweather.com/v5/weather").newBuilder()
                .addQueryParameter("city","beijing")
                .addQueryParameter("key","4e043dcf4da04418a22d68ce87a22b3b").build();
        String url = httpUrl.toString();
        System.out.println(url);
        Request request = new Request.Builder().url(url).build();
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
