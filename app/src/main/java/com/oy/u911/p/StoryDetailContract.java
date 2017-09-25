package com.oy.u911.p;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.oy.u911.m.NewsDetailJson;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/25 19:07
 * Describe :
 */

public interface StoryDetailContract {
    interface View {
        void setTitleImage(String url);
        void setCopyright(String copyright);
        void setContent(NewsDetailJson content);
        void showError();
    }

    interface Presenter {
        void loadStory(@NonNull Intent intent);
    }
}
