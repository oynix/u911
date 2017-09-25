package com.oy.u911.base;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/25 19:00
 * Describe : 请求的基类
 */

public class BaseRequestable {

    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/";

    protected final URLService mUrlService;

    public BaseRequestable() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mUrlService = retrofit.create(URLService.class);
    }
}
