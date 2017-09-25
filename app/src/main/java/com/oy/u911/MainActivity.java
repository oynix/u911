package com.oy.u911;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.oy.u911.adapter.StoryListAdapter;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.m.DailyNewsJson;
import com.oy.u911.p.MainContract;
import com.oy.u911.p.MainPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity implements MainContract.View, StoryListAdapter.OnChildClickListener {

    MainPresenter mPresenter = new MainPresenter(this);

    @InjectView(R.id.story_list)
    RecyclerView mRecyclerView;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mPresenter.loadLatestNews();
    }

    @Override
    public void setDailyListData(DailyNewsJson dailyData) {
        StoryListAdapter adapter = new StoryListAdapter(this, dailyData);
        adapter.setOnChildClickListener(this);
        mRecyclerView.setAdapter(adapter);
    }


    /** RecyclerView 点击监听 */
    @Override
    public void onChildClick(DailyNewsJson.Story story) {
        Toast.makeText(getApplicationContext(), "RecyclerView点击:" + story.getStoryTitle(), Toast.LENGTH_SHORT).show();
        if (story != null) {
            StoryDetailActivity.loadDetail(this, story);
        }
    }
}
