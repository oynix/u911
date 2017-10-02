package com.oy.u911.function.dribbble;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.dribbble.presenter.DribbbleContract;
import com.oy.u911.function.dribbble.presenter.DribbblePresenter;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 11:45
 * Describe :
 */

public class DribbbleActivity extends BaseActivity implements DribbbleContract.View{

    private DribbblePresenter mPresenter = new DribbblePresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.loadData();
    }
}
