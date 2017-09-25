package com.oy.u911;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.oy.u911.base.BaseActivity;
import com.oy.u911.m.DailyNewsJson;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/25 14:42
 * Describe : Story详情页
 */

public class StoryDetailActivity extends BaseActivity {

    private static final String STORY_DATA_KEY = "story_data";

    public static void loadDetail(Context context, @NonNull DailyNewsJson.Story story) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(STORY_DATA_KEY, story);
        Intent intent = new Intent(context, StoryDetailActivity.class);
        intent.putExtra(STORY_DATA_KEY, story);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(mClickFinishListener);
    }

}
