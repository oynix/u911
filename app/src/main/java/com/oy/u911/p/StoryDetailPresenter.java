package com.oy.u911.p;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.oy.u911.base.BaseRequestable;
import com.oy.u911.m.DailyNewsJson;
import com.oy.u911.m.NewsDetailJson;
import com.oy.u911.util.Loger;

import java.io.Serializable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.oy.u911.StoryDetailActivity.STORY_DATA_KEY;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/25 19:14
 * Describe :
 */

public class StoryDetailPresenter extends BaseRequestable implements StoryDetailContract.Presenter {

    private static final String TAG = StoryDetailPresenter.class.getSimpleName();

    private StoryDetailContract.View mView;

    public StoryDetailPresenter(StoryDetailContract.View view) {
        mView = view;
    }

    @Override
    public void loadStory(@NonNull Intent intent) {
        Serializable data = intent.getBundleExtra(STORY_DATA_KEY).getSerializable(STORY_DATA_KEY);
        if (data == null) {
            mView.showError();
        } else {
            DailyNewsJson.Story story = (DailyNewsJson.Story) data;
            mUrlService.getNewsDetail(story.getStoryId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<NewsDetailJson>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(NewsDetailJson value) {
                            Loger.d(TAG, value.toString());
                            mView.setTitleImage(value.getImage());
                            mView.setCopyright(value.getImageSource());
                            mView.setContent(value);
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
}
