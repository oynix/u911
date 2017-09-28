package com.oy.u911.base;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/25 19:00
 * Describe : 请求的基类
 */

public abstract class BaseRequestable<T> {

    protected final T mUrlService;

    public BaseRequestable(Class<T> cls) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mUrlService = retrofit.create(cls);
    }

    protected abstract String getBaseUrl();
}
