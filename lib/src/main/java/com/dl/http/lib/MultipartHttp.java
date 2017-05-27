package com.dl.http.lib;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 第五课 multipart上传图片
 * Created by dl on 2017/5/27.
 */
public class MultipartHttp {

    public static void main(String[] args){

        RequestBody imageBody = RequestBody.create(MediaType.parse("image/png"),new File("C:\\Users\\jq\\Desktop\\welcome.png"));
        MultipartBody body = new MultipartBody.Builder()
                .addFormDataPart("name","dl")
                .addFormDataPart("filename","welcome.png",imageBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8080/web/UpLoadServlet").post(body).build();
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
