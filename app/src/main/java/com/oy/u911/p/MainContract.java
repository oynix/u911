package com.oy.u911.p;

import com.oy.u911.m.DailyNewsJson;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 10:30
 * Describe :
 */

public interface MainContract {
    interface View {
        void setDailyListData(DailyNewsJson topStoryData);
    }

    interface Presenter {
        void loadStartImage();
        void loadLatestNews();
    }
}
