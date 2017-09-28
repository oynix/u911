package com.oy.u911.function.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.gank.adapter.GankViewPagerAdapter;
import com.oy.u911.function.gank.fragment.GankFragment;

import java.util.ArrayList;
import java.util.List;

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

    @InjectView(R.id.gank_tablayout)
    TabLayout mTabLayout;

    private List<String> mFragmentType = new ArrayList<String>(){
        {
            add(GankFragment.GANK_FRAGMENT_TYPE_ANDROID);
            add(GankFragment.GANK_FRAGMENT_TYPE_IOS);
            add(GankFragment.GANK_FRAGMENT_TYPE_QIANDUAN);
            add(GankFragment.GANK_FRAGMENT_TYPE_FULI);
            add(GankFragment.GANK_FRAGMENT_TYPE_XIATUIJIAN);
            add(GankFragment.GANK_FRAGMENT_TYPE_XIUXISHIPIN);
            add(GankFragment.GANK_FRAGMENT_TYPE_TUOZHANZIYUAN);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnak_io);

        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        // 全部缓存
        mViewPager.setOffscreenPageLimit(8);
        GankViewPagerAdapter adapter = new GankViewPagerAdapter(getSupportFragmentManager(), mFragmentType);
        mViewPager.setAdapter(adapter);
    }
}
