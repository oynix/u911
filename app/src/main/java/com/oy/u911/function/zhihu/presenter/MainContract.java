package com.oy.u911.function.zhihu.presenter;

import com.oy.u911.function.zhihu.model.DailyNewsJson;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 10:30
 * Describe :
 */

public interface MainContract {
    interface View {
        void setDailyListData(DailyNewsJson topStoryData);
        void showError();
    }

    interface Presenter {
        void loadStartImage();
        void loadLatestNews();
    }
}
