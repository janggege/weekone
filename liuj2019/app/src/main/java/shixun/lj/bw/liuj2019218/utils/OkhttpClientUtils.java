package shixun.lj.bw.liuj2019218.utils;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/*
  name:刘江
  data:2019  单例模式  懒汉式
*/public class OkhttpClientUtils {
    private static OkhttpClientUtils okhttpClientUtils = null;

    private static OkhttpClientUtils getinstanse() {
        if (okhttpClientUtils == null) {
            synchronized (OkhttpClientUtils.class) {
                if (okhttpClientUtils == null) {
                    okhttpClientUtils = new OkhttpClientUtils();
                }
            }

        }
        return okhttpClientUtils;
    }

    //封装get请求
    public static void doGet(String url, Callback callback) {
        //创建日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("aaaa", message);
            }
        });
        //指定日志拦截器模式
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建 okhttpclient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Request build = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(callback);

    }

    //封装post请求
    public static void doPost(String url, Callback callback) {
        //创建日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("aaaa", message);
            }
        });
        //指定日志拦截器模式
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建 okhttpclient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        FormBody build = new FormBody.Builder()
                .build();
        Request build1 = new Request.Builder()
                .url(url)
                .post(build)
                .build();
        Call call = okHttpClient.newCall(build1);
        call.enqueue(callback);


    }
}
