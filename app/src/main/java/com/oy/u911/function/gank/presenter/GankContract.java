package com.oy.u911.function.gank.presenter;

import com.oy.u911.function.gank.bean.GankNewsBean;

import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/28 9:31
 * Describe :
 */

public interface GankContract {
    interface View {
        void setPageState(boolean isLoading);
        void setListData(List<GankNewsBean> listData);
    }
    interface Presenter {
        void onViewCreate(String type);
    }
}
