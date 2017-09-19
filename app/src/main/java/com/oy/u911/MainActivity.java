package com.oy.u911;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.oy.u911.adapter.StoryListAdapter;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.m.DailyNewsJson;
import com.oy.u911.p.Contract;
import com.oy.u911.p.Presenter;

public class MainActivity extends BaseActivity implements Contract.View, StoryListAdapter.OnChildClickListener {

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
    public void onChildClick(View v, int position) {
        Toast.makeText(getApplicationContext(), "RecyclerView点击:" + position, Toast.LENGTH_SHORT).show();
    }
}
