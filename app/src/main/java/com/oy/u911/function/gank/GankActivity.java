package com.oy.u911.function.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/26 13:46
 * Describe :
 */

public class GankActivity extends BaseActivity {

    @InjectView(R.id.gank_toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.gank_view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnak_io);

        ButterKnife.inject(this);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickFinishListener);
    }
}
