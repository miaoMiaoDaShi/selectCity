package com.xxp.jiyi.pro.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 钟大爷 on 2017/3/27.
 */

public class APIEngine {
    //超时时间,单位秒
    private static final int DEFAULT_TIMEOUT = 10000;
    private Retrofit mRetrofit;

    private APIEngine() {
        OkHttpClient client = new OkHttpClient
                .Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        mRetrofit = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(WeatherAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static APIEngine getInstance() {
        return Singleton.apiEngine;
    }

    private static class Singleton {
        public static APIEngine apiEngine = new APIEngine();
    }

    public WeatherAPI getWeatherService() {
        return mRetrofit.create(WeatherAPI.class);
    }
}
