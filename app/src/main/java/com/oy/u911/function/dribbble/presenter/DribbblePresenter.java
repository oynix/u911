package com.oy.u911.function.dribbble.presenter;

import com.oy.u911.base.BaseRequestable;
import com.oy.u911.function.dribbble.model.ShotJson;
import com.oy.u911.function.dribbble.service.DribbbleURLService;
import com.oy.u911.util.Loger;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.oy.u911.function.dribbble.service.DribbbleURLService.DRIBBBLE_BASE_URL;
import static com.oy.u911.function.dribbble.service.DribbbleURLService.PARAM_LIST_ANIMATED;
import static com.oy.u911.function.dribbble.service.DribbbleURLService.PARAM_SORT_VIEWS;
import static com.oy.u911.function.dribbble.service.DribbbleURLService.PARAM_TIME_FRAME_WEEK;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 20:02
 * Describe :
 */

public class DribbblePresenter extends BaseRequestable<DribbbleURLService> implements DribbbleContract.Presenter {

    private static final String TAG = DribbblePresenter.class.getSimpleName();

    private DribbbleContract.View mView;

    public DribbblePresenter(DribbbleContract.View view) {
        super(DribbbleURLService.class, DRIBBBLE_BASE_URL);
        mView = view;
    }

    @Override
    public void loadData() {
        mUrlService.getShots(PARAM_LIST_ANIMATED, PARAM_TIME_FRAME_WEEK, null, PARAM_SORT_VIEWS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ShotJson>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<ShotJson> value) {
                        Loger.e(TAG, value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Loger.e(TAG, e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Loger.e(TAG, "onComplete");
                    }
                });
    }
}
