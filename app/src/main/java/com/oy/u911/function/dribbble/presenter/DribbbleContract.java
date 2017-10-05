package com.oy.u911.function.dribbble.presenter;

import com.oy.u911.function.dribbble.model.ShotJson;

import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 19:51
 * Describe :
 */

public interface DribbbleContract {
    interface View {
        void setListData(List<ShotJson> data);
    }

    interface Presenter {
        void loadData();
    }
}
