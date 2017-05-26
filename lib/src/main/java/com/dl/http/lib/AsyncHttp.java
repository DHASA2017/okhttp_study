package com.dl.http.lib;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 第二课 同步异步请求
 * Created by dl on 2017/5/26.
 */
public class AsyncHttp {

    public static final String URL_REQUEST = "http://www.imooc.com";

    public static void main(String[] args){
//        sendRequestSync(URL_REQUEST);
        sendRequestAsync(URL_REQUEST);
    }

    public static void sendRequestSync(String url){
        OkHttpClient client = new OkHttpClient();
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

    public static void sendRequestAsync(String url){
        System.out.println(Thread.currentThread().getId());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {//异步自然是要接口回调中去处理数据，跟同步阻塞不一样呢（实现接口的具体方法）
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    System.out.println(Thread.currentThread().getId());
                    System.out.println(response.body().string());
                }
            }
        });
    }
}
