package com.oy.u911.function.gank.presenter;

import com.oy.u911.base.BaseRequestable;
import com.oy.u911.function.gank.service.GankURLService;
import com.oy.u911.function.gank.bean.GankResponseBean;
import com.oy.u911.util.Loger;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/28 10:20
 * Describe :
 */

public class GankPresenter extends BaseRequestable<GankURLService> implements GankContract.Presenter {

    private static final String TAG = GankPresenter.class.getSimpleName();

    private final GankContract.View mView;

    public GankPresenter(GankContract.View view) {
        super(GankURLService.class, GankURLService.BASE_URL);
        mView = view;
    }

    @Override
    public void onViewCreate(String type) {
        onViewCreate(type, 40);
    }

    @Override
    public void onViewCreate(String type, int count) {
        mView.setPageState(true);
//        mUrlService.requestData(type, count, 1)
        mUrlService.requestRandomData(type, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankResponseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GankResponseBean value) {
                        Loger.d(TAG, value.toString());
                        mView.setListData(value.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Loger.d(TAG, e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
