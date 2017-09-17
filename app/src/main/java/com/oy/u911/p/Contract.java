package com.oy.u911.p;

import com.oy.u911.m.DailyNewsJson;

import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 10:30
 * Describe :
 */

public interface Contract {
    interface View {
        void setListData(List<DailyNewsJson.Story> storyList);
    }

    interface Presenter {
        void loadStartImage();
        void loadLatestNews();
    }
}
