package com.oy.u911.function.gank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.gank.bean.GankNewsBean;
import com.oy.u911.util.DataHub;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/28 17:18
 * Describe : 浏览图片
 */

public class BrowserImageActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    public static final String BROWSER_DATA_KEY = "browser_data_key";
    public static final String BROWSER_POSITION_KEY = "browser_position_key";

    public static void browser(Context context, String dataHubKey, int position) {
        Intent intent = new Intent(context, BrowserImageActivity.class);
        intent.putExtra(BROWSER_DATA_KEY, dataHubKey);
        intent.putExtra(BROWSER_POSITION_KEY, position);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @InjectView(R.id.browser_image_viewpager)
    ViewPager mViewPager;

    @InjectView(R.id.browser_image_toolbar)
    Toolbar mToolbar;

    private List<GankNewsBean> mDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_image);

        ButterKnife.inject(this);

        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        Intent intent = getIntent();
        if (intent != null) {
            mDataList = (List<GankNewsBean>) DataHub.get(intent.getStringExtra(BROWSER_DATA_KEY));
            int position = intent.getIntExtra(BROWSER_POSITION_KEY, 0);

            mViewPager.setAdapter(new BrowserPagerAdapter());
            mViewPager.addOnPageChangeListener(this);
            mViewPager.setCurrentItem(position);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mToolbar.setTitle((position + 1) + " / " + mDataList.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private class BrowserPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mDataList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(BrowserImageActivity.this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            GankNewsBean item = mDataList.get(position);
            Glide.with(BrowserImageActivity.this).load(item.getUrl()).asBitmap().into(imageView);
            container.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int visibility = mToolbar.getVisibility();
                    mToolbar.setVisibility(visibility == View.VISIBLE ? View.GONE : View.VISIBLE);
                }
            });

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
