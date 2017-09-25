package com.oy.u911.p;

import android.util.Log;

import com.oy.u911.base.BaseRequestable;
import com.oy.u911.m.DailyNewsJson;
import com.oy.u911.m.StartImageJson;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 17:15
 * Describe :
 */

public class MainPresenter extends BaseRequestable implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
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
                        mView.setDailyListData(value);
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
