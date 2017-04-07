package com.xxp.jiyi.pro.api;

import com.xxp.jiyi.pro.entity.WeatherData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 钟大爷 on 2017/3/27.
 *
 */
//http://route.showapi.com/9-9/?showapi_appid=34464&showapi_sign=bcb12488a0ba41e6beedf475ee2ab2ec&area=%E9%83%AB%E5%8E%BF
public interface WeatherAPI {
    String BASE_URL = "http://route.showapi.com/9-9/";
    @GET("?showapi_appid=34464&showapi_sign=bcb12488a0ba41e6beedf475ee2ab2ec")
    Observable<WeatherData> getWeather(@Query("area") String name);
}
