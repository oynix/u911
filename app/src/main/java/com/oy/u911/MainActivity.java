package com.oy.u911;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.zhihu_daily.ZhihuIndexActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/26 14:04
 * Describe :
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.main_entrance_zhihu)
    void onZhihuClick(View v) {
        startActivity(new Intent(this, ZhihuIndexActivity.class));
    }
}
