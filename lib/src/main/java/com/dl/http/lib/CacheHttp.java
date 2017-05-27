package com.dl.http.lib;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 第六课 缓存
 * Created by dl on 2017/5/27.
 */
public class CacheHttp {

    public static void main(String[] args) throws IOException {
        int maxSize = 10 * 1024 * 1024;
        Cache cache = new Cache(new File("C:\\Users\\jq\\Desktop\\test"),maxSize);
        OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();
        Request request = new Request.Builder().url("http://www.qq.com").build();
        Response response = client.newCall(request).execute();
//        if(response.isSuccessful()){
            String result = response.body().string();
            System.out.println("network response :"+response.networkResponse());
            System.out.println("cache response :"+response.cacheResponse());
//        }
        System.out.println("=============================================");
        Response response1 = client.newCall(request).execute();
//        if(response1.isSuccessful()){
            String result1 = response1.body().string();
            System.out.println("network response :"+response1.networkResponse());
            System.out.println("cache response :"+response1.cacheResponse());
//        }
    }
}
