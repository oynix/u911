package com.oy.u911.function.gank;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.gank.adapter.GankViewPagerAdapter;
import com.oy.u911.function.gank.fragment.GankFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/26 13:46
 * Describe :
 */

public class GankActivity extends BaseActivity {

    @BindView(R.id.gank_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.gank_view_pager)
    ViewPager mViewPager;

    @BindView(R.id.gank_tablayout)
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
        setContentView(R.layout.activity_gnak);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        // 全部缓存
        mViewPager.setOffscreenPageLimit(8);
        GankViewPagerAdapter adapter = new GankViewPagerAdapter(getSupportFragmentManager(), mFragmentType);
        mViewPager.setAdapter(adapter);
    }
}
