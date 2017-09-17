package com.oy.u911.p;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.oy.u911.m.DailyNewsJson;
import com.oy.u911.m.StartImageJson;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 17:15
 * Describe :
 */

public class Presenter implements Contract.Presenter {

    private static final String TAG = "presenter";
    public static final String BASE_URL = "http://news-at.zhihu.com/api/4/";

    private Contract.View mView;
    private final URLService mUrlService;

    public Presenter(Contract.View view) {
        mView = view;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mUrlService = retrofit.create(URLService.class);
    }

    @Override
    public void loadStartImage() {
        mUrlService.getStartImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StartImageJson>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(StartImageJson value) {
                        if (null != value) {
                            Log.e(TAG, value.toString());
                        } else {
                            Log.e(TAG, "加载启动图片返回结果为null");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                        e.printStackTrace();
                        if (e instanceof NullPointerException) {
                            Log.e(TAG, "服务器返回结果为null");
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                    }
                });
    }

    @Override
    public void loadLatestNews() {
        mUrlService.getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyNewsJson>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DailyNewsJson value) {
                        mView.setListData(value.getDailyStories());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
