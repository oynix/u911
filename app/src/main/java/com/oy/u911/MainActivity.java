package com.oy.u911;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.oy.u911.adapter.StoryListAdapter;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.m.DailyNewsJson;
import com.oy.u911.p.Contract;
import com.oy.u911.p.Presenter;

import java.util.List;

public class MainActivity extends BaseActivity implements Contract.View {

    Presenter mPresenter = new Presenter(this);
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.story_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mPresenter.loadStartImage();
        mPresenter.loadLatestNews();
    }

    @Override
    public void setTopStoryData(List<DailyNewsJson.Story> topStoryData) {
        
    }

    @Override
    public void setListData(List<DailyNewsJson.Story> storyList) {
        mRecyclerView.setAdapter(new StoryListAdapter(this, storyList));
    }
}
